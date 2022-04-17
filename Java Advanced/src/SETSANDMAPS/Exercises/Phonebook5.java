package SETSANDMAPS.Exercises;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Phonebook5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, String> phone = getPhone(scanner, "-");
        String input = scanner.nextLine();
        while (!input.equals("stop")){
            if (phone.containsKey(input)){

                System.out.printf("%s -> %s%n", input, phone.get(input));
            }else {
                System.out.printf("Contact %s does not exist.%n", input);
            }
            input = scanner.nextLine();
        }

    }
    public static LinkedHashMap<String, String > getPhone(Scanner scanner, String pattern){
        LinkedHashMap<String, String > phone = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("search")){
            String name = input.split(pattern)[0];
            String number = input.split(pattern)[1];
            phone.put(name, number);
            input = scanner.nextLine();
        }
        return  phone;
    }
}
