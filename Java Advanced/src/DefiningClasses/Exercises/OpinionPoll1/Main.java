package DefiningClasses.Exercises.OpinionPoll1;

import DefiningClasses.Exercises.OpinionPoll1.OpinionPoll;

import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        TreeMap<String, Integer> list = new TreeMap<>();

        for (int i = 0; i < count; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            OpinionPoll opinionPoll = new OpinionPoll(input[0], Integer.parseInt(input[1]));
            list.put(input[0], Integer.parseInt(input[1]));
        }

        list.entrySet().stream().filter(e-> e.getValue() > 30).forEach(name ->{
            System.out.println(name.getKey() + " - " + name.getValue());
        });
    }
}
