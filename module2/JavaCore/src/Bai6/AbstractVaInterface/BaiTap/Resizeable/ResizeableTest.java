package Bai6.AbstractVaInterface.BaiTap.Resizeable;

import Bai6.AbstractVaInterface.ThucHanh.Circle;
import Bai6.AbstractVaInterface.ThucHanh.Rectangle;
import Bai6.AbstractVaInterface.ThucHanh.Shape;
import Bai6.AbstractVaInterface.ThucHanh.Square;

public class ResizeableTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[4];
        shapes[0] = new Circle(59);
        shapes[1] = new Rectangle(20, 40);
        shapes[2] = new Square(47);
        shapes[3] = new Rectangle(15, 78);
       double resize=Math.floor(Math.random()*100+1);
        System.out.println("Before-resize");
        for (Shape shape : shapes) {
            System.out.println(shape.toString());
            if (shape instanceof Circle) {
                ((Circle) shape).resize(resize);
            } else if (shape instanceof Rectangle) {
                ((Rectangle) shape).resize(resize);
            } else if (shape instanceof Square) {
                ((Square) shape).resize(resize);
            }
        }
        System.out.println("After-resize "+resize+" percent");
        for (Shape shape : shapes) {
            System.out.println(shape.toString());
        }
    }
}
