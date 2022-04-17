package SETSANDMAPS.LAB;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] input = readArr(scanner, "\\s+");
        LinkedHashMap<Double, Integer> map = new LinkedHashMap<>();
        int count =0;

        for (int i = 0; i < input.length; i++) {
            double element = input[i];
            map.putIfAbsent(element, count);
            map.put(element, map.get(element) +1);
        }

        for (Map.Entry<Double, Integer> entry : map.entrySet()) {
            System.out.printf("%.1f -> %d%n", entry.getKey(), entry.getValue());
        }
    }
    public static double [] readArr(Scanner scanner, String pattern){
        return Arrays.stream(scanner.nextLine().split(pattern)).mapToDouble(Double::parseDouble).toArray();
    }
}
