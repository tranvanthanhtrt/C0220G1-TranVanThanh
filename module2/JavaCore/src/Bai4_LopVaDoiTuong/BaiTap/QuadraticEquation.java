package Bai4_LopVaDoiTuong.BaiTap;

import sun.font.DelegatingShape;

import java.util.Scanner;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getRoot1() {
        return (-b + Math.sqrt(this.b * this.b - 4 * this.a * this.c)) / (2 * this.a);
    }

    public double getRoot2() {
        return (-b - Math.sqrt(this.b * this.b - 4 * this.a * this.c)) / (2 * this.a);
    }

    public double getDiscriminant() {
        return Math.pow(this.b, 2) - 4 * this.a * this.c;
    }


    public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap a");
        double a=scanner.nextDouble();
        System.out.println("Nhap b");
        double b=scanner.nextDouble();
        System.out.println("Nhap c");
        double c=scanner.nextDouble();
        QuadraticEquation quadraticEquation=new QuadraticEquation(a,b,c);
        if(quadraticEquation.getDiscriminant()>0){
            System.out.printf("x1=%5.3f x2=%5.3f",quadraticEquation.getRoot1(),quadraticEquation.getRoot2());
        }
        else if (quadraticEquation.getDiscriminant()==0){
            System.out.printf("x="+quadraticEquation.getRoot1());}
        else System.out.println("The equation has no roots");
        }
    }

