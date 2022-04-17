package MultidimensionalArrays.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ParkingSystem9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int row = Integer.parseInt(input.split("\\s+")[0]);
        int col = Integer.parseInt(input.split("\\s+")[1]);
        //int[][] matrix = new int[row][col];
        List<List<Integer>> matrix = new ArrayList<>();
        input = scanner.nextLine();
        for (int i = 0; i < row; i++) {
            List<Integer> newMatrix = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                newMatrix.add(j,0);
            }
            matrix.add(i, newMatrix);
        }
        while (!input.equals("stop")) {
            int[] tokens = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int entryRow = tokens[0];
            int rowParking = tokens[1];
            int colParking = tokens[2];
            int index = 0;

            int distance = Math.abs(entryRow - rowParking) + 1;
            boolean isParking = false;
            //int tempColLeft = 0 >= col - 1 ? 1 : col - 1;
            //int tempColRight = col + 1 >= matrix[0].length - 1 ? col : col + 1;
            if (matrix.get(rowParking).get(colParking) == 0) {
                distance += colParking;
                matrix.get(rowParking).set(colParking, 1);
                System.out.println(distance);
                isParking = true;
            } else {
                for (int i = colParking - 1; i > 0; i--) {//на ляво

                    if (matrix.get(rowParking).get(i) == 0) {
                        matrix.get(rowParking).set(i, 1);
                        isParking = true;
                        distance += i;
                        System.out.println(distance);
                        break;
                    }
                }
                if (!isParking) {
                    for (int i = colParking + 1; i < matrix.get(rowParking).size(); i++) {
                        if (matrix.get(rowParking).get(i) == 0) {
                            matrix.get(rowParking).set(i, 1);
                            distance += i;
                            isParking = true;
                            System.out.println(distance);
                            break;
                        }
                    }

                }

            }
            if (!isParking) {
                System.out.println("Row " + rowParking + " full");
            }
            input = scanner.nextLine();
        }
    }
}
