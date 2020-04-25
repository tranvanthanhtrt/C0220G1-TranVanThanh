package Bai7_CauTrucDuLieuVaGiatThuat.ThucHanh.TaoLopLinkedListDonGian;

public class TestMyLinkedList {
    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        MyLinkedList ll = new MyLinkedList(10);
        ll.addFirst("Hello");
        ll.addFirst(12);
        ll.addFirst(13);

        ll.add(4,9);
        ll.add(4,19);
        ll.printList();
    }
}
