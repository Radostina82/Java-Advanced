package MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class TheMatrix12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rowAndCol = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        char[][] matrix = readMatrix(rowAndCol, scanner);
        char color = scanner.nextLine().charAt(0);
        rowAndCol = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int startRow = rowAndCol[0];
        int startCol = rowAndCol[1];
        char oldColor = matrix[startRow][startCol];
        colorPlain(matrix, startRow, startCol, color, oldColor);
        printMatrix(matrix);
    }

    public static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char element : chars) {
                System.out.print(element);
            }
            System.out.println();
        }
    }

    private static void colorPlain(char[][] matrix, int row, int col, char color, char oldColor) {

        if (isOutOfBounds(matrix, row, col)) {
            return;
        }
        if (matrix[row][col] != oldColor) {
            return;
        }
        matrix[row][col] = color;
        colorPlain(matrix, row - 1, col, color, oldColor);
        colorPlain(matrix, row + 1, col, color, oldColor);
        colorPlain(matrix, row, col + 1, color, oldColor);
        colorPlain(matrix, row, col-1, color, oldColor);
    }

    public static boolean isOutOfBounds(char[][] matrix, int row, int col) {
        return row >= matrix.length || row < 0 || col < 0 || col >= matrix[row].length;
    }

    public static char[][] readMatrix(int[] rowAndCol, Scanner scanner) {
        char[][] matrix = new char[rowAndCol[0]][rowAndCol[1]];
        for (int row = 0; row < rowAndCol[0]; row++) {
            matrix[row] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        }
        return matrix;
    }
}
