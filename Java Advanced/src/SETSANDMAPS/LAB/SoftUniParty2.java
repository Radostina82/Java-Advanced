package SETSANDMAPS.LAB;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class SoftUniParty2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        TreeSet<String> vip = new TreeSet<>();
        TreeSet<String> regular = new TreeSet<>();

        while (!input.equals("PARTY")){
            char firstCharacter = input.charAt(0);
            if (Character.isDigit(firstCharacter)){
                vip.add(input);
            }else {
                regular.add(input);
            }
            input=scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!input.equals("END")){
            char firstCharacter = input.charAt(0);
            if (Character.isDigit(firstCharacter)){
                vip.remove(input);
            }else {
                regular.remove(input);
            }
            input = scanner.nextLine();
        }
        System.out.println(vip.size() + regular.size());
        for (String s : vip) {
            System.out.println(s);
        }
        for (String s : regular) {
            System.out.println(s);
        }
    }
}
