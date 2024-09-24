package Labs.Lab1.exercise1;

public class LinkedStack {

    private static class StackCell {
        final String data;
        StackCell reference;


        StackCell(String data, StackCell reference) {
            this.data = data;
            this.reference = reference;
        }
    }

    public LinkedStack() {
    }

    StackCell top = null;
    int length = 0;


    public boolean isEmpty() {
        return length == 0;
    }


    public int length() {
        return length;
    }


    public void push(String s) {
        top = new StackCell(s, top);
        length++;
    }


    public String pop() {
        if (isEmpty()) {
            return null;
        }
        StackCell oldTop = top;
        top = top.reference;
        length--;

        return oldTop.data;

    }

    /*******************************************************************
     *  Exercise 1b                                                    *
     *******************************************************************
     *  multiPush() just needs to push the strings in the array. Don't
     *  reinvent the wheel by writing all the push code again -- just
     *  call push()!
     */
    public void multiPush(String[] strings) {
        for (String string : strings) {
            push(string);
        }
    }

    /*******************************************************************
     *  Exercise 1c                                                    *
     *******************************************************************
     *  Likewise, multiPop() uses pop() for the actual stack manipulation.
     *  The only thing here is to check that 'n' is a valid
     *  number of things to pop.
     */
    public String[] multiPop(int n) {
        if (isEmpty() || n < 0) {
            n = 0;
        }
        if (n > length) {
            n = length;
        }

        String[] line = new String[n];
        for (int i = 0; i < n; i++) {
            line[i] = pop();
        }
        return line;
    }

    /*******************************************************************
     *  Exercise 1d                                                    *
     *******************************************************************
     *  The most idiomatic way to merge the stacks is to find the bottom
     *  element of 'that', and set it's 'prev' reference to the top
     *  element of 'this'.
     *  This operation of following a chain of references is very common when data structures are implemented this
     *  way -- for example, you'll often see it in trees.
     */
    public void merge(LinkedStack that) {
        StackCell cursor = that.top;
        if (cursor == null) {
            return;
        }
        while (cursor.reference != null) {
            cursor = cursor.reference;
        }


        cursor.reference = top;

        top = that.top;
        that.top = null;
        this.length += that.length;
        that.length = 0;

    }
}