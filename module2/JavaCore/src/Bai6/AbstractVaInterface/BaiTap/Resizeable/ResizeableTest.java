package Bai6.AbstractVaInterface.BaiTap.Resizeable;

import Bai6.AbstractVaInterface.ThucHanh.Circle;
import Bai6.AbstractVaInterface.ThucHanh.Rectangle;
import Bai6.AbstractVaInterface.ThucHanh.Shape;
import Bai6.AbstractVaInterface.ThucHanh.Square;

public class ResizeableTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(59);
        shapes[1] = new Rectangle(20, 40);
        shapes[2] = new Square(47);

       double resize=Math.floor(Math.random()*100+1);
        System.out.println("Before-resize");
        for (Shape shape : shapes) {
            System.out.println(shape);
           shape.resize(resize);
        }
        System.out.println("After-resize "+resize+" percent");
        for (Shape shape : shapes) {
            System.out.println(shape.toString());
        }
    }
}
