package SETSANDMAPS.LAB;

import java.util.*;
import java.util.stream.Collectors;

public class AcademyGraduation8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        TreeMap<String, List<Double>> names = new TreeMap<>();
        for (int i = 1; i <= count ; i++) {
            String name = scanner.nextLine();
            List<Double> grade = Arrays.stream(scanner.nextLine().split("\\s+")).map(Double::parseDouble).collect(Collectors.toList());
            names.put(name, grade);
        }

        names.entrySet().stream().forEach(entry->{
            System.out.printf("%s is graduated with ", entry.getKey());
            List<Double> grade = entry.getValue();
            double sum = 0;
            for (Double aDouble : grade) {
                sum += aDouble;
            }
            double avr = sum / grade.size();
            System.out.println(avr);
        });
    }
}
