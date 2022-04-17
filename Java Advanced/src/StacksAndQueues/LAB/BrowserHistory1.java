package StacksAndQueues.LAB;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        ArrayDeque<String> browser = new ArrayDeque<>();
        String current = "";

        while (!command.equals("Home")) {

            if (command.equals("back")) {
                if (browser.isEmpty()|| browser.size()==1){
                    System.out.println("no previous URLs");
                }else {
                    browser.pop();
                    System.out.println(browser.peek());
                }

            } else {
                browser.push(command);
                System.out.println(command);
                current = command;
            }

            command = scanner.nextLine();
        }
    }
}
