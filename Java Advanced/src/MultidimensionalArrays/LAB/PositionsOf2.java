package MultidimensionalArrays.LAB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PositionsOf2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = readArr(scanner);
        int rows = arr[0];
        int cols = arr[1];
        int [][] matrix = readMatrix(rows, cols, scanner);
        int number = Integer.parseInt(scanner.nextLine());
        List<int []> output = findNumber(matrix, number);

        if (output.isEmpty()){
            System.out.println("not found");
        }else {
            for (int[] ints : output) {
                System.out.println(ints[0] + " " + ints[1]);
            }
        }

    }
    public static List<int[]> findNumber(int [][] arr, int number){
       List<int[]> output = new ArrayList<>();

        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if (arr[row][col] == number){

                output.add(new int[]{row, col});
                }
            }
        }
       return output;
    }

    public static int [][] readMatrix(int rows, int cols, Scanner scanner){
        int [][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = readArr(scanner);
        }
        return matrix;
    }
    public static int [] readArr(Scanner scanner){
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
