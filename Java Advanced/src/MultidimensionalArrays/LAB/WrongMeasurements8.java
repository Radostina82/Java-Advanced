package MultidimensionalArrays.LAB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMeasurements8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = readMatrix(rows, 0, scanner, "\\s+");
        int[] coordinate = readArr(scanner, "\\s+");
        int wrongValue = matrix[coordinate[0]][coordinate[1]];

        List<int[]> updatedValues = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
            if (matrix[row][col] == wrongValue){
                updatedValues.add(new int[] {row, col, getClosestItemsSum(row, col, matrix, wrongValue)});
            }
            }
        }
        for (int[] updatedValue  : updatedValues) {
            matrix[updatedValue[0]][updatedValue[1]] = updatedValue[2];
        }
        printMatrix(matrix);

    }
    public static int getClosestItemsSum(int row, int col, int [][]matrix, int wrongValue){
        int sum = 0;

        if (isInBounds(row, col + 1, matrix) && matrix[row][col + 1] != wrongValue) {
            sum += matrix[row][col + 1];
        }
        if (isInBounds(row, col - 1, matrix) && matrix[row][col - 1] != wrongValue) {
            sum += matrix[row][col - 1];
        }
        if (isInBounds(row + 1, col, matrix) && matrix[row + 1][col] != wrongValue) {
            sum += matrix[row + 1][col];
        }
        if (isInBounds(row - 1, col, matrix) && matrix[row - 1][col] != wrongValue) {
            sum += matrix[row - 1][col];
        }

        return sum;
    }

    public static boolean isInBounds(int row, int col, int[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }
    public static void printMatrix(int [][]matrix){
        for (int[] arr : matrix) {
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
    public static int[][] readMatrix(int row,int col, Scanner scanner, String pattern) {
        int [][] matrix = new int[row][col];

        for (int rows = 0; rows < row; rows++) {
            matrix[rows] = readArr(scanner, pattern);
        }
        return matrix;
    }
    public  static int[] readArr(Scanner scanner, String pattern){
        return Arrays.stream(scanner.nextLine().split(pattern)).mapToInt(Integer::parseInt).toArray();
    }
}
