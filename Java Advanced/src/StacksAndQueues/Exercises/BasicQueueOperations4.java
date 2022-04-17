package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int remove = scanner.nextInt();
        int x = scanner.nextInt();
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            int element = scanner.nextInt();
            queue.offer(element);
        }

        for (int i = 1; i <= remove ; i++) {
            queue.poll();
        }
        if (!queue.isEmpty()){
            if (queue.contains(x)){
                System.out.println("true");
            }else {
                //System.out.println(Collections.min(queue));
                System.out.println(getMinElement(queue));
            }
        }else {
            System.out.println("0");
        }
    }
    public static int getMinElement(ArrayDeque<Integer> queue){
        int minElement = Integer.MAX_VALUE;
        while (!queue.isEmpty()){
            int element = queue.poll();
            if (element<minElement){
                minElement= element;
            }

        }
        return minElement;
    }
}
