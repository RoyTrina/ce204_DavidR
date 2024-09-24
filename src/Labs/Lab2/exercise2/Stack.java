package Labs.Lab2.exercise2;

import Labs.Lab2.exercise1.SinglyLinkedList;

import java.util.*;
import java.util.stream.Collectors;

@SuppressWarnings("ALL")
public class Stack extends SinglyLinkedList {
    private final ArrayList[] stack = new ArrayList[10];

    public Stack() {
    }

    @Override
    public boolean isEmpty() {
        return stack.length == 0;
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public void insert(int index, String s) {
        Arrays.stream(stack).collect(Collectors.toList()).add(index,stack[Integer.parseInt(s)]);
    }

    @Override
    public String get(int index) {
        if(Arrays.stream(stack).findFirst().isEmpty()){
            return null;
        }
        else{
            return String.valueOf(Arrays.stream(stack).findFirst().get().listIterator(index));
        }
    }

    @Override
    public String delete(int index) {
        if(Arrays.stream(stack).findFirst().isPresent()){
            System.out.println();
        }
        return String.valueOf(Arrays.stream(stack).findFirst().get().listIterator(index));
    }

    @Override
    public String toString() {
        return "Stack : {" + Arrays.toString(stack) + "}";
    }
}
