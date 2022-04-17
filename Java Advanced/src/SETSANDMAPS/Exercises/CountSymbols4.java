package SETSANDMAPS.Exercises;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class CountSymbols4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        TreeMap<Character, Integer> set = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char element = input.charAt(i);
            set.putIfAbsent(element, 0);
            set.put(element, set.get(element) + 1);
        }
       set.entrySet().stream().forEach(element ->{
           System.out.printf("%s: %d time/s%n", element.getKey(), element.getValue());
       });
    }
}
