package SETSANDMAPS.LAB;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class VoinaNumberGame3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashSet<Integer> player1 =getPlayer(scanner);
        LinkedHashSet<Integer> player2 = getPlayer(scanner);

        for (int i = 1; i <=50 ; i++) {
            int first = getFirst(player1);
            int second = getFirst(player2);
            player1.remove(first);
            player2.remove(second);
            if (first>second){
                player1.add(first);
                player1.add(second);
            }else if (second>first){
                player2.add(first);
                player2.add(second);
            }
            if (player1.isEmpty() || player2.isEmpty()){
                break;
            }
        }
        if (player1.size()>player2.size()){
            System.out.println("First player win!");
        }else if (player2.size()>player1.size()){
            System.out.println("Second player win!");
        }else {
            System.out.println("Draw!");
        }
    }
    public static int getFirst(LinkedHashSet<Integer> set){
        for (Integer integer : set) {
            return integer;
        }
        return 0;
    }
    public static LinkedHashSet<Integer> getPlayer(Scanner scanner){
        return Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
