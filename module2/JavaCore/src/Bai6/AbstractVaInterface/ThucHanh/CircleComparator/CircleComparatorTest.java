package Bai6.AbstractVaInterface.ThucHanh.CircleComparator;

import Bai6.AbstractVaInterface.ThucHanh.Circle;

import java.util.Arrays;

public class CircleComparatorTest {
    public static void main(String[] args) {
        Circle[] circles = new Circle[5];
        circles[0] = new Circle(3.6);
        circles[1] = new Circle();
        circles[2] = new Circle(3.5, "indigo", false);
        circles[3] = new Circle(3.5, "blue", false);
        circles[4] = new Circle(1.0, "indigo", false);
        System.out.println("Pre-sort:");
        for (Circle circle : circles) {
            System.out.println(circle);
        }
        CircleComparator circleComparator = new CircleComparator();
        Arrays.sort(circles, circleComparator);
        System.out.println("After-sort:");
        for (Circle circle : circles) {
            System.out.println(circle);
        }
    }
}
