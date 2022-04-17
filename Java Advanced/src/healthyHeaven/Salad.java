package healthyHeaven;

import java.util.ArrayList;
import java.util.List;

public class Salad {
    private List<Vegetable> products;
    private String name;

    public Salad(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getTotalCalories() {
        int totalCalories = 0;
        for (Vegetable vegetable : products) {
            totalCalories += vegetable.getCalories();
        }
        return totalCalories;
    }

    public int getProductCount() {
        return this.products.size();
    }

    public void add(Vegetable product) {
        products.add(product);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        String output = String.format("* Salad %s is %d calories and have %d products:", this.getName(), this.getTotalCalories(), this.getProductCount());
       builder.append(output).append(System.lineSeparator());
        for (Vegetable product : this.products) {
            builder.append(product).append(System.lineSeparator());
        }

        return builder.toString().trim();
    }
}
