package MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rowAndCol = readArr(scanner, "\\s+");
        int rows = rowAndCol[0];
        int cols = rowAndCol[1];
        int[][] matrix = readMatrix(rows, cols, scanner, "\\s+");
        int[][] bestMatrix3x3 = getBestMatrix3x3(matrix);
        int bestSum = getBestSum(bestMatrix3x3);

        System.out.printf("Sum = %d%n", bestSum);
        printBestMatrix(bestMatrix3x3);

    }

    public static void printBestMatrix(int [][]matrix){
        for (int[] arr : matrix) {
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
    public static int getBestSum(int[][]matrix){
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                sum += matrix[row][col];
            }
        }
        return sum;
    }
    public static int[][] getBestMatrix3x3(int[][] matrix) {
        int sum = 0;
        int bestRow = 0;
        int bestCol = 0;
        int bestSum = 0;
        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                sum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2] + matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2] +
                        matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];
                if (sum > bestSum) {
                    bestSum = sum;
                    bestRow = row;
                    bestCol = col;
                }
            }
        }
        return new int [][]{
            {matrix[bestRow][bestCol], matrix[bestRow][bestCol+1], matrix[bestRow][bestCol+2]},
            {matrix[bestRow+1][bestCol], matrix[bestRow+1][bestCol+1], matrix[bestRow+1][bestCol+2]},
            {matrix[bestRow+2][bestCol], matrix[bestRow+2][bestCol+1], matrix[bestRow+2][bestCol+2]}
        };
    }

    public static int[][] readMatrix(int rows, int cols, Scanner scanner, String pattern) {
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = readArr(scanner, pattern);
        }
        return matrix;
    }

    public static int[] readArr(Scanner scanner, String pattern) {
        return Arrays.stream(scanner.nextLine().split(pattern)).mapToInt(Integer::parseInt).toArray();
    }
}
