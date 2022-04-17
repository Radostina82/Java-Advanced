package bakery;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bakery {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        if (this.employees.size() < this.capacity) {
           this.employees.add(employee);
        }
    }

    public boolean remove(String name) {
        Employee employee = employees.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
        if (employee != null) {
            employees.remove(employee);
            return true;
        }
        return false;
    }

    public Employee getOldestEmployee() {
        if (this.employees.size()==0){
            return null;
        }
        return this.employees.stream().max(Comparator.comparing(Employee::getAge)).get();
    }
    public  Employee getEmployee(String name){
        return this.employees.stream().filter(e-> e.getName().equals(name)).findFirst().orElse(null);
    }
    public int getCount(){
        return this.employees.size();
    }
    public String report(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Employees working at Bakery %s:", this.name)).append(System.lineSeparator());
        for (Employee employee : employees) {
            builder.append(employee).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
