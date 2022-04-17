package StacksAndQueues.LAB;

import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String []name = scanner.nextLine().split("\\s+");
        int count = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> children = new ArrayDeque<>();

        for (String s : name) {
            children.offer(s);
        }
        while (children.size()>1){

            for (int i = 1; i <count ; i++) {
                String remove = children.poll();
               children.offer(remove);
            }
            System.out.printf("Removed %s%n", children.poll());
        }
        System.out.println("Last is " + children.poll());
    }
}
