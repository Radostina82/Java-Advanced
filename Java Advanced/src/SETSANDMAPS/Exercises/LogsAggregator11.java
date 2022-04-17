package SETSANDMAPS.Exercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class LogsAggregator11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeMap<String, Integer> userDurations = new TreeMap<>();
        TreeMap<String, TreeSet<String>> userId = new TreeMap<>();
        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            String ip = input.split("\\s+")[0];
            String name = input.split("\\s+")[1];
            int duration = Integer.parseInt(input.split("\\s+")[2]);
            userDurations.putIfAbsent(name, 0);
            userDurations.put(name, userDurations.get(name) + duration);
            userId.putIfAbsent(name, new TreeSet<>());
            userId.get(name).add(ip);
        }
        for (Map.Entry<String, Integer> users : userDurations.entrySet()) {
            System.out.print(users.getKey() + ": " + users.getValue() + " ");
            for (Map.Entry<String, TreeSet<String>> id : userId.entrySet()) {
                if (users.getKey().equals(id.getKey())) {
                    System.out.print("[");
                    System.out.print(String.join(", ", id.getValue()));
                    System.out.print("]");
                }
            }
            System.out.println();
        }

    }
}
