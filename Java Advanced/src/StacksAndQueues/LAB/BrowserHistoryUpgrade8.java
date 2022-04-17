package StacksAndQueues.LAB;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        ArrayDeque<String> history  = new ArrayDeque<>();
        ArrayDeque<String> forward = new ArrayDeque<>();


        while (!command.equals("Home")) {

            if (command.equals("back")) {
                if (history.size() < 2) {
                    System.out.println("no previous URLs");
                } else {
                    forward.addFirst(history.peek());
                    history.pop();
                    System.out.println(history.peek());
                }

            } else if (command.equals("forward")) {
                if (forward.size() < 1) {
                    System.out.println("no next URLs");
                }else {
                    System.out.println(forward.peek());
                    history.push(forward.pop());
                }
            } else {
                System.out.println(command);
                history.push(command);
                forward.clear();

            }


            command = scanner.nextLine();
        }
    }
}
