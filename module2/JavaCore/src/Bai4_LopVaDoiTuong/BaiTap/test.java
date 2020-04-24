package Bai4_LopVaDoiTuong.BaiTap;

import java.util.LinkedList;

public class test {
     public static int y=5;
     LinkedList<String> a=new LinkedList<>();


    public test() {
    }
    public int y2=3;

    public static void main(String[] args) {
        String str="hello";
        str="hello";
        String str2;
        str2 = new String("hello");
        str2="hello";
        System.out.println(str2.hashCode());
        String str3="hello";
        String str4;
        str4 = new String("hellothanh");
        str2=str2+"thanh";
        System.out.println(str2);
        System.out.println(str.hashCode());
        System.out.println(str2.hashCode());
        System.out.println(str3.hashCode());
        System.out.println(str4.hashCode());
        System.out.println(str4);


    }
    public static class D{
        public D() {
        }

        public static  int d1=4;

    }
    public class E{

        public   int e1=4;

        public E() {

        }
    }
}
 class AAA{
    public AAA() {
    }
}
  class B extends AAA{
    public static int x=5;
     public B() {
    }
}

