package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CustomComparator8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        // а и б четни
        //а четно б нечетно
        //а нечетно б четно
        // а нечетно и б четно
        Comparator<Integer> comparator = ((a1, a2) -> {
            if (a1 % 2 == 0 && a2 % 2 != 0) {//ако първото е четно, вторато нечетно не ги разменяме
                return -1;
            } else if (a1 % 2 != 0 && a2 % 2 == 0) {//ако първото е нечетно, а второто четно ги разменяма
                return 1;
            } else if ((a1 % 2 == 0 && a2 % 2 == 0) || (a1 % 2 != 0 && a2 % 2 != 0)) {
                if (a1 > a2) {
                    return 1;
                } else if (a1 < a2) {
                    return -1;
                }
            }
            return 0;//ако са равни
        });
        numbers.sort(comparator);
        numbers.forEach(e -> System.out.print(e + " "));
    }
}
