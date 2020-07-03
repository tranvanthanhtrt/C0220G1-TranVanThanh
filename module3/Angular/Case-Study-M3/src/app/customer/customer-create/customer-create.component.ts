import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {CustomerService} from '../../customer.service';
import {MatSnackBar} from '@angular/material/snack-bar';
import {LoaiKhach} from '../../loaiKhach';
import * as $ from 'jquery';
import {APP_DATE_FORMATS, AppDateAdapter} from '../../format-datepicker';
import {DateAdapter, MAT_DATE_FORMATS} from '@angular/material/core';
import {Customer} from '../../customer';

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.scss'],
  providers: [
    {
      provide: DateAdapter, useClass: AppDateAdapter
    },
    {
      provide: MAT_DATE_FORMATS, useValue: APP_DATE_FORMATS
    }
  ]

})

export class CustomerCreateComponent implements OnInit {
  customerForm: FormGroup;
  message: string;
  loaiKhach: LoaiKhach[];
  customerList: Customer[] = [];
  tenDung = '';

  constructor(private customerService: CustomerService,
              private router: Router,
              private formBuilder: FormBuilder,
              private _snackBar: MatSnackBar,
  ) {
    this.customerService.findAll().subscribe(
      next => {
        this.customerList = next;
        console.log(this.customerList);
      },
      error => {
        console.log(error);
        this.customerList = [];
      });
    this.customerService.findAllLoaiKhach().subscribe(
      next => {
        this.loaiKhach = next;
      },
      error => {
        console.log(error);
      }
    );
  }

  ngOnInit(): void {

    this.customerForm = this.formBuilder.group({
      maKhachHang: ['', [Validators.required, this.confirmMaKhachHang.bind(this)]],
      tenKhachHang: [''],
      loaiKhachHang: ['', Validators.required],
      ngaySinh: ['', Validators.required],
      gioiTinh: ['', Validators.required],
      soCmnd: [''],
      soDienThoai: [''],
      email: ['', Validators.pattern('^[a-z][a-z0-9_.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$')],
      diaChi: [''],
    });
  }

  openSnackBar(message: string, action: string) {
    this._snackBar.open(message, action, {
      duration: 4000,
    });
  }

  getLoaiKhachHang(id: string): string {
    switch (id) {
      case '1': {
        return 'Gold';
      }
      case '2': {
        return 'Silver';
      }
      case '3': {
        return 'Member';
      }


    }
  }

  onSubmit() {
    this.customerForm.markAllAsTouched();
    if (this.customerForm.valid) {
      const idLoaiKhach = this.customerForm.value.loaiKhachHang;
      this.customerForm.patchValue({
        loaiKhachHang: this.loaiKhach[idLoaiKhach - 1]
      });
      const {value} = this.customerForm;
      this.customerService.creatCustomer(value).subscribe(
        next => {
          this.openSnackBar('Thêm khách hàng ' + this.customerForm.get('tenKhachHang').value + ' thành công', '');
          this.message = 'Thêm mới khách hàng thành công';
        },
        error => {
          console.log(error);
        }
      );
    } else {
      this.message = 'Có lỗi';
    }
  }

  confirmMaKhachHang(c: AbstractControl) {
    let exist = false;
    const a = c.value;
    for (let customer of this.customerList) {
      if (customer.maKhachHang === a) {
        exist = true;
      }
    }
    console.log(exist);

    console.log(a);
    return (!exist) ?
      null : {
        maKhachHangHasExist: true
      };
  }

}
