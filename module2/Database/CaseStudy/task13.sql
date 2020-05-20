select Ten_DichVuDiKem as TenDV,sum(So_luong)as 'Tổng sô'
from HopDongChiTiet

         join Dich_Vu_Di_Kem DVDK on HopDongChiTiet.ID_DichVuDiKem = DVDK.ID_DichVuDiKem
group by Ten_DichVuDiKem
order by `Tổng sô` desc
limit 1;

select Ten_DichVuDiKem as TenDV, (sum(So_luong)) as 'Tổng sô'
from HopDongChiTiet
         join Dich_Vu_Di_Kem DVDK on HopDongChiTiet.ID_DichVuDiKem = DVDK.ID_DichVuDiKem
group by Ten_DichVuDiKem
having sum(So_luong) = (select max(SUM)
                        from (select (sum(So_luong)) as 'SUM'
                              from HopDongChiTiet
                                       join Dich_Vu_Di_Kem DVDK on HopDongChiTiet.ID_DichVuDiKem = DVDK.ID_DichVuDiKem
                              group by Ten_DichVuDiKem) s)
;