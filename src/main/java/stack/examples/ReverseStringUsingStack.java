package stack.examples;

import stack.CustomStack;
import stack.StackEmptyException;
import stack.StackFullException;

public class ReverseStringUsingStack {

    public static void main(String[] args) {
        String word = "Hello World";
        String reversedWord = reverseString(word);
        System.out.println("Actual: " + word);
        System.out.println("Reversed: " + reversedWord);
    }

    private static String reverseString(String word) {
        int length = word.length();
        StringBuilder reversedWord = new StringBuilder(length);
        CustomStack<Character> stack = new CustomStack<>(length);
        try {
            for (int i = 0; i < length; i++) {
                stack.push(word.charAt(i));
            }
            while (!stack.isEmpty()) {
                reversedWord.append(stack.pop());
            }

        } catch (StackFullException e) {
            e.printStackTrace();
        } catch (StackEmptyException e) {
            e.printStackTrace();
        }
        return reversedWord.toString();
    }
}
