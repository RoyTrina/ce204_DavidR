package Labs.Lab2.exercise1;

import java.util.Arrays;

public class SinglyLinkedList implements List {
    final Object[] list = new Object[0];

    public Item getPointer() {
        return pointer;
    }

    private static class Item {
        final String value;
        Item next;

        Item(String value, Item next) {
            this.value = value;
            this.next = next;
        }
    }

    private Item head = null;
    private Item tail = null;
    private int length = 0;

    public SinglyLinkedList() {

    }

    public SinglyLinkedList(Item item) {
        new SinglyLinkedList(item);
    }

    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int length() {
        return length;
    }


    public void insert(int index, String s) {
        if (index <= 0) {
            s = head.value;
            add_to_Head(s);
        } else if (index >= length) {
            add_to_Tail(tail.value);
        } else {
            Item cursor = getItem(index);
            new Item(cursor.value, cursor.next).next = new Item(cursor.value, cursor.next);

            length++;
        }

    }


    public String get(int index) {
        if (index < 0 || index >= length) {
            return null;
        } else {
            return getItem(index).value;
        }
    }


    public String delete(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        if (length == 1) {
            head = tail = null;
        } else if (index == 0) {
            head = head.next;
        } else if (index == length - 1) {
            tail.next = null;
        }
        return null;
    }


    public void add_to_Head(String value) {
        Item h = new Item(value, head);
        head = h;
        if (h.next == null) {
            tail = h;
        } else {
            h.next = h;
        }
        length++;

    }

    public void add_to_Tail(String value) {
        tail = new Item(value, null);
        length++;

    }

    public Item getItem(int index) {
        Item cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    private Item pointer = null;


    public void rewind() {
        pointer = null;
    }


    public String getNext() {
        if (pointer == null) {
            pointer = head;
        } else {
            pointer = pointer.next;
        }
        return pointer == null ? null : pointer.value;
    }


    @Override
    public String toString() {
        return "SinglyLinkedList { " +
                "head = " + head.value +
                ", tail = " + tail.value +
                ", length = " + length +
                ", items = " + Arrays.toString(list) +
                '}';
    }
}
