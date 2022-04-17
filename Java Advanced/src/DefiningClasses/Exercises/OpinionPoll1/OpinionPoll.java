package DefiningClasses.Exercises.OpinionPoll1;

public class OpinionPoll {
    private String name;
    private int age;

    public OpinionPoll(String name, int age){
        this.setName(name);
        this.setAge(age);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
