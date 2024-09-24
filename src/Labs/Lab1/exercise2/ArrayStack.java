package Labs.Lab1.exercise2;

public class ArrayStack {
    private String[] strings = new String[10];
    private int length = 0;


// --Commented out by Inspection START (01/04/2022 19:39):
//    public boolean isEmpty() {
//        return length == 0;
//    }
// --Commented out by Inspection STOP (01/04/2022 19:39)


// --Commented out by Inspection START (01/04/2022 19:39):
//    public int getLength() {
//        return length;
//    }
// --Commented out by Inspection STOP (01/04/2022 19:39)

    int copies = 0;

// --Commented out by Inspection START (01/04/2022 19:39):
//    public String pop() {
//
//        if (length == 0) {
//            return null;
//        } else {
//            length--;
//            String answer = strings[length];
//
//            if (strings.length > 10 && length < strings.length / 4) {
//                String[] newStrings = new String[strings.length / 2];
//                System.arraycopy(strings, 0, newStrings, 0, length);
//                copies += length;
//                strings = newStrings;
//
//            }
//            return answer;
//        }
//    }
// --Commented out by Inspection STOP (01/04/2022 19:39)

    public void pushWithDouble(String w) {
        strings[length] = w;
        length++;

        if (length >= strings.length) {
            String[] newStrings = new String[strings.length * 2];
            System.arraycopy(strings, 0, newStrings, 0, strings.length);
            copies += strings.length;
            strings = newStrings;
        }
    }

    public void pushWithAdd(String r) {
        strings[length] = r;
        length++;

        if (length >= strings.length) {
            String[] newStrings = new String[strings.length + 100];
            System.arraycopy(strings, 0, newStrings, 0, strings.length);
            copies += strings.length;
            strings = newStrings;
        }

    }

    public void push(String a) {
        strings[length] = a;
        length++;

        if (length >= strings.length ) {
            String[] newStrings = new String[strings.length * 2];
            System.arraycopy(strings, 0, newStrings, 0, strings.length);
            strings = newStrings;
        }

    }


    public static void main(String[] args) {
        ArrayStack adder = new ArrayStack();
        ArrayStack doubler = new ArrayStack();
        ArrayStack normal = new ArrayStack();

        for (int i = 0; i < 80_000; i++) {
            adder.pushWithAdd("");
            doubler.pushWithDouble("");
            normal.push("");
        }

        System.out.println("Adder:   " + adder.copies);
        System.out.println("Doubler: " + doubler.copies);
        System.out.println("Adder required " + adder.copies / doubler.copies
                + " times more copying");
        System.out.println("Normal:  " + normal.copies);
    }
}
