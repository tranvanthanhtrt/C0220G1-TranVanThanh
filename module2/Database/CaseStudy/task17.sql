update KhachHang join
    (select Ho_Ten, Ten_LoaiKhach, SUM(Tong_tien)
     from KhachHang
              join HopDong HD on KhachHang.ID_KhachHang = HD.ID_KhachHang
              join LoaiKhach LK on KhachHang.ID_LoaiKhach = LK.ID_LoaiKhach
     where year(Ngay_lam_hop_dong) = 2019
       and Ten_LoaiKhach = 'Platinium'
     group by HD.ID_KhachHang
     having sum(Tong_tien) > 10000000
    ) s on s.Ho_Ten=KhachHang.Ho_Ten
set ID_LoaiKhach=1
where ID_LoaiKhach=2
;