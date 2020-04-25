package Bai7_CauTrucDuLieuVaGiatThuat.BaiTap.MyList;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = new Object[capacity];
    }

    private void ensureCapacity(int ratioCapacity) {
        int newCapacity;
        if (elements.length == 0) {
            newCapacity = 1;
        } else
            newCapacity = elements.length * ratioCapacity;
        elements = Arrays.copyOf(elements, newCapacity);
    }

    public boolean add(E element) {
        if (size == elements.length) {
            ensureCapacity(2);
        }

        elements[size] = element;
        size++;
        return true;

    }

    public E remove(int index) {
        E removed = (E) elements[index];

        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size-1]=null;
        size--;
        return removed;
    }

    public int size() {
        return size;
    }

    public MyList clone() {
        MyList<E> listClone = new MyList<E>();
        listClone.size = this.size;
        listClone.elements = Arrays.copyOf(elements, elements.length);
        return  listClone;
    }

    public boolean contain(E o) {
        for (Object element : elements) {
            if (element.equals(o)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E o) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    public void add(int index, E o) {
        if ((index < 0) || (index > size)) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index]=o;
        size++;
    }
    public E get(int index){
        return (E) elements[index];
    }
    public void clear(){
        elements=new Object[0];
        size=0;
    }

    @Override
    public String toString() {
        return "MyList{" +
                "elements=" + Arrays.toString(elements) +
                '}';
    }
}
