package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            String command = scanner.nextLine();

            if (command.equals("2")) {
                stack.pop();
            } else if (command.equals("3")) {
                if (!stack.isEmpty()) {
                    System.out.println(Collections.max(stack));
                  //  System.out.println(maxElement(stack));
                }
            } else if (command.split("\\s+")[0].equals("1")) {
                int element = Integer.parseInt(command.split("\\s+")[1]);
                stack.push(element);
            }
        }
    }

   /* public static int maxElement(ArrayDeque<Integer> stack) {
        int maxElement = Integer.MIN_VALUE;
        while (!stack.isEmpty()) {

            int element = stack.pop();
            if (element > maxElement) {
                maxElement = element;
            }
        }
        return maxElement;
    }*/

}
