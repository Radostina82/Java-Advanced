package SETSANDMAPS.Exercises;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        TreeSet<String> chemical = new TreeSet<>();

        for (int i = 1; i <= count ; i++) {
        String[] input = scanner.nextLine().split("\\s+");
            chemical.addAll(Arrays.asList(input));
        }
        chemical.stream().forEach(element-> System.out.print(element + " "));
    }
}
