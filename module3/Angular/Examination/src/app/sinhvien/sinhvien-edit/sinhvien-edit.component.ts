import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {SinhVienService} from '../../sinhVien.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {SinhVien} from '../../sinhVien';
import {GiaoVien} from '../../giaoVien';
import {DateAdapter, MAT_DATE_FORMATS} from '@angular/material/core';
import {APP_DATE_FORMATS, AppDateAdapter} from '../../format-datepicker';
import {MatSnackBar} from '@angular/material/snack-bar';

@Component({
    selector: 'app-customer-edit',
    templateUrl: './sinhvien-edit.component.html',
    styleUrls: ['./sinhvien-edit.component.scss'],
    providers: [
        {
            provide: DateAdapter, useClass: AppDateAdapter
        },
        {
            provide: MAT_DATE_FORMATS, useValue: APP_DATE_FORMATS
        }
    ]
})
export class SinhvienEditComponent implements OnInit {
    sinhVien: SinhVien;
    sinhVienForm: FormGroup;
    message: string;
    giaoViens: GiaoVien[];

    constructor(
        private sinhVienService: SinhVienService,
        private router: Router,
        private activatedRoute: ActivatedRoute,
        private formBuilder: FormBuilder,
        private snackBar: MatSnackBar
    ) {
        this.sinhVienService.findAllLoaiKhach().subscribe(
            next => {
                this.giaoViens = next;
            },
            error => {
                console.log(error);
            }
        );
    }

    ngOnInit(): void {

        this.sinhVienForm = this.formBuilder.group({
            id: [''],
            ten_sinh_vien: ['', [Validators.required, Validators.pattern('^[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ\\ ]+$')]],
            giao_vien_huong_dan: ['', Validators.required],
            ten_nhom: ['', [Validators.required, Validators.pattern('^Nhóm\ 1|Nhóm\ 2|Nhóm\ 3')]],
            ten_de_tai: ['', Validators.required],
            so_dien_thoai: ['', [Validators.required, Validators.pattern('^([0-9]{10}|[0-9]{12})$')]],
            email: ['', [Validators.required, Validators.pattern('^[a-z][a-z0-9_.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$')]],
        });
        this.activatedRoute.paramMap.subscribe((param: ParamMap) => {
            const id = Number(param.get('id'));
            this.sinhVienService.findById(id).subscribe(
                next => {
                    this.sinhVien = next;
                    this.sinhVienForm.patchValue(this.sinhVien);
                },
                error => {
                    console.log(error);
                    this.sinhVien = null;
                }
            );
        });

    }

    openSnackBar(message: string, action: string) {
        this.snackBar.open(message, action, {
            duration: 4000,
        });
    }

    onSubmit() {
        this.sinhVienForm.markAllAsTouched();
        if (this.sinhVienForm.valid) {
            const data = this.sinhVienForm.value;
            this.sinhVienService.suaSinhVien(data).subscribe(
                next => {
                    // alert('Cập nhật thông tin khách hàng  thành công');
                    // this.router.navigate(['/customers',{message:'Cập nhật thông tin khách hàng thành công'}]);
                    this.router.navigate(['/sinhViens']);
                    this.openSnackBar('Cập nhật thông tin sinh viên  thành công', 'Cập nhật');

                },
                error => console.log(error)
            );
        } else {
            this.openSnackBar('Lỗi nhập dữ liệu', 'Cập nhật');
        }
    }

    troVe() {
        this.router.navigate(['/sinhViens']);
    }
}
