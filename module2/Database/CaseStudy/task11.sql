select  distinct  Ho_Ten,Ten_LoaiKhach,DiaChi,Ten_DichVuDiKem
from KhachHang
join LoaiKhach LK on KhachHang.ID_LoaiKhach = LK.ID_LoaiKhach
join HopDong HD on KhachHang.ID_KhachHang = HD.ID_KhachHang
join HopDongChiTiet HDCT on HD.ID_HopDong = HDCT.ID_HopDong
join Dich_Vu_Di_Kem DVDK on HDCT.ID_DichVuDiKem = DVDK.ID_DichVuDiKem
where DiaChi in('Quảng Trị','Đà Nẵng') and Ten_LoaiKhach='Diamond'
;