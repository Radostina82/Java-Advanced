package FunctionalProgramming.LAB;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).collect(Collectors.toList());
        numbers.removeIf(num -> num%2!=0);
        for (int i = 0; i < numbers.size(); i++) {
            int num = numbers.get(i);
            if (i==numbers.size()-1){
                System.out.print(num);
            }else {
            System.out.print(num + ", ");
        }}
        System.out.println();
        numbers.sort(Integer::compareTo);
        for (int i = 0; i < numbers.size(); i++) {
            int num = numbers.get(i);
            if (i==numbers.size()-1){
                System.out.print(num);
            }else {
            System.out.print(num + ", ");
        }}

    }
}
