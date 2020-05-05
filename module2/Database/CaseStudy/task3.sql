select *,ROUND(DATEDIFF(CURDATE(), Ngay_sinh) /365,0)as 'Tuổi' from Furama.NhanVien
WHERE (ROUND(DATEDIFF(CURDATE(), Ngay_sinh) /365,0) BETWEEN 18 and 50) and Dia_chi in('Đà Nẵng','Quảng Trị')