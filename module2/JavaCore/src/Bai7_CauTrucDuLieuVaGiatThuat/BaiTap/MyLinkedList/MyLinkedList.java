package Bai7_CauTrucDuLieuVaGiatThuat.BaiTap.MyLinkedList;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.util.LinkedList;

public class MyLinkedList<E> {
    private Node head;
    private int numberNodeSize = 0;

    public MyLinkedList() {
    }

    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    public Node getNode(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }
    public E get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return (E) temp.getData();
    }

    public E getFirst() {
        return (E)getNode(0).getData();
    }

    public E getLast() {
        return (E) getNode(numberNodeSize).getData();
    }

    public void add(int index, E element) {
        if ((index < 0) || (index > numberNodeSize)) {
            throw new IndexOutOfBoundsException("Chi so ngoai pham vi LinkedList");
        } else {
            Node temp = getNode(index);
            getNode(index - 1).next = new Node(element);
            getNode(index - 1).next.next = temp;
            numberNodeSize++;
        }
    }

    public void addFirst(E element) {
        Node temp = head;
        head = new Node(element);
        head.next = temp;
        numberNodeSize++;
    }

    public void addLast(E element) {
        if (numberNodeSize == 0) {
            addFirst(element);
        } else {
            getNode(numberNodeSize - 1).next = new Node(element);
            numberNodeSize++;
        }
    }

    public int indexOf(E element) {
        for (int i = 0; i < numberNodeSize; i++) {
            if (getNode(i).getData().equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public E remove(int index) {
        if ((index < 0) || (index > numberNodeSize)) {
            throw new IndexOutOfBoundsException("Chi so ngoai pham vi LinkedList");
        } else if (index == 0) {
            Node removed = head;
            head = getNode(1);
            numberNodeSize--;
            return ((E) removed.getData());

        } else {
            Node removed = getNode(index);
            getNode(index - 1).next = getNode(index + 1);
            removed.next = null;
            numberNodeSize--;
            return (E) removed.getData();

        }
    }

    public boolean remove(E element) {
        boolean removed = false;
        while (indexOf(element) != -1) {
            remove(indexOf(element));
            removed = true;
        }
        return removed;
    }

    public int size() {
        return numberNodeSize;
    }

    public MyLinkedList clone() {
        MyLinkedList<E> linkedListClone = new MyLinkedList<>();
        for (int i = 0; i < numberNodeSize; i++) {
            linkedListClone.addLast((E) getNode(i).getData());
        }
        return linkedListClone;
    }

    public boolean contains(E element) {
        Node temp = head;
        do {
            if (temp.getData().equals(element)) {
                return true;
            }
            temp = temp.next;
        }
        while (temp != null);
        return false;
    }
public  void clear(){
        head=null;
}
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

}

