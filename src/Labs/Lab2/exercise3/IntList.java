package Labs.Lab2.exercise3;

public class IntList {

    public IntList(int value, Item item) {
        new IntList(new Item(value, item.next));

    }

    public IntList(Item item) {
        head = item;
    }

    private static class Item {
        private int value;
        private Item next;

        Item(int value, Item next) {
            this.value = value;
            this.next = next;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Item getNext() {
            return next;
        }

        public void setNext(Item next) {
            this.next = next;
        }
    }


    private Item head = null;
    private Item tail = null;
    private int length = 0;


    public IntList() {
    }


    public int head() {
        return head.value; /* Dummy */
    }

    public Item tail() {
        return tail; /* Dummy */
    }

    public void addToHead(int value) {
        Item h = new Item(value, head);


        head = h;
        if (h.next == null) {
            tail = h;


        } else {
            h.next = h;
        }

        length++;
    }

    public void addToTail(int value) {
        tail = new Item(value, null);
        length++;
    }


    public boolean isEmpty() {
        return head == null;
    }


    public int length() {
        return length;
    }


    public void insert(int index) {
        if (index <= 0) {
            addToHead(head.value);
        } else if (index >= length) {
            addToTail(tail.value);
        } else {
            Item pointer = getItem(index);
            new Item(pointer.value, pointer.next).next = new Item(pointer.value, pointer.next);
            length++;
        }

    }

    public int getValue(int index) {
        if (index < 0 || index >= length) {
            return 0;
        } else {
            return getItem(index).value;
        }
    }

    private Item getItem(int index) {
        Item current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }


    public void delete(int index) {
        if (index < 0 || index >= length) {
            return;
        }
        if (length == 1) {
            head = tail = null;
        } else if (index == 0) {

            head = head.next;
        } else if (index == length - 1) {
            tail.next = null;
        }
    }


    private Item cursor = null;

    public void rewind() {
        cursor = null;

    }

    public int getNext() throws NullPointerException {
        try {
            if (cursor == null) {
                cursor = head;

            } else {
                cursor = cursor.next;
            }
            throw new NullPointerException();

        } catch (NullPointerException e) {
            e.getMessage();
        }

        return cursor.value;
    }

    public IntList cons(int value) {
        IntList THIS = new IntList();
        THIS.head.value = value;
        return THIS;
    }

    @Override
    public String toString() {
        return "List of integers {" +
                "head: " + head.value + ", " +
                "tail: " + tail.value + ", " +
                "length: " + length +
                '}';

    }

}

