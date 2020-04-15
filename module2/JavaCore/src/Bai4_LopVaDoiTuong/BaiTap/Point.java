package Bai4_LopVaDoiTuong.BaiTap;

public class Point {
    public static void main(String[] args) {
        Point movablePoint=new MovablePoint(12f,15f,50f,90f);
        Point point=new Point(10f,20f);
        System.out.println(point.toString());

        System.out.println(movablePoint.getX());
        System.out.println(movablePoint.toString());
        ((MovablePoint)movablePoint).move();

//        ((MovablePoint) movablePoint).move();
        System.out.println(point.toString());
//        movablePoint.move();
        System.out.println(movablePoint.toString());


    }
    float x=0.00f;
    float y=0.00f;

    public Point() {
    }

    public Point(float x, float y) {
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

}
class MovablePoint extends Point{
    float xSpeed=0.00f;
    float ySpeed=0.00f;

    public MovablePoint() {
    }

    public MovablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x,y);

        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }
    public void setSpeed(float xSpeed,float ySpeed){
        this.xSpeed=xSpeed;
        this.ySpeed=ySpeed;
    }
    public float[] getSpeed(){
        return new float[]{xSpeed,ySpeed};
    }
    @Override
    public float getX() {
        this.x=44;
        return this.x;
    }
    @Override
    public String toString(){
        return "("+this.x+","+this.y+")"+", speed=("+this.xSpeed+","+this.ySpeed+")";
    }
    public MovablePoint move(){
        x+=xSpeed;
        y+=ySpeed;
        return this;
    }
}
