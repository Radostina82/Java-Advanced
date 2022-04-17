package FunctionalProgramming.LAB;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortEvenNumbers1_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).
                filter(num -> num % 2 == 0).toArray();

        String output = Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.joining(", "));

        System.out.println(output);

     String sortNumbers =   Arrays.stream(numbers).sorted().mapToObj(String::valueOf).collect(Collectors.joining(", "));

        System.out.println(sortNumbers);
    }
}
