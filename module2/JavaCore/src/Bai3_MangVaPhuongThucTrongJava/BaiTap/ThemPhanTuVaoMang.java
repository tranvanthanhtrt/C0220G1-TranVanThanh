package Bai3_MangVaPhuongThucTrongJava.BaiTap;

import java.util.Random;
import java.util.Scanner;

public class ThemPhanTuVaoMang {
    public static void main(String[] args) {
        int[] a = createArray();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap so can chen vao mang");
        int x = scanner.nextInt();
        int i;
        do {
            System.out.println("Nhap chi so can chen vao mang");
            i = scanner.nextInt();
            if ((i >= 10) || (i < 1)) {
                System.out.println("Khong chen duoc o vi tri nay");
            }
        }
        while (((i >= 10) || (i < 1)));
        insertArray(a, x, i);
        System.out.println("Mang sau khi chen:");
        for (int j = 0; j <10 ; j++) {
            System.out.printf("%3s",a[j]);
        }
    }


    public static void insertArray(int[] a, int x, int i) {
        for (int j = 9; j > i; j--) {
            a[j] = a[j - 1];
        }
        a[i] = x;
    }
    public static int[] createArray() {
        Random random = new Random();
        int[] arr = new int[10];
        System.out.println("Danh sach cac phan tu cua mang:");
        for (int i = 0; i < 10; i++) {
            arr[i] = random.nextInt(100);
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        return arr;
    }
}
