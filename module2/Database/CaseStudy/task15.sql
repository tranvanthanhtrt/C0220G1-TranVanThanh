select HD.ID_NhanVien,Ho_ten,Trinh_Do,Ten_BoPhan,So_DienThoai,Dia_chi,count(ID_HopDong)
from NhanVien
join TrinhDo TD on NhanVien.ID_TrinhDo = TD.ID_TrinhDo
join BoPhan BP on NhanVien.ID_BoPhan = BP.ID_BoPhan
join HopDong HD on NhanVien.ID_NhanVien = HD.ID_NhanVien
where year(Ngay_lam_hop_dong) between 2018 and 2019
group by HD.ID_NhanVien
having count(ID_HopDong)<=3
;