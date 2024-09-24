package Labs.Lab2.exercise2;

import Labs.Lab2.exercise1.List;

import java.util.ArrayList;


public class Queue implements List {

    public void setQueue(ArrayList<Object> queue) {
        this.queue = queue;
    }

    private static class Item {
        final Object value;
        final Item next;

        Item(Object value) {

            this.value = value;
            this.next = null;
        }
    }

    private ArrayList<Object> queue;
    private Item front = null;
    private Item back = null;


    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public int length() {
        return 0;
    }


    public void insert(int index, String s) {
        if (isEmpty()) {
            front = back = new Item(s);
        } else {
            queue.add(index, new Item(s));
            back = back.next;
        }


    }

    public void insert(int index, Object s) {
        if (isEmpty()) {
            front = back = new Item(s);

        } else {

            queue.add(index, new Item(s));
            back = back.next;
        }

    }

    public String get(int index) {
        return String.valueOf(queue.get(index));
    }


    public String delete(int index) {
        queue.remove(index);

        return null;
    }

}
 
