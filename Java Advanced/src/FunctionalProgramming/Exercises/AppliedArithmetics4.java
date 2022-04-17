package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetics4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Function<int[], int[]> add = arr -> Arrays.stream(arr).map(e -> e += 1).toArray();
        Function<int[], int[]> multiply = arr -> Arrays.stream(arr).map(e -> e *= 2).toArray();
        Function<int[], int[]> subtract = arr -> Arrays.stream(arr).map(e -> e -= 2).toArray();
        Consumer<int[]> printer = number -> Arrays.stream(number).forEach(e-> System.out.print(e + " "));

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            if (input.equals("add")){
              numbers =  add.apply(numbers);
            }else if (input.equals("multiply")){
               numbers = multiply.apply(numbers);
            }else if (input.equals("subtract")){
               numbers = subtract.apply(numbers);
            }
            input = scanner.nextLine();
        }
            printer.accept(numbers);
    }
}
