package Exam.August2018;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Mission3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        HashMap<String, Integer> missionComplete = new HashMap<>();
        HashMap<String, Integer> missionFailed = new HashMap<>();
        while (!input.equals("Decrypt")) {
            //MISSION
            StringBuilder builder = new StringBuilder();
            StringBuilder nameMission = new StringBuilder();
            int rating = 0;
            for (char c : input.toCharArray()) {
                if (c == 'M' || c == 'I' || c == 'S' || c == 'O' || c == 'N') {
                    builder.append(c);
                } else if (Character.isLowerCase(c)) {
                    nameMission.append(c);
                } else if (Character.isDigit(c)) {
                    rating += Integer.parseInt(String.valueOf(c));
                }
            }
            if (builder.toString().equals("MISSION")){
                if (input.contains("C")) {
                    missionComplete.putIfAbsent(nameMission.toString(), rating);

                }else if (input.contains("X")){
                    missionFailed.put(nameMission.toString(), rating);
                   // System.out.printf("Failed mission %s with rating: %d%n", nameMission.toString(), rating);
                }
            }
            input = scanner.nextLine();
        }
       // Map.Entry<String, Integer> maxRatingC = missionComplete.entrySet().stream().max(Map.Entry.comparingByValue()).get();
        //Map.Entry<String, Integer> maxRatingF = missionFailed.entrySet().stream().max(Map.Entry.comparingByValue()).get();
        //System.out.printf("Completed mission %s with rating: %d%n", nameMission.toString(), rating);

        missionComplete.entrySet().stream().max(Map.Entry.comparingByValue()).ifPresent(e-> {
            System.out.printf("Completed mission %s with rating: %d%n",e.getKey(), e.getValue());
        });
        missionFailed.entrySet().stream().max(Map.Entry.comparingByValue()).ifPresent(e->{
            System.out.printf("Failed Mission %s with rating: %d%n", e.getKey(), e.getValue());
        });
    }
}
