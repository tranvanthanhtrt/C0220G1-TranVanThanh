select  DV.ID_DichVu,
       Ten_DichVu,
       Dien_Tich,
       Chi_phi_thue,
       Ten_LoaiDichVu,
       Ngay_lam_hop_dong
from HopDong
         right join DichVu DV on HopDong.ID_DichVu = DV.ID_DichVu
         join LoaiDichVu LDV on DV.ID_LoaiDichVu = LDV.ID_LoaiDichVu
where not Ngay_lam_hop_dong <'2019-01-01' or Ngay_lam_hop_dong is null