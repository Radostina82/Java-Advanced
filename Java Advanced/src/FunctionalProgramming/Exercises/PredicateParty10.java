package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> guest = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("Party!")){
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            Predicate<String> predicate = getPredicate(tokens[1], tokens[2]);
            if (command.equals("Double")){
                for (int i = 0; i < guest.size(); i++) {
                    String name = guest.get(i);
                    if (predicate.test(name)){
                        guest.add(i++, name);
                    }
                }

            }else if (command.equals("Remove")){
                guest.removeIf(predicate);

            }

            input=scanner.nextLine();
        }
        if (guest.isEmpty()){
            System.out.println("Nobody is going to the party!");
        }else {
            Collections.sort(guest);
            System.out.print(String.join(", ", guest) + " are going to the party!");
        }
    }
    public static Predicate<String> getPredicate(String commandType, String arg){

        if (commandType.equals("StartsWith")){
            return name -> name.startsWith(arg);
        }else if (commandType.equals("EndsWith")){
            return name -> name.endsWith(arg);
        }else if (commandType.equals("Length")){
        return name -> name.length()==Integer.parseInt(arg);
        }

        return name -> false;
    }
}
