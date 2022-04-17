package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean isBalanced = false;
        for (int i = 0; i <= input.length() - 1; i++) {
            char currentChar = input.charAt(i);
            if (currentChar == '{' || currentChar == '[' || currentChar == '(') {
                stack.push(currentChar);
            } else if (currentChar == '}' || currentChar == ']' || currentChar == ')') {
                if (stack.isEmpty()){
                    isBalanced=false;
                    break;
                }
                char element = stack.pop();
                if (element == '{' && currentChar == '}') {
                    isBalanced = true;
                } else if (element == '[' && currentChar == ']') {
                    isBalanced = true;
                } else if (element == '(' && currentChar==')') {
                    isBalanced = true;
                } else {
                    isBalanced = false;
                    break;
                }
            }
        }
        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
