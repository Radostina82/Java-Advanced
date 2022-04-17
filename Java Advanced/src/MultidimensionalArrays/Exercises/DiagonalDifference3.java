package MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int [][] matrix = readMatrix(size, scanner, "\\s+");
        int primaryDiagonal = getSumPrimaryDiagonal(matrix);
        int secondaryDiagonal = getSumSecondryDiagonal(matrix);

        System.out.println(Math.abs(primaryDiagonal-secondaryDiagonal));
    }
    public static int getSumPrimaryDiagonal(int [][] matrix){
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row==col){
                    sum += matrix[row][col];
                }
            }
        }
        return sum;
    }
    public static int getSumSecondryDiagonal(int[][]matrix){
        int sum = 0;
        for (int row = 0; row <matrix.length ; row++) {
            for (int col = matrix[row].length-1; col >=0 ; col--) {
                if (col == matrix[row].length -1 - row){
                    sum += matrix[row][col];
                }
            }
        }
        return sum;
    }
    public static int[][] readMatrix(int size, Scanner scanner, String pattern){
        int [][]matrix = new int[size][size];
        for (int row = 0; row <size ; row++) {
            matrix[row] = readArr(scanner, pattern);
        }
        return matrix;
    }
    public static int[] readArr(Scanner scanner, String pattern){
        return Arrays.stream(scanner.nextLine().split(pattern)).mapToInt(Integer::parseInt).toArray();
    }
}
