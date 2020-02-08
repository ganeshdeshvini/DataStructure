package stack.examples;

import stack.CustomStack;
import stack.StackEmptyException;
import stack.StackFullException;

public class StackRunner {
    public static void main(String[] args) throws StackFullException, StackEmptyException {
        stackIntegerTest();
//        stackStringTest();
    }

    static void stackIntegerTest() throws StackFullException, StackEmptyException {
        CustomStack<Integer> customStack = new CustomStack(5);
        customStack.push(11);
        customStack.push(12);
        customStack.push(13);
        customStack.push(14);
        customStack.push(15);
        System.out.println(customStack);
//        customStack.push(16);
        //
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        System.out.println(customStack);

        customStack.push(16);
        System.out.println(customStack);
    }

    static void stackStringTest() throws StackFullException, StackEmptyException {
        CustomStack<String> customStack = new CustomStack(5);
        customStack.push("element1");
        customStack.push("element2");
        customStack.push("element3");
        customStack.push("element4");
        customStack.push("element5");
        System.out.println(customStack);
//        customStack.push("e6);
        //
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        System.out.println(customStack);
    }
}