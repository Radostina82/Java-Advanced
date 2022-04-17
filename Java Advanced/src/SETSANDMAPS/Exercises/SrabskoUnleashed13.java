package SETSANDMAPS.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SrabskoUnleashed13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, LinkedHashMap<String, Integer>> concert = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            //Lepa Brena @Sunny Beach 25 3500
            //Dragana @Sunny Beach 23 3500
            if (!input.contains("@") || !(input.charAt(input.indexOf("@") - 1) == ' ')) {
                input = scanner.nextLine();
                continue;
            }

            String singer = input.substring(0, input.indexOf("@") - 1);
            int firstIndexDigit = 0;
            for (int i = input.indexOf("@"); i < input.length(); i++) {
                char currentSymbol = input.charAt(i);
                if (Character.isDigit(currentSymbol) && input.charAt(i - 1) == ' ') {
                    firstIndexDigit = i;
                    break;
                }
            }
            if (firstIndexDigit == 0) {
                input = scanner.nextLine();
                continue;
            }

            String place = input.substring(input.indexOf("@") + 1, firstIndexDigit - 1);
            String numbers = input.substring(firstIndexDigit);
            String[] numberArr = numbers.split("\\s+");

            if (numberArr.length != 2) {
                input = scanner.nextLine();
                continue;
            }
            int ticketsPrice = Integer.parseInt(numberArr[0]);
            int ticketsCount = Integer.parseInt(numberArr[1]);
            // concert.putIfAbsent(place, new LinkedHashMap<>());
            //  int totalPrice = ticketsPrice * ticketsCount;
            //concert.get(place).putIfAbsent(singer, 0);

            if (!concert.containsKey(place)) {
                LinkedHashMap<String, Integer> singers = new LinkedHashMap<>();
                singers.put(singer, ticketsPrice * ticketsCount);
                concert.put(place, singers);
            } else {
                LinkedHashMap<String, Integer> currentSinger = concert.get(place);
                if (currentSinger.containsKey(singer)) {
                    currentSinger.put(singer, currentSinger.get(singer) + ticketsCount * ticketsPrice);
                } else {
                    currentSinger.put(singer, ticketsCount * ticketsPrice);
                }
                concert.put(place, currentSinger);
            }
            input = scanner.nextLine();
        }

        for (String s : concert.keySet()) {
            System.out.println(s);
            LinkedHashMap<String, Integer> singers = concert.get(s);
            singers.entrySet().stream().sorted((singer1, singer2) -> singer2.getValue().compareTo(singer1.getValue())).
                    forEach(singer -> System.out.println("#  " + singer.getKey() + " -> " + singer.getValue()));
        }
       /* concert.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            LinkedHashMap<String, Integer> singers = entry.getValue();
            singers.entrySet().stream().sorted((singer1, singer2)-> singer2.getValue().compareTo(singer1.getValue())).
                    forEach(singer -> System.out.println("#  " + singer.getKey() + " -> " + singer.getValue()));
        });*/
    }
}
