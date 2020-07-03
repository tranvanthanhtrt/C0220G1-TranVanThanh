import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CustomerService} from "../../customer.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {Customer} from "../../customer";
import {LoaiKhach} from "../../loaiKhach";
import {DateAdapter, MAT_DATE_FORMATS} from "@angular/material/core";
import {APP_DATE_FORMATS, AppDateAdapter} from "../../format-datepicker";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.scss'],
  providers: [
    {
      provide: DateAdapter, useClass: AppDateAdapter
    },
    {
      provide: MAT_DATE_FORMATS, useValue: APP_DATE_FORMATS
    }
  ]
})
export class CustomerEditComponent implements OnInit {
  customer: Customer;
  customerForm: FormGroup;
  message: string;
  loaiKhach: LoaiKhach[];

  constructor(
    private customerService: CustomerService,
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private formBuilder: FormBuilder,
    private _snackBar: MatSnackBar
  ) {
    this.customerService.findAllLoaiKhach().subscribe(
      next => {
        this.loaiKhach = next;
      },
      error => {
        console.log(error);
      }
    )
  }

  ngOnInit(): void {

    this.customerForm = this.formBuilder.group({
      id: [''],
      maKhachHang: ['', Validators.required],
      tenKhachHang: [''],
      loaiKhachHang: ['', Validators.required],
      ngaySinh: ['', Validators.required],
      gioiTinh: ['', Validators.required],
      soCmnd: [''],
      soDienThoai: [''],
      email: [''],
      diaChi: [''],
    });
    this.activatedRoute.paramMap.subscribe((param: ParamMap) => {
      const id = Number(param.get('id'));
      this.customerService.findById(id).subscribe(
        next => {
          this.customer = next;
          this.customerForm.patchValue(this.customer);
        },
        error => {
          console.log(error);
          this.customer = null;
        }
      )
    })

  }

  openSnackBar(message: string, action: string) {
    this._snackBar.open(message, action, {
      duration: 4000,
    });
  }

  onSubmit() {
    this.customerForm.markAllAsTouched();
    if (this.customerForm.valid) {
      const data = this.customerForm.value;
      const idLoaiKhach = data.loaiKhachHang;
      this.customerForm.patchValue({
        loaiKhachHang: this.loaiKhach[idLoaiKhach - 1]
      });
      this.customerService.updateCustomer(data).subscribe(
        next => {
          // alert('Cập nhật thông tin khách hàng  thành công');
          // this.router.navigate(['/customers',{message:'Cập nhật thông tin khách hàng thành công'}]);
          this.router.navigate(['/customers']);
          this.openSnackBar('Cập nhật thông tin khách hàng  thành công', 'Cập nhật');

        },
        error => console.log(error)
      )
    } else this.openSnackBar('Lỗi nhập dữ liệu', 'Cập nhật');
  }

}
