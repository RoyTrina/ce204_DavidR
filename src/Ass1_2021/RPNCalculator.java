package Ass1_2021;

import java.util.Arrays;

@SuppressWarnings("ALL")
public class RPNCalculator {
    private int[] digits = new int[20];
    private int size = 0;

    //constructor
    public RPNCalculator() {
    }

    //exception class
    static class RPNException extends RuntimeException {
        public RPNException(String a) {
            super("Tried to apply" + a + "to the stack.");
        }
    }

    //isEmpty method
    public boolean isEmpty() {
        return size == 0;
    }

// --Commented out by Inspection START (01/08/2021 18:07):
//    //length method
//    public int length() {
//        return size;
//    }
// --Commented out by Inspection STOP (01/08/2021 18:07)

    //push method
    public void push(int n) {
        digits[size] = n;

        if (size >= digits.length) {
            int[] newDigits = new int[digits.length * 2];
            System.arraycopy(digits, 0, newDigits, 0, digits.length);
            digits = newDigits;
        }
        digits[size] = n;
        size++;
    }

    //pop method
    public int pop() {
        if (size == 0) {
            return 0;
        } else {
            size--;
            return digits[size];
        }
    }

    // clear method
    public void clear() {
        if (isEmpty()) {
            System.out.println("The stack is empty.");
        } else {
            clearStack(digits, size);

        }
    }

    //helper method for clearing the stack
    private void clearStack(int[] array, int arr_length) {
        int[] clear_array = new int[100];
        int counter = 0;
        final int length = digits.length;
        while (arr_length - counter > length) {
            System.arraycopy(clear_array, 0, array, counter, length);
            counter += length;
        }
        System.arraycopy(clear_array, 0, array, counter, arr_length - counter);
    }

    //evaluate method
    public int evaluate(String expr) {
        int answer = 0;
        String[] str_expr = expr.split(" ");
        int[] stack = new int[str_expr.length];
        String operators = "-,+,*,/";

        if (!expr.equals("")) {
            for (int i = 0; i < str_expr.length; i++) {
                stack[i] = Integer.parseInt(str_expr[i]);
                int token = Integer.parseInt(str_expr[i]);

                if (Integer.parseInt(str_expr[i]) == Integer.parseInt(String.valueOf(token))) {
                    push(Integer.parseInt(str_expr[i]));
                } else if (Integer.parseInt(str_expr[i]) == Integer.parseInt(operators)) {
                    int y = pop();
                    int x = pop();
                    String symbol = str_expr[i];

                    answer = Integer.parseInt(y + symbol + x);
                    push(answer);
                }
            }
        } else {
            throw new RPNException("Invalid expression");
        }
        System.out.println(Arrays.toString(stack));
        return answer;
    }

    //main method
    public static void main(String[] args) {


    }
}
