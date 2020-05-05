select HopDong.ID_HopDong,NV.Ho_ten as'Tên Nhân Viên',KH.Ho_Ten as 'Tên Khách hàng',KH.So_DienThoai,Ten_DichVu,sum(So_luong) as 'Số lượng dịch vụ đi kèm',Tien_dat_coc
from HopDong
join DichVu DV on HopDong.ID_DichVu = DV.ID_DichVu
join HopDongChiTiet HDCT on HopDong.ID_HopDong = HDCT.ID_HopDong
join KhachHang KH on HopDong.ID_KhachHang = KH.ID_KhachHang
join NhanVien NV on HopDong.ID_NhanVien = NV.ID_NhanVien
group by HopDong.ID_HopDong
order by ID_HopDong
;
select Ten_DichVu,
       HopDong.ID_HopDong,
       NV.Ho_ten     as 'Tên Nhân Viên',
       KH.Ho_Ten     as 'Tên Khách hàng',
       KH.So_DienThoai,
       Ngay_lam_hop_dong,
       sum(So_luong) as 'số lượng DVDK',
       Tien_dat_coc
from HopDong
         join DichVu DV on HopDong.ID_DichVu = DV.ID_DichVu
         join HopDongChiTiet HDCT on HopDong.ID_HopDong = HDCT.ID_HopDong
         join KhachHang KH on HopDong.ID_KhachHang = KH.ID_KhachHang
         join NhanVien NV on HopDong.ID_NhanVien = NV.ID_NhanVien
where exists(select HopDong.ID_HopDong
             from HopDong
             where year(Ngay_lam_hop_dong) = 2019
               and month(Ngay_lam_hop_dong) in ('10', '11', '12')
               and HopDong.ID_DichVu = DV.ID_DichVu)
and not exists(select HopDong.ID_HopDong
    from HopDong
    where year(Ngay_lam_hop_dong)=2019
    and month(Ngay_lam_hop_dong) in ('1','2','3','4','5','6')
    and HopDong.ID_DichVu=DV.ID_DichVu)

group by HopDong.ID_HopDong
;