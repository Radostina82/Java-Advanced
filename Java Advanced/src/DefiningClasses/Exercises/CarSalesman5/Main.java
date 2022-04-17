package DefiningClasses.Exercises.CarSalesman5;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Engine> engines = readEngins(n, scanner);
        n = Integer.parseInt(scanner.nextLine());
        List<Car> cars = readCar(n, scanner, engines);

        for (Car car : cars) {
            System.out.println(car);
        }
    }

    public static List<Car> readCar(int n, Scanner scanner, List<Engine> engines) {
        List<Car> listCar = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            String engineName = input[1];
            Car car = null;
            Engine engine = null;
            for (Engine engine1 : engines) {
                if (engine1.getModel().equals(engineName)) {
                    engine = engine1;
                    break;
                }
            }
            if (input.length == 4) {
                String weight = input[2];
                String color = input[3];
                car = new Car(model, engine, weight, color);
            } else if (input.length == 3) {
                if (isNum(input[2])) {
                    String weight = input[2];
                    car = new Car(model, engine);
                    car.setWeight(weight);
                } else {
                    String color = input[2];
                    car = new Car(model, engine);
                    car.setColor(color);
                }

            } else if (input.length == 2) {
                car = new Car(model, engine);

            }
            listCar.add(car);
        }
        return listCar;
    }

    public static List<Engine> readEngins(int n, Scanner scanner) {
        List<Engine> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            String power = input[1];
            Engine engine = null;
            if (input.length == 4) {
                String displacement = input[2];
                String efficiency = input[3];
                engine = new Engine(model, power, displacement, efficiency);
            } else if (input.length == 3) {
                String line = input[2];
                engine = new Engine(model, power);
                if (isNum(input[2])) {
                    engine.setDisplacement(line);
                } else {
                    engine.setEfficiency(line);
                }
            } else if (input.length == 2) {
                engine = new Engine(model, power);
            }
            list.add(engine);
        }
        return list;
    }
    public static boolean isNum(String s){
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)){
                return true;
            }else {
                return false;
            }
        }
        return true;
    }
}
