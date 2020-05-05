select HopDongChiTiet.ID_HopDong,Ngay_lam_hop_dong,Ngay_ket_thuc,Tien_dat_coc,sum(So_luong) as 'Số lượng dịch vụ đi kèm'
from HopDongChiTiet
join HopDong on HopDongChiTiet.ID_HopDong = HopDong.ID_HopDong
group by HopDong.ID_HopDong
order by HopDong.ID_HopDong;