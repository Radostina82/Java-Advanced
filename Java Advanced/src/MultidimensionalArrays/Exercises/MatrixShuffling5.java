package MultidimensionalArrays.Exercises;

import java.util.Scanner;

public class MatrixShuffling5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] rowAndCol = readArr(scanner, "\\s+");
        int rows = Integer.parseInt(rowAndCol[0]);
        int cols = Integer.parseInt(rowAndCol[1]);
        String[][] matrix = readMatrix(scanner, rows, cols, "\\s+");

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] token = input.split("\\s+");
            String command = token[0];

            if (isValid(token, matrix)) {
                matrix = getNewMatrix(matrix, token, rows, cols);
                printMatrix(matrix);
            } else {
                System.out.println("Invalid input!");
            }
            input = scanner.nextLine();
        }
    }

    public static String[][] getNewMatrix(String[][] matrix, String[] token, int rows, int cols) {
        int row1 = Integer.parseInt(token[1]);
        int col1 = Integer.parseInt(token[2]);
        int row2 = Integer.parseInt(token[3]);
        int col2 = Integer.parseInt(token[4]);
        String element1 = matrix[row1][col1];
        String element2 = matrix[row2][col2];
        matrix[row1][col1] = element2;
        matrix[row2][col2] = element1;

        return matrix;
    }

    public static boolean isValid(String[] token, String[][] matrix) {
        String command = token[0];
        if (!command.equals("swap")) {
            return false;
        }
        if (token.length != 5) {
            return false;
        }

        int row1 = Integer.parseInt(token[1]);
        int col1 = Integer.parseInt(token[2]);
        int row2 = Integer.parseInt(token[3]);
        int col2 = Integer.parseInt(token[4]);

        if (row1 >= matrix.length || row1 < 0 || col1 >= matrix[row1].length || col1 < 0 || row2 >= matrix.length || row2 < 0 || col2 >= matrix[row2].length || col2 < 0) {
            return false;
        }
        return true;

    }

    public static void printMatrix(String[][] matrix) {
        for (String[] arr : matrix) {
            for (String element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static String[][] readMatrix(Scanner scanner, int rows, int cols, String pattern) {
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = readArr(scanner, "\\s+");
        }

        return matrix;
    }

    public static String[] readArr(Scanner scanner, String pattern) {
        return scanner.nextLine().split(pattern);
    }
}
