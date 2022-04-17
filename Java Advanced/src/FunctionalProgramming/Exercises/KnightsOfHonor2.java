package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class KnightsOfHonor2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> input = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        Consumer<String> result = s -> System.out.println("Sir " + s);
        for (String s : input) {

            result.accept(s);
        }
    }
}
