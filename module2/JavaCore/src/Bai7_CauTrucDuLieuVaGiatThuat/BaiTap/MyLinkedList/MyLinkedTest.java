package Bai7_CauTrucDuLieuVaGiatThuat.BaiTap.MyLinkedList;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class MyLinkedTest {
    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList=new MyLinkedList<>();
        myLinkedList.addFirst("A");
        myLinkedList.addFirst("B");
        myLinkedList.addLast("C");
        myLinkedList.addLast("D");
        myLinkedList.addLast("E");
//
//        myLinkedList.addFirst("F");
//        myLinkedList.addFirst("G");
//
//        myLinkedList.printList();
//        System.out.println();
//        System.out.println(myLinkedList.indexOf("B"));
//        System.out.println(myLinkedList.get(2));
        myLinkedList.remove("C");
//
//        System.out.println("sau khi xoa C");
//        myLinkedList.printList();
        System.out.println("linkedListClone:");
        MyLinkedList listclone=myLinkedList.clone();
        listclone.printList();
        System.out.println(myLinkedList.contains("G"));
        myLinkedList.clear();
        System.out.println("sau khi clear");
        myLinkedList.printList();
        listclone.printList();





//        myLinkedList.printList();


    }
}
