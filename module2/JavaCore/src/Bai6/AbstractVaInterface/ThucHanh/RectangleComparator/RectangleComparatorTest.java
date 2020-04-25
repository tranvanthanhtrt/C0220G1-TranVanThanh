package Bai6.AbstractVaInterface.ThucHanh.RectangleComparator;

import Bai6.AbstractVaInterface.ThucHanh.Rectangle;
import Bai6.AbstractVaInterface.ThucHanh.RectangleComparator.RectangleComparator;

import java.util.Arrays;

public class RectangleComparatorTest {
    public static void main(String[] args) {
        Rectangle[] rectangles = new Rectangle[4];
        rectangles[0] = new Rectangle(200, 300);
        rectangles[1] = new Rectangle();
        rectangles[2] = new Rectangle(500, 400, "red", true);
        rectangles[3] = new Rectangle(100, 300);
        System.out.println("Pre-sort:");
        for (Rectangle rectangle : rectangles) {
            System.out.println(rectangle);
        }
        RectangleComparator rectangleComparator=new RectangleComparator();
        Arrays.sort(rectangles,rectangleComparator);
        System.out.println("After-sort:");
        for (Rectangle rectangle : rectangles) {
            System.out.println(rectangle);
        }
    }
}
