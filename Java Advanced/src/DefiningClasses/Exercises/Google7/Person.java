package DefiningClasses.Exercises.Google7;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String personName;
    private Company company;
    private Car car;
    private List<Pokemon> pokemons;
    private List<Parent> parents;
    private List<Child> children;

    public Person(String personName) {
        this.personName = personName;
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public List<Child> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Company:").append(System.lineSeparator());
        if (company != null) {
            builder.append(company).append(System.lineSeparator());
        }
        builder.append("Car:").append(System.lineSeparator());
        if (car != null) {
            builder.append(car).append(System.lineSeparator());
        }
        builder.append("Pokemon:").append(System.lineSeparator());
        if (!pokemons.isEmpty()) {
            for (Pokemon pokemon : pokemons) {
                builder.append(pokemon).append(System.lineSeparator());
            }

        }
        builder.append("Parents:").append(System.lineSeparator());
        if (!parents.isEmpty()) {
            for (Parent parent : parents) {
                builder.append(parent).append(System.lineSeparator());
            }
        }
        builder.append("Children:").append(System.lineSeparator());
        if (!children.isEmpty()) {
            for (Child child : children) {
                builder.append(child).append(System.lineSeparator());
            }
        }
        return builder.toString();
    }
}
