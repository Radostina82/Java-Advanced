package SETSANDMAPS.Exercises;

import java.util.*;

public class HandsOfCards8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashSet<String>> peopleCard = getPeopleCard(scanner);

        for (Map.Entry<String, LinkedHashSet<String>> entry : peopleCard.entrySet()) {
            int point = getCardPoint(entry.getValue());
            System.out.println(entry.getKey() + ": " + point);
        }

    }
    public static int getCardPoint(LinkedHashSet<String> set){
        int sum = 0;
        Map<Character, Integer> pointsValue = getPointsValue();
        for (String card : set) {
            int points = 0;
            if (card.contains("10")){
                char strength = card.charAt(2);
                points = 10 * pointsValue.get(strength);
            }else {
                char number = card.charAt(0);
                char strength = card.charAt(1);
                points = pointsValue.get(strength) * pointsValue.get(number);
            }
            sum+=points;
        }
        return sum;
    }
    public static Map<Character, Integer> getPointsValue(){
        LinkedHashMap<Character, Integer> pointsValue = new LinkedHashMap<>();
        pointsValue.put('1', 1);
        pointsValue.put('2', 2);
        pointsValue.put('3', 3);
        pointsValue.put('4', 4);
        pointsValue.put('5', 5);
        pointsValue.put('6', 6);
        pointsValue.put('7', 7);
        pointsValue.put('8', 8);
        pointsValue.put('9', 9);
        pointsValue.put('J', 11);
        pointsValue.put('Q', 12);
        pointsValue.put('K', 13);
        pointsValue.put('A', 14);
        pointsValue.put('S', 4);
        pointsValue.put('H', 3);
        pointsValue.put('D', 2);
        pointsValue.put('C', 1);
        return pointsValue;
    }
    public static LinkedHashMap<String, LinkedHashSet<String >> getPeopleCard(Scanner scanner){
        String input = scanner.nextLine();
        LinkedHashMap<String , LinkedHashSet<String>> peopleCard = new LinkedHashMap<>();
        while (!input.equals("JOKER")){
            String name = getSplitedInput(input, ": ")[0];
            String[] cards = getSplitedInput(input, ": ")[1].split(", ");
            LinkedHashSet<String> card = new LinkedHashSet<>(); //да няма повтарящи се карти
            Collections.addAll(card, cards);

            if (!peopleCard.containsKey(name)){
                peopleCard.put(name, card);
            }else {
                LinkedHashSet<String> currentCard = peopleCard.get(name);
                currentCard.addAll(card);
                peopleCard.put(name, currentCard);
            }
            input = scanner.nextLine();
        }
        return peopleCard;
    }
    public static String[] getSplitedInput(String input, String pattern){
        return input.split(pattern);
    }
}
