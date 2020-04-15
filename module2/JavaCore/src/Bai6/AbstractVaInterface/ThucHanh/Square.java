package Bai6.AbstractVaInterface.ThucHanh;

import Bai6.AbstractVaInterface.BaiTap.Colorable.Colorable;
import Bai6.AbstractVaInterface.BaiTap.Resizeable.Resizeable;

public class Square extends Shape implements Resizeable, Colorable {
    private double side = 1.0;

    public Square() {
    }

    public Square(double side) {
        this.side = side;
    }

    public Square(String color, boolean filled, double side) {
        super(color, filled);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getArea() {
        return Math.pow(this.side, 2);
    }

    public double getPerimeter() {
        return 4 * this.side;
    }

    @Override
    public void resize(double percent) {
        this.side+=this.side*percent/100;
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides");
    }

    @Override
    public String toString() {
        return String.format("A Square with side=%.4f"
                 +", which is a subclass of "
                + super.toString(),getSide());
    }
}

