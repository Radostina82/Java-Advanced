package FunctionalProgramming.LAB;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FilterByAge5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, Integer> people = getPeople(n, scanner);
        printResult(people, scanner);
    }

    public static void printResult(LinkedHashMap<String, Integer> people, Scanner scanner) {
        String input = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String[] command = scanner.nextLine().split("\\s+");
        if (input.equals("younger")) {
            if (command.length == 2) {
                for (Map.Entry<String, Integer> entry : people.entrySet()) {
                    int ages = entry.getValue();
                    if (ages <= age) {
                        System.out.println(entry.getKey() + " - " + entry.getValue());
                    }
                }
            } else if (command.length == 1) {
                if (command[0].equals("name")) {
                    for (Map.Entry<String, Integer> entry : people.entrySet()) {
                        if (entry.getValue() <= age) {
                            System.out.println(entry.getKey());
                        }
                    }
                } else if (command[0].equals("age")) {
                    for (Map.Entry<String, Integer> entry : people.entrySet()) {
                        if (entry.getValue() <= age) {
                            System.out.println(entry.getValue());
                        }
                    }
                }
            }
        } else if (input.equals("older")) {
            if (command.length == 2) {
                for (Map.Entry<String, Integer> entry : people.entrySet()) {
                    int ages = entry.getValue();
                    if (ages >= age) {
                        System.out.println(entry.getKey() + " - " + entry.getValue());
                    }
                }
            } else if (command.length == 1) {
                if (command[0].equals("name")) {
                    for (Map.Entry<String, Integer> entry : people.entrySet()) {
                        if (entry.getValue() >= age) {
                            System.out.println(entry.getKey());
                        }
                    }
                } else if (command[0].equals("age")) {
                    for (Map.Entry<String, Integer> entry : people.entrySet()) {
                        if (entry.getValue() >= age) {
                            System.out.println(entry.getValue());
                        }
                    }
                }
            }
        }
    }

    public static LinkedHashMap<String, Integer> getPeople(int n, Scanner scanner) {
        LinkedHashMap<String, Integer> people = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split(", ");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            people.put(name, age);
        }
        return people;
    }
}

