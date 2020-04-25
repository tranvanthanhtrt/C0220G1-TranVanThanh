package Bai6.AbstractVaInterface.ThucHanh.ComparableCircle;

import Bai6.AbstractVaInterface.ThucHanh.ComparableCircle.ComparableCircle;

import java.util.Arrays;

public class ComparableCircleTest {
    public static void main(String[] args) {
        ComparableCircle[]circles=new ComparableCircle[5];
        circles[0] = new ComparableCircle(3.6);
        circles[1] = new ComparableCircle();
        circles[2] = new ComparableCircle(3.5, "indigo", false);
        circles[3] = new ComparableCircle(3.5, "blue", false);
        circles[4] = new ComparableCircle(1.0, "indigo", false);
        System.out.println("Pre-sort:");
        for (ComparableCircle circle : circles) {
            System.out.println(circle);
        }
        Arrays.sort(circles);
        System.out.println("After-sort:");
        for (ComparableCircle circle : circles) {
            System.out.println(circle);
        }
    }
}
