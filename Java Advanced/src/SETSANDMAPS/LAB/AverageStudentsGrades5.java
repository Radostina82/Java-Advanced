package SETSANDMAPS.LAB;

import java.util.*;

public class AverageStudentsGrades5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        TreeMap<String, List<Double>> students = new TreeMap<>();

        for (int i = 1; i <= count ; i++) {
            String [] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            double grade = Double.parseDouble(input[1]);
             students.putIfAbsent(name, new ArrayList<>());
             students.get(name).add(grade);
        }

        for (Map.Entry<String, List<Double>> entry : students.entrySet()) {
            String name = entry.getKey();
            List<Double> grade = entry.getValue();
            double sum = 0;
            for (Double aDouble : grade) {
                sum+=aDouble;
            }
            double average = sum/grade.size();
            System.out.printf("%s -> ", name);
            for (Double aDouble : grade) {
                System.out.printf("%.2f ", aDouble);
            }
            System.out.printf("(avg: %.2f)%n", average);
        }
     /*   students.entrySet().stream().forEach(entry->{
            double sum = 0;
            for (int i = 0; i <entry.getValue().size() ; i++) {
                sum += entry.getValue().get(i);
            }
            double avgSum = sum/entry.getValue().size();
            System.out.println(entry.getKey() + " -> ");
            entry.getValue().forEach(e -> System.out.printf("%.2f", e));
            System.out.printf("(avg: %.2f)%n", avgSum);
        });*/
    }
}
