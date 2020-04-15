package Bai6.AbstractVaInterface.ThucHanh.CircleComparator;

import Bai6.AbstractVaInterface.ThucHanh.Circle;

import java.awt.*;
import java.util.Comparator;

public class CircleComparator implements Comparator<Circle> {
    @Override
    public int compare(Circle c1,Circle c2) {
        if (c1.getRadius() > c2.getRadius()) {
            return 2;
        } else if (c1.getRadius() < c2.getRadius()) {
            return -2;
        }else return 0;
    }
}
