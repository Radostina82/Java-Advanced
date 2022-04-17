package SETSANDMAPS.Exercises;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class AMinerTask6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();


        while (!input.equals("stop")){

            String name = input;
            int quantity = Integer.parseInt(scanner.nextLine());
            if (!map.containsKey(name)){
                map.put(name, quantity);

            }else {
            int value = map.get(name);
            map.put(name, value+=quantity);

            }
            input = scanner.nextLine();
        }

        map.forEach((key, value) -> System.out.printf("%s -> %d%n", key, value));
    }
}
