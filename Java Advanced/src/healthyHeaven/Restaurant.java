package healthyHeaven;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Restaurant {
    private List<Salad> data;
    private String name;

    public Restaurant(String name) {
        this.name = name;
        this.data = new ArrayList<>();
    }

    public void add(Salad salad) {
        data.add(salad);
    }

    public boolean buy(String name) {
      /*  for (Salad salad : data) {
            String nameSalad = salad.getName();
            if (nameSalad.equals(name)) {
                data.remove(salad);
                return true;
            }
        }
        return false;*/
        return this.data.removeIf(salad -> salad.getName().equals(name));
    }

    public Salad getHealthiestSalad() {
      /*  Salad healthiestSalad = null;
        int calorie = Integer.MAX_VALUE;
        for (Salad salad : data) {
            if (salad.getTotalCalories()<calorie){
                healthiestSalad = salad;
                calorie = salad.getTotalCalories();
            }
        }
        return healthiestSalad;*/
        return this.data.stream().min(Comparator.comparing(Salad::getTotalCalories)).orElse(null);
    }

    public String generateMenu() {
        StringBuilder menu = new StringBuilder();
        menu.append(this.name).append(" have ").append(data.size()).append(" salads: ").append(System.lineSeparator());
        for (Salad salad : this.data) {
            menu.append(salad).append(System.lineSeparator());
        }
        return menu.toString().trim();
    }
}
