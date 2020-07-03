export class SinhVien {
    id: number;
    giao_vien_huong_dan: string;
    ten_sinh_vien: string;
    ten_nhom: string;
    ten_de_tai: string;
    so_dien_thoai: string;
    email: string;

    constructor(id: number, giao_vien_huong_dan: string, ten_sinh_vien: string, ten_nhom: string,
                ten_de_tai: string, so_dien_thoai: string, email: string) {
        this.id = id;
        this.giao_vien_huong_dan = giao_vien_huong_dan;
        this.ten_sinh_vien = ten_sinh_vien;
        this.ten_nhom = ten_nhom;
        this.ten_de_tai = ten_de_tai;
        this.so_dien_thoai = so_dien_thoai;
        this.email = email;
    }
}
