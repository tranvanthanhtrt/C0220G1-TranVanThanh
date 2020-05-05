select KhachHang.ID_KhachHang,
       Ho_Ten,
       Ten_LoaiKhach,
       HD.ID_HopDong,
       Ten_DichVu,
       Ngay_lam_hop_dong,
       Ngay_ket_thuc,
       (Chi_phi_thue+So_luong*Gia)as 'Tổng tiền'
from KhachHang
         left join HopDong HD on KhachHang.ID_KhachHang = HD.ID_KhachHang
         left join DichVu DV on HD.ID_DichVu = DV.ID_DichVu
         join LoaiKhach LK on KhachHang.ID_LoaiKhach = LK.ID_LoaiKhach
         left join HopDongChiTiet HDCT on HD.ID_HopDong = HDCT.ID_HopDong
         left join Dich_Vu_Di_Kem DVDK on HDCT.ID_DichVuDiKem = DVDK.ID_DichVuDiKem