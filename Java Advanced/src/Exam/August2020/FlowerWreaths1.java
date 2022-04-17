package Exam.August2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FlowerWreaths1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //стек
        ArrayDeque<Integer> lilies = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(lilies::push);
        //опашка
        ArrayDeque<Integer> roses = Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        int countWreaths = 0;
        int countFlowers = 0;
        while (!lilies.isEmpty() && !roses.isEmpty()) {
            int rose = roses.poll();
            int lili = lilies.pop();
            int sum = rose + lili;

            while (lili > 0) {
                if (sum == 15) {
                    countWreaths++;
                    break;
                } else if (sum < 15) {
                    countFlowers +=sum;
                    break;
                } else {
                    lili -= 2;
                    sum -= 2;
                }
            }
        /*    if (countWreaths == 5) {
                break;
            }*/
        }
       if (countFlowers>=15){
           countWreaths += countFlowers/15;
       }
       if (countWreaths >= 5){
           System.out.printf("You made it, you are going to the competition with %d wreaths!", countWreaths);
       }else {
           System.out.printf("You didn't make it, you need %d wreaths more!", 5-countWreaths);
       }
    }
}
