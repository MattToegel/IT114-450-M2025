package module1;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackSample {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        System.out.println("Stack: " + stack.toString());

        Integer head = stack.peek();
        System.out.println("Head of stack: " + head);

        Integer i;
        try {
            while ((i = stack.pop()) != null) {
                System.out.println("Retrieved " + i);
            }
        } catch (EmptyStackException e) {
            System.out.println("Stack is empty");
        }
    }
}