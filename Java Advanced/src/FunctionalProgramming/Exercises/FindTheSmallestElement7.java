package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        Function<List<Integer>, Integer> smallest = list -> {
            int minNum = Integer.MAX_VALUE;
            for (Integer integer : list) {
                if (integer<minNum){
                    minNum = integer;
                }
            }
            return list.lastIndexOf(minNum);
        };
        System.out.println(smallest.apply(numbers));
    }
}
