package SETSANDMAPS.LAB;

import java.util.*;

public class CitiesByContinentAndCountry7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, LinkedHashMap<String, List<String>>> continents = new LinkedHashMap<>();
        for (int i = 1; i <= count ; i++) {
            String [] input = scanner.nextLine().split("\\s+");
            String continent = input[0];
            String country = input[1];
            String city = input[2];
            continents.putIfAbsent(continent, new LinkedHashMap<>());
           LinkedHashMap<String, List<String>> inner = continents.get(continent);
           inner.putIfAbsent(country, new ArrayList<>());
           inner.get(country).add(city);
        }

        continents.entrySet().forEach(entry ->{
            System.out.println(entry.getKey() + ":");
            LinkedHashMap<String,List<String> > country = entry.getValue();
            for (Map.Entry<String, List<String>> listEntry : country.entrySet()) {
                System.out.printf(" %s -> ", listEntry.getKey());
                List<String> city = listEntry.getValue();
                System.out.println(String.join(", ", city));
            }

        });
    }
}
