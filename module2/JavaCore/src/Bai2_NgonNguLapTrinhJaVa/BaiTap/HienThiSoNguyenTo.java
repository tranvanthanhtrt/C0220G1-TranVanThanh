package Bai2_NgonNguLapTrinhJaVa.BaiTap;

import java.util.Scanner;

public class HienThiSoNguyenTo {
    public static void main(String[] args) {
        System.out.println("Ban muon hien thi bao nhieu so nguyen to");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int dem = 0;
        StringBuilder dayso = new StringBuilder();
        for (int num = 2; dem < n; num++) {
            boolean laSoNguyenTo = true;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    laSoNguyenTo = false;
                    break;
                }
            }
            if(laSoNguyenTo){
                dem+=1;
                dayso.append(" "+num);

            }
        }
        System.out.println(dayso);

    }
}
