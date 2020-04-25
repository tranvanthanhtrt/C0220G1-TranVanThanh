package Bai3_MangVaPhuongThucTrongJava.BaiTap;

import java.util.Random;
import java.util.Scanner;

public class TimGiaTriLonNhatTrongMang {
    public static void main(String[] args) {
        int[][] arr = createArray();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap gia tri muon tim");
        int x = scanner.nextInt();
        findArray(arr, x);
    }

    public static void findArray(int[][] arr, int value) {
        int indexRow = 0;
        int indexCol = 0;
        boolean isFinded = false;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (arr[i][j] == value) {
                    isFinded = true;
                    indexRow = i;
                    indexCol = j;
                    break;
                }
            }
            if (isFinded) {
                break;
            }
        }
        if (isFinded) {
            System.out.println("gia tri " + value + " nam o hang " + indexRow + " cot " + indexCol);
        } else
            System.out.println("khong tim thay gia tri " + value + " trong mang");
    }

    public static int[][] createArray() {
        Random random = new Random();
        int[][] arr = new int[10][10];
        System.out.println("Danh sach cac phan tu cua mang:");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                arr[i][j] = random.nextInt(100);
                System.out.printf("%3s", arr[i][j]);
            }
            System.out.println();
        }
        return arr;
    }
}
