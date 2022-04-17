package SETSANDMAPS.Exercises;

import java.sql.SQLOutput;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class FixEmails7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        LinkedHashMap<String, String> map = new LinkedHashMap<>();

        while (!input.equals("stop")){
            String name = input;
            String mail = scanner.nextLine();
            if (!mail.contains(".us") && !mail.contains(".uk") && !mail.contains(".com")){
                map.put(name, mail);
            }

            input = scanner.nextLine();
        }
        map.forEach((key, value) -> System.out.printf("%s -> %s%n", key, value));
    }
}
