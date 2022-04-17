package DefiningClasses.Exercises.CompanyRoster2;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> people;

    public Department(String name){
    this.name = name;
    this.people = new ArrayList<>();
    }

    public List<Employee> getPeople() {
        return people;
    }

    public String getName() {
        return name;
    }

    public double getAverageSalary(){
        return this.people.stream().mapToDouble(e -> e.getSalary()).average().orElse(0.0);
    }

}
