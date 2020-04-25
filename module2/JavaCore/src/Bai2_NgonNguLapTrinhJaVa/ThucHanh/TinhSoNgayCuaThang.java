package Bai2_NgonNguLapTrinhJaVa.ThucHanh;

import java.util.Scanner;

public class TinhSoNgayCuaThang {
    public static void main(String[] args) {
        System.out.println("Nhap so thang:");
        Scanner scanner=new Scanner(System.in);
        int month=scanner.nextInt();
        switch (month){
            case 2:
                System.out.println("Thang 2 co 29 hoac 28 ngay" );
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("thang "+month+" co 31 ngay");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("thang "+month+" co 30 ngay");
                break;
            default:
                System.out.println("Vui long nhap dung!");

        }
    }
}
