package Exam.Fubruary2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lootbox1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //опашка
        ArrayDeque<Integer> queue = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).
                collect(Collectors.toCollection(ArrayDeque::new));
        //стек
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(stack::push);
        int sum = 0;

        while (!queue.isEmpty() && !stack.isEmpty()) {
            int firstNumber = queue.peek();
            int secondNumber = stack.pop();

            if ((firstNumber + secondNumber) % 2 == 0) {
                sum += firstNumber + secondNumber;
                queue.poll();
            } else {
                queue.offer(secondNumber);
            }
        }
        if (queue.isEmpty()) {
            System.out.println("First lootbox is empty");
        }
        if (stack.isEmpty()) {
            System.out.println("Second lootbox is empty");
        }
        if (sum >= 100) {
            System.out.println("Your loot was epic! Value: " + sum);
        }else {
            System.out.println("Your loot was poor... Value: " + sum);
        }
    }
}
