select * from Furama.NhanVien
where (Ho_ten like 'H%' or Ho_ten like 'T%' or Ho_ten like 'K%') and length(Ho_ten)<=15 ;