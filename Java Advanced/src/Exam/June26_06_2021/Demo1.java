package Exam.June26_06_2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Demo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //stack
        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(tasks::push);
        //queue
        ArrayDeque<Integer> threads = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        int killTask = Integer.parseInt(scanner.nextLine());

        while (!tasks.isEmpty() && !threads.isEmpty()){
            int thread = threads.peek();
            int task = tasks.peek();
            if (task==killTask){
                System.out.printf("Thread with value %d killed task %d%n",threads.peek(), tasks.pop());
                break;
            }
            if (thread>=task){
                threads.poll();
                tasks.pop();
            }else {
                threads.poll();
            }
        }
        System.out.println(threads.toString().replaceAll("[\\[\\],]", ""));
    }
}
