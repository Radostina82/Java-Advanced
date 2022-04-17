package SETSANDMAPS.Exercises;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        LinkedHashMap<String, LinkedHashMap<String, Long>> data = new LinkedHashMap<>();
        LinkedHashMap<String, Long> countryPopulations = new LinkedHashMap<>();

        while (!input.equals("report")){

        String []token = input.split("\\|");
        String country = token[1];
        String city = token[0];
        long population = Long.parseLong(token[2]);
        data.putIfAbsent(country, new LinkedHashMap<>());
        data.get(country).putIfAbsent(city, population);
        countryPopulations.putIfAbsent(country, (long) 0);
        countryPopulations.put(country, countryPopulations.get(country) + population);

            input = scanner.nextLine();
        }
        data.entrySet().stream().sorted((country1, country2) ->
                country2.getValue().values().stream().reduce(0L,Long::sum).compareTo(country1.getValue().values().stream().reduce(0L, Long::sum))).
                forEach(country -> {
                    System.out.printf("%s (total population: %d)%n", country.getKey(), country.getValue().values().stream().reduce(0L,Long::sum));
                    country.getValue().entrySet().stream().sorted((city1, city2) -> city2.getValue().compareTo(city1.getValue())).
                            forEach(city -> System.out.printf("=>%s: %d%n", city.getKey(), city.getValue()));
                });
    }
}
