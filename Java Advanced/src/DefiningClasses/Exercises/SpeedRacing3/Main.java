package DefiningClasses.Exercises.SpeedRacing3;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashSet<Car> cars = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            double fuelAmount = Double.parseDouble(input[1]);
            double costFor1Km = Double.parseDouble(input[2]);
            Car car = new Car(model, fuelAmount, costFor1Km);
            cars.add(car);
        }

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String carModel = tokens[1];
            int km = Integer.parseInt(tokens[2]);

            for (Car car : cars) {
                if (car.getModel().equals(carModel)) {
                    if (car.canMove(km)) {
                        int distance = car.getDistance() + km;
                        car.setDistance(distance);
                        double fuelAmount = car.getFuelAmount() - (car.getCostFor1Km() * km);
                        car.setFuelAmount(fuelAmount);
                    } else {
                        System.out.println("Insufficient fuel for the drive");
                    }
                }
            }
            input = scanner.nextLine();
        }
        cars.stream().forEach(System.out::println);
    }
}
