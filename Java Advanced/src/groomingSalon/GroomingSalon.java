package groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private List<Pet> data;
    private int capacity;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (this.data.size() < this.capacity) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        if (this.data.isEmpty()) {
            return false;
        } else {
            Pet pet = this.data.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
            if (pet != null) {
                this.data.remove(pet);
                return true;
            }
        }
        return false;
    }

    public Pet getPet(String name, String owner) {
        return this.data.stream().filter(p -> p.getName().equals(name) && p.getOwner().equals(owner)).findFirst().orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        builder.append("The grooming salon has the following clients:").append(System.lineSeparator());
        for (Pet pet : data) {
            builder.append(String.format("%s %s", pet.getName(), pet.getOwner())).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
