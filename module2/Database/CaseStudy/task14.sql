select HopDongChiTiet.ID_HopDong, Ten_LoaiDichVu, DVDK.Ten_DichVuDiKem, (ID_HopDongChiTiet), So_luong
from HopDongChiTiet
         join Dich_Vu_Di_Kem DVDK on HopDongChiTiet.ID_DichVuDiKem = DVDK.ID_DichVuDiKem
         join HopDong HD on HopDongChiTiet.ID_HopDong = HD.ID_HopDong
         join DichVu DV on HD.ID_DichVu = DV.ID_DichVu
         join LoaiDichVu LDV on DV.ID_LoaiDichVu = LDV.ID_LoaiDichVu
         join (select Ten_DichVuDiKem, sum(So_luong)
               from HopDongChiTiet
                        join Dich_Vu_Di_Kem DVDK on HopDongChiTiet.ID_DichVuDiKem = DVDK.ID_DichVuDiKem

               group by Ten_DichVuDiKem
               having sum(So_luong) = 1) s on s.Ten_DichVuDiKem = DVDK.Ten_DichVuDiKem
;