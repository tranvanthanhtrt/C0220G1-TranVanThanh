package Bai2_NgonNguLapTrinhJaVa.ThucHanh;

import java.util.Scanner;

public class SuDungToanTu {
    public static void main(String[] args) {
        float chieudai;
        float chieurong;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhap chieu dai:");
        chieudai=scanner.nextFloat();
        System.out.println("Nhap chieu rong");
        chieurong=scanner.nextFloat();
        System.out.println("Dien tich HCN la: "+chieudai*chieurong);

    }
}
