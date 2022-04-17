package StacksAndQueues.LAB;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int decimalNumber = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> binary = new ArrayDeque<>();
        if (decimalNumber == 0) {
            System.out.print(decimalNumber);
        } else {
            while (decimalNumber > 0) {
                int result = decimalNumber % 2;
                binary.push(result);
                decimalNumber /= 2;
            }
        }
       /* for (Integer integer : binary) {
            System.out.print(integer);
        }*/

        while (!binary.isEmpty()) {
            System.out.print(binary.pop());
        }
    }
}
