package StacksAndQueues.Exercises;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperations2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int[] number = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int num = Integer.parseInt(input[0]);
        int numPop = Integer.parseInt(input[1]);
        int numInStack = Integer.parseInt(input[2]);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i : number) {
            if (stack.size() <= num) {
                stack.push(i);
            } else {
                break;
            }
        }
        for (int j = 1; j <= numPop; j++) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            System.out.println(0);
        } else {
            if (stack.contains(numInStack)) {
                System.out.println("true");
            } else {
                int smallest = Integer.MAX_VALUE;
                for (Integer integer : stack) {
                    if (integer < smallest) {
                        smallest = integer;
                    }
                }
                System.out.println(smallest);
            }
        }
    }
}


