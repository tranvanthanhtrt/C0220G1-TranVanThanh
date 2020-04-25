function tinhdt() {
let chieudai;
let chieurong;
chieudai=prompt('Nhap chieu dai HCN');
chieurong=prompt('Nhap chieu rong HCN');
let DAI=parseInt(chieudai);
let RONG=parseInt(chieurong);
let DT=DAI*RONG;
document.write('Dien tich HCN co canh '+DAI +' va ' +RONG +' la : '+DT);
}