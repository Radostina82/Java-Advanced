package vetClinic;

import java.lang.management.ThreadInfo;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Clinic {
    private List<Pet> data;
    private int capacity;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (this.data.size() < capacity) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        Pet pet = this.data.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
        if (pet != null) {
           this.data.remove(pet);
            return true;
        }
        return false;
    }

    public Pet getPet(String name, String owner) {

        return this.data.stream().filter(p -> p.getName().equals(name) && p.getOwner().equals(owner)).findFirst().orElse(null);
    }

    public Pet getOldestPet() {
        if (this.data.isEmpty()) {
            return null;
        } else {
            return this.data.stream().max(Comparator.comparing(Pet::getAge)).get();//връща най-високата възраст
        }
    }

    public int getCount() {
        return this.data.size();
    }
    public String getStatistics(){
        //The clinic has the following patients:
        //{name} {owner}
        //{name} {owner}
        StringBuilder builder = new StringBuilder();
        builder.append("The clinic has the following patients:").append(System.lineSeparator());
        for (Pet pet : data) {
            builder.append(String.format("%s %s", pet.getName(), pet.getOwner())).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
