package Bai6.AbstractVaInterface.ThucHanh.RectangleComparator;

import Bai6.AbstractVaInterface.ThucHanh.Rectangle;

import java.util.Comparator;

public class RectangleComparator implements Comparator<Rectangle> {
    @Override
    public int compare(Rectangle o1, Rectangle o2) {
        if (o1.getArea() > o2.getArea()) {
            return 2;
        } else if (o1.getArea() < o2.getArea()) {
            return -2;
        }else return 0;
    }
    }

