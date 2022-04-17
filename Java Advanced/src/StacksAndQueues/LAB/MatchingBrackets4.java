package StacksAndQueues.LAB;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i <= expression.length()-1 ; i++) {
            char element = expression.charAt(i);

            if (element == '('){
                stack.push(i);
            }else if (element==')'){
                int startIndex = stack.pop();
                String contents = expression.substring(startIndex, i+1);
                System.out.println(contents);
            }
        }
    }
}
