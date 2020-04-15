package Bai6.AbstractVaInterface.ThucHanh.ComparableCircle;

import Bai6.AbstractVaInterface.ThucHanh.Circle;

public class ComparableCircle extends Circle implements Comparable<ComparableCircle> {
    public ComparableCircle() {
    }

    public ComparableCircle(double radius) {
        super(radius);
    }

    public ComparableCircle(double radius, String color, boolean filled) {
        super(radius, color, filled);
    }

    @Override
    public int compareTo(ComparableCircle o) {
        if (this.getRadius() > o.getRadius()) {
            return 2;
        } else if (this.getRadius() < o.getRadius()) {
            return -2;
        }else return 0;
    }
}

