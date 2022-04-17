package FunctionalProgramming.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOfPredicates9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Function<Integer, List<Integer>> function = e -> {
            List<Integer> numbers = new ArrayList<>();
            for (int i = 1; i <= e; i++) {
                numbers.add(i);
            }
            return numbers;
        };
        List<Integer> numbers = function.apply(n);
        List<Integer> input = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        Predicate<Integer> predicate = num -> {
            for (Integer integer : input) {
                if (integer == 0) {
                    continue;
                }
                if (num % integer != 0) {
                    return false;
                }
            }
            return true;
        };
        numbers.stream().filter(predicate).forEach(e -> System.out.print(e + " "));
    }
}
