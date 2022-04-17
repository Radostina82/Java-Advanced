package MultidimensionalArrays.LAB;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rowsAndCols = readArr(scanner, ", ");
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];
        int[][] matrix = readMatrix(rows, cols, scanner, ", ");
        int [][]maxSubMatrix=getMaxSumSubMatrix2By2(matrix);
        printMatrix(maxSubMatrix);
        System.out.println(getSum(matrix));
    }
    public static int getSum(int [][]matrix){
        int sum = 0;
        matrix = getMaxSumSubMatrix2By2(matrix);
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                sum += matrix[row][col];
            }
        }
        return sum;
    }
    public static void printMatrix(int [][]matrix){
        for (int[] arr : matrix) {
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
    public static int[][] getMaxSumSubMatrix2By2(int [][] matrix){

        int maxSum = 0;
        int bestRow = 0;
        int bestCol=0;

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row + 1][col] + matrix[row + 1][col + 1];
                if (sum > maxSum) {
                    maxSum = sum;
                    bestRow = row;
                    bestCol = col;
                }
            }
        }
        return new int[][]{
                {matrix[bestRow][bestCol], matrix[bestRow][bestCol+1]},
                {matrix[bestRow+1][bestCol], matrix[bestRow+1][bestCol+1]}
        };
    }

    public static int[][] readMatrix(int rows, int cols, Scanner scanner, String pattern) {
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = readArr(scanner, pattern);
        }
        return matrix;
    }

    public static int[] readArr(Scanner scanner, String pattern) {
        return Arrays.stream(scanner.nextLine().split(pattern)).mapToInt(Integer::parseInt).toArray();
    }
}
