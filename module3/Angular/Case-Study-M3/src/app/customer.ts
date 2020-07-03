export class Customer {
  id: number;
  maKhachHang: string;
  loaiKhachHang: any;
  tenKhachHang: string;
  ngaySinh: string;
  gioiTinh: string;
  soCmnd: string;
  soDienThoai: string;
  email: string;
  diaChi: string;

  constructor(id: number, maKhachHang: string, loaiKhachHang: any, tenKhachHang: string, ngaySinh: string, gioiTinh: string,
              soCmnd: string, soDienThoai: string, email: string, diaChi: string) {
    this.id = id;
    this.maKhachHang = maKhachHang;
    this.loaiKhachHang = loaiKhachHang;
    this.tenKhachHang = tenKhachHang;
    this.ngaySinh = ngaySinh;
    this.gioiTinh = gioiTinh;
    this.soCmnd = soCmnd;
    this.soDienThoai = soDienThoai;
    this.email = email;
    this.diaChi = diaChi;
  }
}
