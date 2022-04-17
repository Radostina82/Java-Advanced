package Generics.Exercises.CustomList7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomList<String> list = new CustomList<>();

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String command = input.split("\\s+")[0];

            if (command.equals("Add")) {
                String element = input.split("\\s+")[1];
                list.add(element);
            } else if (command.equals("Remove")) {
                int index = Integer.parseInt(input.split("\\s+")[1]);
               list.remove(index);
            } else if (command.equals("Contains")) {
                String element = input.split("\\s+")[1];
                System.out.println(list.contains(element));
            } else if (command.equals("Swap")) {
                int startIndex = Integer.parseInt(input.split("\\s+")[1]);
                int endIndex = Integer.parseInt(input.split("\\s+")[2]);
                list.swap(startIndex, endIndex);
            } else if (command.equals("Greater")) {
                String element = input.split("\\s+")[1];
                System.out.println(list.countGreaterThan(element));
            } else if (command.equals("Max")) {
                System.out.println(list.getMax());
            } else if (command.equals("Min")) {
                System.out.println(list.getMin());
            } else if (command.equals("Print")) {
                for (String s : list) {
                    System.out.println(s + " ");
                }
            }
            input = scanner.nextLine();
        }
    }
}
