package DefiningClasses.Exercises.CompanyRoster2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        HashMap<String, Department> departments = new HashMap<>();
        for (int i = 0; i < count; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
             double salary = Double.parseDouble(input[1]);
            String position=input[2];
             String department = input[3];
            Employee employee = null;
            if (input.length==6){
                String email = input[4];
                int age = Integer.parseInt(input[5]);
                employee = new Employee(name, salary, position, department, email, age);
            }else if (input.length == 5){
                String parameter = input[4];
                if (parameter.contains("@")){
                    employee = new Employee(name, salary, position, department, parameter);
                }else {
                    employee = new Employee(name, salary, position, department,Integer.parseInt(parameter));
                }
            }else if (input.length==4){
                employee = new Employee(name, salary, position, department);
            }

            departments.putIfAbsent(department, new Department(department));
            departments.get(department).getPeople().add(employee);
        }
        Department maxDepartmentAverSalary = departments.entrySet()
                .stream()
                .max(Comparator.comparingDouble(entry -> entry.getValue().getAverageSalary()))
                .get()
                .getValue();
        System.out.println("Highest Average Salary: " + maxDepartmentAverSalary.getName());
        maxDepartmentAverSalary.getPeople().
                stream()
                .sorted((e1,e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(employee -> System.out.println(employee));
    }
}
