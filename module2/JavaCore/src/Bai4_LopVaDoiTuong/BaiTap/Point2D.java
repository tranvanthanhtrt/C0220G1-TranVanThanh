package Bai4_LopVaDoiTuong.BaiTap;

public class Point2D {
    float x=0.00f;
    float y=0.00f;

    public Point2D() {
    }

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    public void setXY(float x,float y){
        this.x=x;
        this.y=y;
    }
    public float[] getXY(){
        return new float[]{this.x,this.y} ;
    }

    @Override
    public String toString() {
               return "("+this.x+","+this.y+")";
    }

    public static void main(String[] args) {
Point2D point2D=new Point2D(2.534f,6.5f);
Point3D point3D=new Point3D(1f,23f,1.45f);
        System.out.println(point2D.toString());
        System.out.println();
        System.out.println(point3D.toString());
    }
}
class Point3D extends Point2D{
    float z=0.00f;

    public Point3D() {
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    public void setXYZ(float x,float y,float z){
       super.setXY(x,y);
       this.z=z;
    }
    public float[] getXYZ(){
        return new float[]{this.x,this.y,this.z};
    }

    @Override
    public String toString() {
        return "("+this.x+","+this.y+","+this.z+")";
    }
}
