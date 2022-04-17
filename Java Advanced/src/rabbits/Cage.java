package rabbits;

import javax.lang.model.element.NestingKind;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private List<Rabbit> data;
    private String name;
    private int capacity;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Rabbit rabbit) {
        if (this.data.size() < this.capacity) {
            this.data.add(rabbit);
        }
    }

    public boolean removeRabbit(String name) {
        for (Rabbit rabbit : data) {
            if (rabbit.getName().equals(name)) {
                data.remove(rabbit);
                return true;
            }
        }
        return false;
    }

    public void removeSpecies(String species) {
        data.removeIf(rabbit -> rabbit.getSpecies().equals(species));
    }

    public Rabbit sellRabbit(String name) {
        Rabbit rabbit = null;
        for (Rabbit rabbit1 : data) {
            if (rabbit1.getName().equals(name)) {
                rabbit1.setAvailable(false);
                rabbit = rabbit1;
                break;
            }
        }
        return rabbit;
    }

    public List<Rabbit> sellRabbitBySpecies(String species) {
        // return this.data.stream().filter(e -> e.getSpecies().equals(species) && e.isAvailable()).collect(Collectors.toList());
        List<Rabbit> rabbits = new ArrayList<>();
        for (Rabbit rabbit : data) {
            if (rabbit.getSpecies().equals(species) && rabbit.isAvailable()) {
                rabbits.add(rabbit);
                rabbit.setAvailable(false);
            }
        }
        return rabbits;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Rabbits available at %s:", this.name)).append(System.lineSeparator());
        for (Rabbit rabbit : data) {
            if (rabbit.isAvailable()){
                builder.append(rabbit).append(System.lineSeparator());;
            }

        }
        return builder.toString().trim();
    }
}
