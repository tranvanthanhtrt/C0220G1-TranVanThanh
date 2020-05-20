select ID_KhachHang ID,Ho_Ten,Email,So_DienThoai,Ngay_sinh,DiaChi
from KhachHang
union
select ID_NhanVien,Ho_Ten,Email,So_DienThoai,Ngay_sinh,Dia_chi
from NhanVien;