
select ID_DichVu,
       Ten_DichVu,
       Dien_Tich,
       So_nguoi_toi_da,
       Chi_phi_thue,
       Ten_LoaiDichVu
from DichVu
join LoaiDichVu LDV on DichVu.ID_LoaiDichVu = LDV.ID_LoaiDichVu
where exists(select HopDong.ID_DichVu from HopDong where year(Ngay_lam_hop_dong)='2018' and HopDong.ID_DichVu=DichVu.ID_DichVu)
  and  not exists(select HopDong.ID_DichVu from HopDong where year(Ngay_lam_hop_dong)='2019' and HopDong.ID_DichVu=DichVu.ID_DichVu)
;