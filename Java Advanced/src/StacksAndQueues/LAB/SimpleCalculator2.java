package StacksAndQueues.LAB;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] output = scanner.nextLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = output.length - 1; i >= 0; i--) {
            String element = output[i];
            stack.push(element);
        }


        while (stack.size()>1) {
            int leftElement = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int rightElement = Integer.parseInt(stack.pop());

             int result = operator.equals("+")
                     ? leftElement + rightElement
                     : leftElement - rightElement;
             stack.push(String.valueOf(result));
        }
        System.out.println(stack.peek());
    }
}
