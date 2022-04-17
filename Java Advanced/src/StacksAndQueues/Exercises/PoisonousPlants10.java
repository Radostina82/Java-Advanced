package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class PoisonousPlants10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int [] plants = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int [] days = new int[n];
        ArrayDeque<Integer> prevPlant = new ArrayDeque<>();
        prevPlant.push(0);

        for (int i = 1; i <=plants.length-1 ; i++) {
            int day = 0;
            while (!prevPlant.isEmpty() && plants[prevPlant.peek()]>=plants[i]){
                day = Math.max(day, days[prevPlant.pop()]);
            }
            if (!prevPlant.isEmpty()){
                days[i] = day + 1;
            }
            prevPlant.push(i);
        }
        System.out.println(Arrays.stream(days).max().getAsInt());
    }
}
