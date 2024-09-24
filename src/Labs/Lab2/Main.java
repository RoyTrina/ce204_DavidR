package Labs.Lab2;

import Labs.Lab2.exercise1.SinglyLinkedList;
import Labs.Lab2.exercise2.Stack;
import Labs.Lab2.exercise3.IntList;

public class Main {
    public static void main(String[] args) {

        //SinglyLinkedList
        SinglyLinkedList newList = new SinglyLinkedList();
        newList.add_to_Head("ratty");
        newList.add_to_Tail("o");
        System.out.println(newList);


        //IntList
        IntList newIntList = new IntList();
        newIntList.head();



        //Stack
        Stack newStack = new Stack();
        newStack.add_to_Head("1");
        newStack.add_to_Tail("10");
        System.out.println(newStack);

    }
}
