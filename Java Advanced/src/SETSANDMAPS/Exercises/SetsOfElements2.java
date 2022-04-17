package SETSANDMAPS.Exercises;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int count1 = input[0];
        int count2 = input[1];
        LinkedHashSet<Integer> col1 = new LinkedHashSet<>();
        LinkedHashSet<Integer> col2 = new LinkedHashSet<>();

        for (int i = 1; i <= count1 ; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            col1.add(number);
        }


        for (int i = 1; i <= count2 ; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            col2.add(number);
        }
        for (Integer integer : col1) {
            int element = integer;
            for (Integer integer1 : col2) {
                int element1 = integer1;
                if (element==element1){
                    System.out.print(element + " ");
                }
            }
        }
    }
}
