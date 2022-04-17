package Exam.ExamOctober2019;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DatingApp1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //stack
        ArrayDeque<Integer> males = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(males::push);
        //opashka
        ArrayDeque<Integer> females = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        int match = 0;
        while (!males.isEmpty() && !females.isEmpty()) {
            int male = males.peek();
            int female = females.peek();

            if (male <= 0 || male % 25 == 0) {
                male = males.pop();
                if (!males.isEmpty()) {

                    continue;
                } else {
                    break;
                }
            }
            if (female <= 0 || female % 25 == 0) {
                females.poll();
                if (!females.isEmpty()) {

                    continue;
                } else {
                    break;
                }
            }
            if (male == female) {
                match++;
                males.pop();
                females.poll();
            } else {
                females.poll();
                if (male - 2 > 0) {
                    males.pop();
                    males.addFirst(male - 2);
                } else {
                    males.pop();
                }
            }

        }
        System.out.println("Matches: " + match);
        if (males.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            System.out.print("Males left: ");
            System.out.print(males.toString().replaceAll("[\\[\\]]", ""));
            System.out.println();
        }
        if (females.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            System.out.print("Females left: ");
            System.out.print(females.toString().replaceAll("[\\[\\]]", ""));

        }
    }
}
