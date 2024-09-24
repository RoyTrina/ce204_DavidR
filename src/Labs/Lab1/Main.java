package Labs.Lab1;

import Labs.Lab1.exercise1.LinkedStack;
import Labs.Lab1.exercise2.Stack;
import Labs.Lab1.exercise3.IntQueue;

public class Main {

    public static void main(String[] args) {
        //---LinkedStack---//
        LinkedStack newStack = new LinkedStack();
        newStack.multiPush(new String[]{"1", "2", "3"});
        System.out.println(newStack);
        newStack.multiPop(2);
        System.out.println(newStack);
        newStack.isEmpty();


        //---StringStack---//
        StringStack newStringStack;
        newStringStack = new StringStack();
        newStringStack.push("Love");
        newStringStack.push("mad");
        newStringStack.push("you");
        newStringStack.push("crazy");
        newStringStack.push("Shah Rukh");
        newStringStack.push("raj");
        newStringStack.push("rahul");
        newStringStack.push("Raees");
        newStringStack.push("Jahangir");
        newStringStack.push("Khan");
        System.out.println(newStringStack);

        newStringStack.pop();
        //System.out.println(newStringStack);


        //Stack from Lab 1 - exercise 2
        Stack stack = new Stack();
        System.out.println(stack.length());

        //IntQueue
        IntQueue newQueue = new IntQueue();
        newQueue.add(8);
        newQueue.isEmpty();
    }
}
