package Bai7_CauTrucDuLieuVaGiatThuat.BaiTap.MyList;

import Bai7_CauTrucDuLieuVaGiatThuat.BaiTap.MyList.MyList;

public class MyListTest {
    public static void main(String[] args) {
        MyList<String> myList = new MyList<>();
        myList.add("A");
        myList.add("B");
        myList.add(1, "C");
        myList.add(0, "D");
        System.out.println("my list nè:");
        System.out.println(myList.toString());

        System.out.println("list clone nè:");
        MyList clonelist = myList.clone();

        System.out.println(clonelist.toString());
        System.out.println("xoa 1 phan tu roi in lai mylist");
        myList.remove(2);
        System.out.println(myList.toString());
        System.out.println("list clone nè:");
        System.out.println(clonelist.toString());





    }
}
