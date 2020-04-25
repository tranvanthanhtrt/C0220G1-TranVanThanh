package Bai4_LopVaDoiTuong.BaiTap;

public class CirclevaCylinder {
    private int raius;
    private String color;
    final static float PI = 3.14f;

    public int getRaius() {
        return raius;
    }

    public void setRaius(int raius) {
        this.raius = raius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getPerimeter() {
        return getRaius() * 2 * PI;
    }

    public float getArea() {
        return getRaius() * getRaius() * PI;
    }

    public CirclevaCylinder() {
    }

    public CirclevaCylinder(int raius, String color) {
        this.raius = raius;
        this.color = color;
    }

}
