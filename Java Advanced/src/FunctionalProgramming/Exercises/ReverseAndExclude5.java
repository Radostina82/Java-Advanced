package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import java.util.function.Consumer;

import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        int n = Integer.parseInt(scanner.nextLine());
        Predicate<Integer> predicate = element -> element % n ==0;
        Collections.reverse(numbers);
        numbers.removeIf(predicate);
        Consumer<List<Integer>> printer = list -> list.forEach(e -> System.out.print(e + " "));
        printer.accept(numbers);
    }
}
