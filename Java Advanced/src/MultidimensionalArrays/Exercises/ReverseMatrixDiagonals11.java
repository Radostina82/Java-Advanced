package MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rowAndCol = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = readReverseMatrixDiagonals(rowAndCol, scanner, "\\s+");
        readReverseMatrixDiagonals(matrix, rowAndCol);
    }

    private static void readReverseMatrixDiagonals(int[][] matrix, int[] rowAndCol) {
        int rows = rowAndCol[0] - 1;
        int cols = rowAndCol[1] - 1;
        while (rows >= 0) {
            int r = rows;
            int c = cols;

            while (c < rowAndCol[1] && r >= 0) {
                System.out.print(matrix[r--][c++] + " ");
            }
            System.out.println();
            cols--;
            if (cols==-1){
                cols =0;
                rows--;
            }
        }
    }

    private static int[][] readReverseMatrixDiagonals(int[] rowAndCol, Scanner scanner, String pattern) {
        int[][] matrix = new int[rowAndCol[0]][rowAndCol[1]];
        for (int i = 0; i < rowAndCol[0]; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(pattern)).mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
