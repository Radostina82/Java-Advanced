package StacksAndQueues.Exercises;

import java.util.*;

public class Robotics5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputRobot = scanner.nextLine().split(";");
        int[] time = Arrays.stream(scanner.nextLine().split(":")).mapToInt(Integer::parseInt).toArray();
        long startTimeInSecond = getTimeInSecond(time);
        LinkedHashMap<String, Integer> robots = splitInputRobotIntoLinkedHashMap(inputRobot);
        int[] processTime = new int[robots.size()];
        String product = scanner.nextLine();
        ArrayDeque<String> products = new ArrayDeque<>();

        while (!product.equals("End")) {
            products.offer(product);
            product = scanner.nextLine();
        }

        while (!products.isEmpty()) {
            String currentProduct = products.poll();
            //увеличавам текущото време
            startTimeInSecond++;
            boolean isAssigned = false;
            //намаляваме времето с една секунда
            decreaseProcessTime(processTime);
            //обхожда работното време
            for (int i = 0; i <= processTime.length - 1; i++) {
                if (processTime[i] == 0) {
                    //робота е свободен
                    int count = 0;// брояча ми брои кой по ред робот е в мапа
                    for (Map.Entry<String, Integer> robot : robots.entrySet()) {
                        if (count == i) {
                            processTime[i] = robot.getValue();
                            System.out.println(robot.getKey() + " - " + currentProduct + " [" + jobTime(startTimeInSecond) + "]");
                            isAssigned = true;
                            break;
                        }
                        count++;
                    }

                    break;
                }
            }
            if (!isAssigned) {
                products.offer(currentProduct);
            }
        }

    }

    public static String jobTime(long startTimeInSecond) {
        long hours = (startTimeInSecond / 3600) % 24;
        long minutes = (startTimeInSecond % 3600 )/ 60;
        long seconds = startTimeInSecond % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public static void decreaseProcessTime(int[] processTime) {
        for (int robot = 0; robot <= processTime.length - 1; robot++) {
            if (processTime[robot] > 0) {
                --processTime[robot];//намалява се времето, в което работи
            }
        }
    }

    public static long getTimeInSecond(int[] time) {
        int hoursInSecond = time[0] * 3600;
        int minInSecond = time[1] * 60;
        int second = time[2];
        return hoursInSecond + minInSecond + second;
    }

    public static LinkedHashMap<String, Integer> splitInputRobotIntoLinkedHashMap(String[] robot) {
        LinkedHashMap<String, Integer> robots = new LinkedHashMap<>();
        for (int i = 0; i <= robot.length - 1; i++) {
            String nameRobot = robot[i].split("-")[0];
            int processingTime = Integer.parseInt(robot[i].split("-")[1]);

            robots.put(nameRobot, processingTime);
        }
        return robots;
    }
}
