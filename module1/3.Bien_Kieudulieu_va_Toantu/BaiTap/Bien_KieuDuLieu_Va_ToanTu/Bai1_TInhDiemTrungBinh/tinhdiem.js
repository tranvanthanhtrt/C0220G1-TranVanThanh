function tinhdtb() {
let nhapdiemvatly;
let nhapdiemHoa;
let nhapdiemSinh;
nhapdiemvatly = prompt('Nhap diem Vat ly!');
nhapdiemHoa =prompt('Nhap diem Hoa!');
nhapdiemSinh = prompt('Nhap diem Sinh!');
let DVL=parseInt(nhapdiemvatly);
let DS =parseInt(nhapdiemSinh);
let DH = parseInt(nhapdiemHoa);
let DTB= (DVL+DH+DS)/3;
let TONGDIEM = DVL+DH+DS;
document.write('Diem trung binh la: '+DTB);
document.write('<br/>');
document.write('Tong diem la: '+TONGDIEM);

}