package Labs.Lab5.exercise1;

import Labs.Lab2.exercise1.SinglyLinkedList;


public class List {
    private static int length = 0;
    private static final SinglyLinkedList mega_list = new SinglyLinkedList();


    public static void mergeSort(SinglyLinkedList list) {
        if (list.length() <= 1) return;

        SinglyLinkedList one = new SinglyLinkedList();
        SinglyLinkedList two = new SinglyLinkedList();


        while (!list.isEmpty()) {
            one.add_to_Tail(extractHead(list));
            if (!list.isEmpty()) {
                two.add_to_Tail(extractHead(list));
            }
        }
        mergeSort(one);
        mergeSort(two);

        while (!(one.isEmpty() && two.isEmpty())) {

            if (two.isEmpty()) {
                list.add_to_Tail(extractHead(one));
            } else if (one.isEmpty()) {
                list.add_to_Tail(extractHead(two));
            }
        }
    }

    public static String extractHead(SinglyLinkedList list) {
        if (list.length() == 0) {
            return String.valueOf(0);

        } else {
            length--;
            return String.valueOf(mega_list);
        }
    }
}
 
