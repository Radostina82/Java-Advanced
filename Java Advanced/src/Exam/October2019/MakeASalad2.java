package Exam.October2019;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.String.join;

public class MakeASalad2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> queue = readQueue(scanner);
        ArrayDeque<Integer> stack = readStack(scanner);

        while (!queue.isEmpty() && !stack.isEmpty()) {
            int currentSalad = stack.peek();
            while (currentSalad>0 && !queue.isEmpty()){
                String vegetable = queue.poll();
                if (vegetable.equals("tomato")){
                    currentSalad-=80;
                }else if (vegetable.equals("carrot")){
                    currentSalad -= 136;
                }else if (vegetable.equals("lettuce")){
                    currentSalad-=109;
                }else if (vegetable.equals("potato")){
                    currentSalad-=215;
                }
            }
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
        if (!stack.isEmpty()){
             System.out.println(stack.toString().replaceAll("[\\[\\],]", ""));
        }

        if (!queue.isEmpty()){
            System.out.println(String.join(" ", queue));
        }
    }

    public static ArrayDeque<Integer> readStack(Scanner scanner) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int i : input) {
            stack.push(i);
        }
        return stack;
    }

    public static ArrayDeque<String> readQueue(Scanner scanner) {
        ArrayDeque<String> queue = new ArrayDeque<>();
        String[] input = scanner.nextLine().split("\\s+");
        for (String s : input) {
            queue.offer(s);
        }
        return queue;
    }
}
