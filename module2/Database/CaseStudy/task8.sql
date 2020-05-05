
select distinct Ho_Ten
from KhachHang;

select Ho_Ten
from KhachHang
UNION select Ho_Ten from KhachHang;
select Ho_Ten
from KhachHang
group by Ho_Ten;