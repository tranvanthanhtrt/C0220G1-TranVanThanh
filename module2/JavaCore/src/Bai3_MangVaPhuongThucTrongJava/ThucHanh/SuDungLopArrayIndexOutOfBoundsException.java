package Bai3_MangVaPhuongThucTrongJava.ThucHanh;

import java.util.Random;
import java.util.Scanner;

public class SuDungLopArrayIndexOutOfBoundsException {
    public static void main(String[] args) {
        SuDungLopArrayIndexOutOfBoundsException arrayExample = new SuDungLopArrayIndexOutOfBoundsException();
        int[] arr = arrayExample.createRandomArray();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap chi so phan tu trong mang:");
        int x = scanner.nextInt();
        int a = 0;
        try {
            System.out.println("Gia tri cua phan tu " + x + " trong mang la " + arr[x] / a);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Chi so vuot qua gioi han cua mang");
        } catch (ArithmeticException e) {
            System.out.println("loi");
        }


    }

    public int[] createRandomArray() {
        Random random = new Random();
        int[] arr = new int[100];
        System.out.println("Danh sach cac phan tu cua mang:");
        for (int i = 0; i < 100; i++) {
            arr[i] = random.nextInt(1000);
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        return arr;


    }
}
