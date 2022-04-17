package FunctionalProgramming.Exercises;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> guest = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        String input = scanner.nextLine();
        List<String> remove = new ArrayList<>();
        while (!input.equals("Print")) {
            String[] tokens = input.split(";");
            String command = tokens[0];
            Predicate<String> predicate = getPredicate(tokens[1], tokens[2]);
            if (command.equals("Add filter")) {
                for (String s : guest) {
                    if (predicate.test(s)) {
                        remove.add(s);
                    }
                }

            } else if (command.equals("Remove filter")) {
                remove.removeIf(predicate);
            }


            input = scanner.nextLine();
        }

        for (String s : guest) {
            if (!remove.contains(s)){
                System.out.print(s + " ");
            }
        }
    }

    public static Predicate<String> getPredicate(String commandType, String parameters) {
        if (commandType.equals("Starts with")) {
            return name -> name.startsWith(parameters);
        } else if (commandType.equals("Ends with")) {
            return name -> name.endsWith(parameters);
        } else if (commandType.equals("Length")) {
            return name -> name.length() == Integer.parseInt(parameters);
        } else if (commandType.equals("Contains")) {
            return name -> name.contains(parameters);
        } else {
            return name -> false;
        }

    }
}
