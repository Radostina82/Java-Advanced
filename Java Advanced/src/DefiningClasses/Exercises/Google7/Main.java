package DefiningClasses.Exercises.Google7;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        LinkedHashMap<String, Person> personList = new LinkedHashMap<>();

        while (!input.equals("End")){
            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            String data = tokens[1];
            personList.putIfAbsent(name, new Person(name));

            if (data.equals("company")){
                String companyName = tokens[2];
                String department = tokens[3];
                double salary = Double.parseDouble(tokens[4]);
                Company company = new Company(companyName, department, salary);
                personList.get(name).setCompany(company);
            }else if (data.equals("car")){
                String carModel = tokens[2];
                int carSpeed = Integer.parseInt(tokens[3]);
                Car car = new Car(carModel, carSpeed);
                personList.get(name).setCar(car);

            }else if (data.equals("pokemon")){
                String pokemonName = tokens[2];
                String pokemonType = tokens[3];
                Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                personList.get(name).getPokemons().add(pokemon);

            }else if (data.equals("parents")){
                String parentName = tokens[2];
                String parentBirthday = tokens[3];
                Parent parent = new Parent(parentName, parentBirthday);
                personList.get(name).getParents().add(parent);
            }else if (data.equals("children")){
                String childName = tokens[2];
                String childBirthday = tokens[3];
                Child child = new Child(childName, childBirthday);
                personList.get(name).getChildren().add(child);
            }

            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        System.out.println(input);

        System.out.println(personList.get(input));
    }
}
