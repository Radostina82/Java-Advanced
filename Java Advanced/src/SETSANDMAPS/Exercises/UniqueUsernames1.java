package SETSANDMAPS.Exercises;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class UniqueUsernames1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        LinkedHashSet<String> users = new LinkedHashSet<>();
        for (int i = 1; i <= count ; i++) {
            String input = scanner.nextLine();
            users.add(input);
        }

        for (String user : users) {
            System.out.println(user);
        }
    }
}
