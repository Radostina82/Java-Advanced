package Exam.June2020;

import java.util.*;
import java.util.stream.Collectors;

public class Bombs1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //опаика
        ArrayDeque<Integer> bombEffect = Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        //стек
        ArrayDeque<Integer> bombCasings = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(bombCasings::push);
        TreeMap<String, Integer> bombs = new TreeMap<>();
        bombs.put("Datura Bombs", 0);
        bombs.put("Smoke Decoy Bombs", 0);
        bombs.put("Cherry Bombs", 0);
        boolean isFull = false;
        while (!bombCasings.isEmpty() && !bombEffect.isEmpty()) {
            int effect = bombEffect.peek();
            int casing = bombCasings.pop();
            int sum = effect + casing;
            //•	Datura Bombs: 40
            //•	Cherry Bombs: 60
            //•	Smoke Decoy Bombs: 120
            while (casing >= 0) {
                if (sum == 40) {
                bombs.put("Datura Bombs", bombs.get("Datura Bombs")+1);
                bombEffect.poll();
                break;
                } else if (sum == 60) {
                    bombs.put("Cherry Bombs", bombs.get("Cherry Bombs")+1);
                    bombEffect.poll();
                    break;
                } else if (sum == 120) {
                    bombs.put("Smoke Decoy Bombs", bombs.get("Smoke Decoy Bombs")+1);
                    bombEffect.poll();
                    break;
                } else {
                    casing -= 5;
                    sum -=5;
                }
            }
            if (bombs.get("Datura Bombs")>=3 && bombs.get("Cherry Bombs")>=3 && bombs.get("Smoke Decoy Bombs")>=3){
                isFull = true;
                break;
            }
        }
        if (isFull){
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        }else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        if (bombEffect.isEmpty()){
            System.out.println("Bomb Effects: empty");
        }else {
            System.out.print("Bomb Effects: " + bombEffect.toString().replaceAll("[\\[\\]]", ""));
            System.out.println();
        }
        if (bombCasings.isEmpty()){
            System.out.println("Bomb Casings: empty");
        }else {
            System.out.print("Bomb Casings: " + bombCasings.toString().replaceAll("[\\[\\]]", ""));
            System.out.println();
        }
        bombs.entrySet().forEach(b->{
            if (b.getKey().equals("Cherry Bombs")) {
                System.out.println("Cherry Bombs: " + b.getValue());
            }else if (b.getKey().equals("Datura Bombs")) {
                System.out.println("Datura Bombs: " + b.getValue());
            }else {
                System.out.println("Smoke Decoy Bombs: " + b.getValue());
            }
        });
    }
}
