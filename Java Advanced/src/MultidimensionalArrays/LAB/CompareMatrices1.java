package MultidimensionalArrays.LAB;

import java.util.Arrays;
import java.util.Scanner;
import java.util.SplittableRandom;

public class CompareMatrices1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = readArray(scanner.nextLine());
        int rows = input[0];
        int cols = input[1];
        int[][] matrix1 = readMatrix(rows, cols, scanner);

        input = readArray(scanner.nextLine());
        rows = input[0];
        cols = input[1];
        int[][] matrix2 = readMatrix(rows, cols, scanner);


       if (isEqual(matrix1, matrix2)){
            System.out.println("equal");
        }else {
            System.out.println("not equal");
        }
    }

    public static boolean isEqual(int[][] first, int[][] second) {
        if (first.length != second.length) {
            return false;
        }

        for (int row = 0; row < first.length; row++) {
            int[] firstArray = first[row];
            int[] secondArray = second[row];

            if (firstArray.length != secondArray.length) {
                return false;
            }
            for (int col = 0; col < firstArray.length; col++) {
                if (firstArray[col]!=secondArray[col]){
                    return false;
                }
            }
        }

        return true;
    }

    public static int[][] readMatrix(int rows, int cols, Scanner scanner) {
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = readArray(scanner.nextLine());
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
       /* for (int row = 0; row <= matrix.length-1 ; row++) {
            //int[] arr = matrix[row];
            for (int col = 0; col <= matrix[row].length-1 ; col++) {
                System.out.println(matrix[row][col] + " ");
            }
            System.out.println();
        }*/
//и двата записа правят едно и също
        for (int[] arr : matrix) {
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static int[] readArray(String input) {
        return Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
