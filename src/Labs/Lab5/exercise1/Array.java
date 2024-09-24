package Labs.Lab5.exercise1;

import Labs.Lab2.exercise1.SinglyLinkedList;
import Workingcode.MergeSort;

import java.util.Arrays;
import java.util.Random;

@SuppressWarnings("ALL")
public class Array extends SinglyLinkedList {
    private int size = 0;
    private final Object[] mega_array = new Object[size];

    private static class Element {
        int value;
        Element next;

        Element(int value, Element next) {
            this.value = value;
            this.next = next;
        }
    }

    private Element head = null;
    private Element tail = null;

    public Array() {
    }

    public Array(int size) {
        new Array(size);
    }

    Array(Element element) {
        new Array(element);

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }


    public void mergeSort(Array array, int left, int middle, int right) {
        MergeSort.findSort(array, left, middle, right);
    }


    public Object extractHead(int[] arr) {
        if (size == 0) {
            return 0;
        } else {
            size--;
            return arr[size];
        }
    }

    public void extractHead(Array array) {
        if (size == 0) {
        } else {
            size--;
        }
    }

    public void add_to_Head(Element obj) {
        obj = new Element(head.value, head);
        head = obj;

        if (obj.next == null) {
            tail = obj;
        } else {
            obj.next = obj;
        }
        size++;

    }


    public void insert(int index, Element obj) {
        if (index <= 0) {
            obj.value = head.value;
            add_to_Head(obj);
        } else if (index >= size) {
            addToTail(tail.value);
        } else {
            Element cursor = getElement(index);
            new Element(cursor.value, cursor.next).next = new Element(cursor.value, cursor.next);
        }
    }


    public void addToTail(Object obj) {
        tail = new Element(tail.value, null);
        size++;
    }


    public Object[] create(int length) {

        return new Object[length];
    }

    void set(int index, int value) {
        mega_array[index] = value;
    }


    public int getIndex(int index) {
        if (index < 0 || index >= size) {
            return 0;
        } else {
            return getElement(index).value;
        }
    }

    public Element getElement(int index) {
        Element current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public String toString() {
        return "Array: " + Arrays.toString(mega_array);
    }

    public static void main(String[] args) throws Exception {
        Random newRandom = new Random();
        Array newArray = new Array();
        for (int i = 0; i < newArray.size; i++) {
            newArray.set(i, newRandom.nextInt(10));
        }
        newArray.mergeSort(newArray, newRandom.nextInt(10), newRandom.nextInt(10), newRandom.nextInt(10));

        newArray.set(6, 23);
        newArray.getIndex(9);

        newArray.extractHead(newArray);



    }
}

