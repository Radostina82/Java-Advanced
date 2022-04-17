package DefiningClasses.LAB.CarInfo1;

import DefiningClasses.LAB.CarInfo1.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();

        for (int i = 1; i <= count; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            Car car;
            if (tokens.length == 1) {
               car= new Car(tokens[0]);
            } else {

              car =  new Car(tokens[0], tokens[1], Integer.parseInt(tokens[2]));

            }
            cars.add(car);
        }
        for (Car car : cars) {
            System.out.println(car.carInfo());
        }
    }
}
