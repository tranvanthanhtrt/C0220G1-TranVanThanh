select Ho_Ten,count(HopDong.ID_KhachHang) as 'Số lần đặt Phòng'
from HopDong
join KhachHang on HopDong.ID_KhachHang = KhachHang.ID_KhachHang
join LoaiKhach on KhachHang.ID_LoaiKhach = LoaiKhach.ID_LoaiKhach
where Ten_LoaiKhach='Diamond'
group by Ho_Ten
