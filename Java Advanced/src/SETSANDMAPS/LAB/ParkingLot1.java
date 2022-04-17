package SETSANDMAPS.LAB;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class ParkingLot1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        LinkedHashSet<String> cars = new LinkedHashSet<>();

        while (!input.equals("END")) {
            String command = input.split(", ")[0];
            String car = input.split(", ")[1];

            if (command.equals("IN")) {
                cars.add(car);
            } else if (command.equals("OUT")) {
                cars.remove(car);
            }
            input = scanner.nextLine();
        }
        if (!cars.isEmpty()) {

            for (String car : cars) {
                System.out.println(car);
            }
        } else {
            System.out.println("Parking Lot is Empty");
        }
    }
}
