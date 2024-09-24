package Labs.Lab1;

import java.util.Arrays;
import java.util.List;

public class StringStack implements Labs.Lab1.exercise2.StackADT {
    private int length = 0;
    public int index;
    private final String[] list = new String[20];

    public StringStack() {

    }

    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public int length() {
        if (!isEmpty()) return list.length;
        else {
            return 0;
        }
    }

    @Override
    public void push(String s) {
        if (length == list.length || length == list.length / 4) {
            String[] newList = new String[length * 2];
            System.arraycopy(list, 0, newList, 0, length);
            System.out.println(Arrays.toString(newList));
        }

        list[length] = s;
        length++;
    }


    @Override
    public String pop() {
        if (isEmpty()) {
            return null;
        } else {
            List<String> al;
            al = Arrays.asList(list);
            String popS = al.get(0);
            length--;
            return popS;
        }
    }

    @Override
    public boolean isFull() {
        return list.length == length;
    }

    @Override
    public String toString() {
        return "StringStack: " +
                "length = " + length + "\n" +
                "index = " + index + "\n" +
                "list = " + Arrays.toString(list);
    }
}
