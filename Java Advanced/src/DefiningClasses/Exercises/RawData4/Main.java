package DefiningClasses.Exercises.RawData4;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashSet<Car> cars = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            int engineSpeed = Integer.parseInt(input[1]);
            int enginePower = Integer.parseInt(input[2]);
            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];
            double tire1Pressure = Double.parseDouble(input[5]);
            int tire1Age = Integer.parseInt(input[6]);
            double tire2Pressure = Double.parseDouble(input[7]);
            int tire2Age = Integer.parseInt(input[8]);
            double tire3Pressure = Double.parseDouble(input[9]);
            int tire3Age = Integer.parseInt(input[10]);
            double tire4Pressure = Double.parseDouble(input[11]);
            int tire4Age = Integer.parseInt(input[12]);
            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tire tire1 = new Tire(tire1Pressure, tire1Age);
            Tire tire2 = new Tire(tire2Pressure, tire2Age);
            Tire tire3 = new Tire(tire3Pressure, tire3Age);
            Tire tire4 = new Tire(tire4Pressure, tire4Age);
            Car car = new Car(model, engine, cargo, tire1, tire2, tire3, tire4);
            cars.add(car);
        }
        String input = scanner.nextLine();

        if (input.equals("fragile")) {
            cars.forEach(e -> {
                if (e.getCargo().getType().equals("fragile")) {
                    for (Tire tire : e.getTires()) {
                        if (tire.getPressure() < 1) {
                            System.out.println(e.getModel());
                            break;
                        }
                    }
                }
            });
        } else if (input.equals("flamable")) {
            cars.forEach(e -> {
                if (e.getCargo().getType().equals("flamable")) {
                    if (e.getEngine().getPower() > 250) {
                        System.out.println(e.getModel());
                    }
                }
            });
        }
    }
}
