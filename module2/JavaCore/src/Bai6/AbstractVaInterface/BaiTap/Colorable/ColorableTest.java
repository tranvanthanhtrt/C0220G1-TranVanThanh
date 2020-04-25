package Bai6.AbstractVaInterface.BaiTap.Colorable;

import Bai6.AbstractVaInterface.ThucHanh.Circle;
import Bai6.AbstractVaInterface.ThucHanh.Rectangle;
import Bai6.AbstractVaInterface.ThucHanh.Shape;
import Bai6.AbstractVaInterface.ThucHanh.Square;

import java.util.function.DoubleToIntFunction;

public class ColorableTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[4];
        shapes[0] = new Square(52);
        shapes[1] = new Rectangle(20, 56);
        shapes[2] = new Circle(45);
        shapes[3] = new Square(41);
        for (Shape shape : shapes) {
            System.out.println(shape);
            if (shape instanceof Square) {
                ((Square) shape).howToColor();
            }
        }
    }
}
