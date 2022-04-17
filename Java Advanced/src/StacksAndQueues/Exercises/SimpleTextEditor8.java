package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int operations = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> stack = new ArrayDeque<>();

        String text = "";
        for (int i = 1; i <= operations; i++) {
            String command = scanner.nextLine();

            if (command.split("\\s+")[0].equals("1")) {
                String textToAppend = command.split("\\s+")[1];
                stack.push(text);
                text += textToAppend;

            } else if (command.split("\\s+")[0].equals("2")) {
                stack.push(text);
                int removeElement = Integer.parseInt(command.split("\\s+")[1]);
                 text = text.substring(0,text.length() - removeElement);


            } else if (command.split("\\s+")[0].equals("3")) {
                int index = Integer.parseInt(command.split("\\s+")[1]);
                System.out.println(text.charAt(index - 1));

            } else if (command.equals("4")) {
                if (!stack.isEmpty()) {
                    text = stack.pop();
                }
            }
        }

    }
}
