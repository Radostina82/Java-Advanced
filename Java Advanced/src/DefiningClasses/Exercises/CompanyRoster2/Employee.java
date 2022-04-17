package DefiningClasses.Exercises.CompanyRoster2;

public class Employee {
    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;

    public Employee(String name,double salary, String position, String department){
        this.setName(name);
        this.setSalary(salary);
        this.setPosition(position);
        this.setDepartment(department);
        this.email = "n/a";
        this.age = -1;
    }

    public Employee(String name,double salary, String position, String department, String email, int age){
        this(name, salary, position, department);
        this.email = email;
        this.age = age;
    }

    public Employee(String name,double salary, String position, String department, String email){
        this(name, salary, position, department);
        this.email = email;
    }
    public Employee(String name,double salary, String position, String department, int age){
        this(name, salary, position, department);
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }
    @Override
    public String toString(){
        return String.format("%s %.2f %s %d", name, salary, email, age);
    }
}
