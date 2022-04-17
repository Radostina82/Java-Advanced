package FunctionalProgramming.LAB;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class CountUppercaseWords3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Predicate<String> capitalLetter = str -> Character.isUpperCase(str.charAt(0));
        String []text = Arrays.stream(scanner.nextLine().split("\\s+")).filter(capitalLetter).toArray(String[]::new);
        Consumer<String[]> print = arr -> {
            System.out.println(arr.length);
            for (String s : arr) {
                System.out.println(s);
            }
        };
        print.accept(text);



    }
}
