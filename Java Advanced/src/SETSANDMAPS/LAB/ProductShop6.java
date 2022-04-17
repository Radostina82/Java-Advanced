package SETSANDMAPS.LAB;

import com.sun.source.tree.Tree;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        TreeMap<String, LinkedHashMap<String, Double>> market = new TreeMap<>();

        while (!input.equals("Revision")){
        String shop = input.split(", ")[0];
        String product = input.split(", ")[1];
        double price = Double.parseDouble(input.split(", ")[2]);

        market.putIfAbsent(shop, new LinkedHashMap<>());
        market.get(shop).put(product, price);

            input = scanner.nextLine();
        }
        market.entrySet().stream().forEach(entry -> {
            System.out.printf("%s->%n", entry.getKey());
                LinkedHashMap<String, Double> value = entry.getValue();
                for (Map.Entry<String, Double> entry1 : value.entrySet()) {
                    String product = entry1.getKey();
                    double price = entry1.getValue();
                    System.out.printf("Product: %s, Price: %.1f%n", product, price);
            }
        });
    }
}
