package MultidimensionalArrays.LAB;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SumMatrixElements4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rowsAndCols = readArr(scanner, ", ");
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];
        int [][]matrix = readMatrix(rows, cols, scanner, ", ");

        printResult(rows, cols, matrix);
    }
    public static void printResult(int row, int col, int [][]matrix){

        System.out.println(row);
        System.out.println(col);
        System.out.println(getSumMatrix(matrix));
    }
    public static int getSumMatrix(int [][]matrix){
        int sum = 0;
        for (int[] arr : matrix) {
            for (int element : arr) {
                sum += element;
            }
        }
        return sum;
    }
    //друг вариант за сумиране със стрийм

    public static int getSumWithStream(int[][] matrix){
        return Arrays.stream(matrix).flatMapToInt(Arrays::stream).sum();
    }
    public static int [][] readMatrix(int row, int col, Scanner scanner, String pattern){
        int [][] matrix = new int[row][col];
        for (int rows = 0; rows < matrix.length; rows++) {
            matrix[rows] = readArr(scanner, pattern);
        }

        return matrix;
    }
    public static int[] readArr(Scanner scanner, String pattern){
        return Arrays.stream(scanner.nextLine().split(pattern)).mapToInt(Integer::parseInt).toArray();
    }
}
