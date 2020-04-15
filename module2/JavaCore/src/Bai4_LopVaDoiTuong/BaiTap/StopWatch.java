package Bai4_LopVaDoiTuong.BaiTap;

import java.util.Date;
import java.util.Random;

public class StopWatch {
    private long startTime;
    private long endTime;

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public StopWatch() {
        Date date = new Date(System.currentTimeMillis());
        this.startTime = date.getTime();
    }

    public void startTime() {
        Date date = new Date(System.currentTimeMillis());
        this.startTime = date.getTime();
    }

    public void endTime() {
        Date date = new Date(System.currentTimeMillis());
        this.endTime = date.getTime();
    }

    public long getElapsedTime() {
        return getEndTime() - getStartTime();
    }

    public static int[] createArray() {
        Random random = new Random();
        int[] arr = new int[100000];
        System.out.println("Danh sach cac phan tu cua mang:");
        for (int i = 0; i < 100000; i++) {
            arr[i] = random.nextInt(1000);
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = createArray();
        System.out.println("Mang sau khi sap xep la");
        StopWatch stopSort=new StopWatch();
        stopSort.startTime();
        int tam;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j]<arr[i]) {
                    tam=arr[i];
                    arr[i]=arr[j];
                    arr[j]=tam;
                }
            }
        }
        stopSort.endTime();
        System.out.println("Mang sau khi sap xep:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println("thoi gian sap xep la:   "+stopSort.getElapsedTime()+" miliseconds");
        }
    }

