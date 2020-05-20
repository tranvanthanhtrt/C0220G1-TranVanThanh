
update Dich_Vu_Di_Kem
    join
    (select Ten_DichVuDiKem, sum(So_luong)
     from HopDongChiTiet
              join Dich_Vu_Di_Kem DVDK on HopDongChiTiet.ID_DichVuDiKem = DVDK.ID_DichVuDiKem
    join HopDong HD on HopDongChiTiet.ID_HopDong = HD.ID_HopDong
    where year(Ngay_lam_hop_dong)=2019
     group by Ten_DichVuDiKem
     having sum(So_luong) >= 10) s on s.Ten_DichVuDiKem = Dich_Vu_Di_Kem.Ten_DichVuDiKem
set Gia=Gia * 2
;