package DefiningClasses.Exercises.FamilyTree8;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class FamilyTree {
    private Person person;
    private List<Person> parent;
    private List<Person> children;

    public FamilyTree(){
        this.parent = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public List<Person> getParent() {
        return parent;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(person).append(System.lineSeparator());
        builder.append("Parents: ").append(System.lineSeparator());
        for (Person person1 : parent) {
            builder.append(person1).append(System.lineSeparator());
        }
        builder.append("Children:").append(System.lineSeparator());
        for (Person child : children) {
            builder.append(child).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
