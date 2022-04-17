package FunctionalProgramming.LAB;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class FindEvensOrOdds6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] tokens = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int lower = tokens[0];
        int upper = tokens[1];
        String oddOrEven = scanner.nextLine();
        Predicate<Integer> filter = getFilter(oddOrEven);
        Consumer<Integer> printer = x-> System.out.print(x + " ");
        IntStream.rangeClosed(lower, upper).boxed().filter(filter).forEach(printer);
    }

    public static Predicate<Integer> getFilter(String oddOrEven) {
        if (oddOrEven.equals("odd")) {
            return x -> x % 2 != 0;
        }
        return x -> x % 2 == 0;
    }
}
