select month(Ngay_lam_hop_dong)as 'Doanh thu theo tháng trong 2019', count(ID_HopDong) as 'số hợp đồng'
from HopDong
where year(Ngay_lam_hop_dong)=2019
group by month(Ngay_lam_hop_dong)
order by month(Ngay_lam_hop_dong);