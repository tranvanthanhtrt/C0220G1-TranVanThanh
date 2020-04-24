package Bai7_CauTrucDuLieuVaGiatThuat.ThucHanh.TaoLopListDonGian;

import Bai6.AbstractVaInterface.ThucHanh.Circle;
import javafx.util.Builder;

public class MyListTest {
    public static void main(String[] args) {
//        MyList<Integer> listInteger = new MyList<Integer>();
//        listInteger.add(1);
//        listInteger.add(2);
//        listInteger.add(3);
//        listInteger.add(3);
//        listInteger.add(4);
//
//        System.out.println("element 4: "+listInteger.get(4));
//        System.out.println("element 1: "+listInteger.get(1));
//        System.out.println("element 2: "+listInteger.get(2));
//        listInteger.get(-1);
//        System.out.println("element -1: " + listInteger.get(-1));
//
//        listInteger.get(6);
//        System.out.println("element 6: "+listInteger.get(6));
        StringBuilder a = new StringBuilder("hello");
        String b = "hello";
        StringBuilder c = new StringBuilder("hello");
        System.out.println(a);
        System.out.println(b);
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(c.hashCode());
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        Circle t=new Circle();
        System.out.println(t.hashCode());
        int r=2;
        int y=2;
        System.out.println();

    }
}
