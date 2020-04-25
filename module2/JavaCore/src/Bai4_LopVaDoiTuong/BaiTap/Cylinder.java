package Bai4_LopVaDoiTuong.BaiTap;

public class Cylinder extends CirclevaCylinder {
    private float height;

    public Cylinder() {
    }

    public Cylinder(float height) {
        this.height = height;
    }

    public Cylinder(int raius, String color, float height) {
        super(raius, color);
        this.height = height;
    }
    public float getPerimeter() {
        return super.getPerimeter()*this.height+super.getArea()*2;
    }
    public float getV() {
        return super.getArea()*this.height;
    }
}
