package remijan.m.lecture;

import java.util.Stack;

public class Ex04_Stack {

    public static void main(String[] args) {
        
        // A Stack is a First In Last Out (FILO) data structure.
        // It has these basic operations
        //  push (add object to top of the stack)
        //  peek (get the object at the top of the stack but don't remove it)
        //  pop  (get the object at the top of the stack and remove it)
        //
        Stack<String> stack = new Stack<>();

        stack.push("one");
        stack.push("two");
        stack.push("three");
        stack.push("four");

        System.out.printf("Size: %d%n", stack.size());

        String peek = stack.peek();
        System.out.printf("peek: %s%n", peek);
        System.out.printf("Size: %d%n", stack.size());

        while (!stack.isEmpty()) {
            String pop = stack.pop();
            System.out.printf("POP: %s  %d%n", pop, stack.size());
        }

    }
}
