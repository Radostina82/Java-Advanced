package StacksAndQueues.LAB;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<String> printer = new ArrayDeque<>();

        while (!input.equals("print")){

            if (input.equals("cancel")){
                if (printer.isEmpty()){
                    System.out.println("Printer is on standby");
                }else{
                    System.out.printf("Canceled %s%n", printer.poll());
                }
            }else {
                printer.offer(input);
            }

            input = scanner.nextLine();
        }
        while (!printer.isEmpty()) {
            System.out.println(printer.poll());
        }
    }
}
