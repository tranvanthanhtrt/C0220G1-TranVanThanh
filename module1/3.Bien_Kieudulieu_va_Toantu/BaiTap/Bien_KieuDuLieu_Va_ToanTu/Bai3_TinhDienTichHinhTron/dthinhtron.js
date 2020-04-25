function dttron() {
let nhapbankinh = prompt('Nhap ban kinh hinh tron');
let bankinh=parseInt(nhapbankinh);
DT=bankinh*bankinh*3.14;
CV=bankinh*2*3.14;
document.writeln('Dien tich hinh tron: ' +DT +'<br/>');
document.writeln('chuvihinhtron: '+CV );
}