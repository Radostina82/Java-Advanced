package Exam.Fubruary2020;

import java.util.Arrays;
import java.util.Scanner;

public class ReVolt2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rowAndCol = Integer.parseInt(scanner.nextLine());
        int countCommand = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[rowAndCol][rowAndCol];
        int[] coordinates = new int[2];
        boolean playerWon = false;

        for (int i = 0; i < rowAndCol; i++) {
            String line = scanner.nextLine();
            matrix[i] = line.toCharArray();
            if (line.contains("f")) {
                coordinates[0] = i;
                coordinates[1] = line.indexOf("f");
            }
        }
        for (int i = 0; i < countCommand; i++) {
            String command = scanner.nextLine();

            if (command.equals("up")) {

                playerWon = movePlayer(matrix, coordinates, -1, 0);

            } else if (command.equals("down")) {
                playerWon = movePlayer(matrix, coordinates, +1, 0);
            } else if (command.equals("left")) {
                playerWon = movePlayer(matrix, coordinates, 0, -1);
            } else if (command.equals("right")) {
                playerWon = movePlayer(matrix, coordinates, 0, +1);
            }
            if (playerWon) {
                break;
            }
        }
        if (playerWon) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }
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

    public static boolean movePlayer(char[][] matrix, int[] coordinate, int rowModificate, int colModificate) {
        int row = coordinate[0];
        int col = coordinate[1];
        int newRow = indexInBounds(row + rowModificate, matrix.length - 1);
        int newCol = indexInBounds(col + colModificate, matrix.length - 1);
        boolean isWon = false;
        if (matrix[newRow][newCol] == 'B') {
           int currentRow = indexInBounds(newRow + rowModificate, matrix.length-1);
           int currentCol = indexInBounds(newCol+colModificate, matrix.length-1);
           newRow = currentRow;
           newCol = currentCol;

        } else if (matrix[newRow][newCol] == 'T') {
            newRow = row;
            newCol = col;
        } else if (matrix[newRow][newCol] == 'F') {
            isWon = true;
        }
        matrix[row][col] = '-';
        matrix[newRow][newCol] = 'f';
        coordinate[0] = newRow;
        coordinate[1] = newCol;

        return isWon;
    }

    public static int indexInBounds(int index, int bounds) {
        if (index < 0) {
            index = bounds;
        } else if (index > bounds) {
            index = 0;
        }
        return index;
    }
}
