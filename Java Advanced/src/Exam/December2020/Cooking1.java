package Exam.December2020;

import java.util.*;
import java.util.stream.Collectors;

public class Cooking1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //опашка
        ArrayDeque<Integer> liquids = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        //стек
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(ingredients::push);
        TreeMap<String, Integer> cookFood = new TreeMap<>();
        cookFood.put("Bread", 0);
        cookFood.put("Cake", 0);
        cookFood.put("Fruit Pie", 0);
        cookFood.put("Pastry", 0);

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int liquid = liquids.poll();
            int ingredient = ingredients.pop();
            int sum = liquid + ingredient;

            if (sum == 25) {
                cookFood.put("Bread", cookFood.get("Bread") + 1);
            } else if (sum == 50) {
                cookFood.put("Cake", cookFood.get("Cake") + 1);
            } else if (sum == 100) {
                cookFood.put("Fruit Pie", cookFood.get("Fruit Pie") + 1);
            } else if (sum == 75) {
                cookFood.put("Pastry", cookFood.get("Pastry") + 1);
            } else {
                ingredients.push(ingredient + 3);
            }
        }

        if (cookFood.containsValue(0)) {
            System.out.println("Ugh, what a pity! You didn't have enough materials to to cook everything.");
        } else {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        }
        if (liquids.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.println("Liquids left: " + liquids.toString().replaceAll("[\\[\\]]", ""));
        }
        if (ingredients.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.println("Ingredients left: " + ingredients.toString().replaceAll("[\\[\\]]", ""));
        }

        cookFood.entrySet().forEach(c -> {
            if (c.getKey().equals("Bread")) {
                System.out.println("Bread: " + c.getValue());
            } else if (c.getKey().equals("Cake")) {
                System.out.println("Cake: " + c.getValue());
            } else if (c.getKey().equals("Fruit Pie")) {
                System.out.println("Fruit Pie: " + c.getValue());
            } else if (c.getKey().equals("Pastry")) {
                System.out.println("Pastry: " + c.getValue());
            }
        });
    }
}
