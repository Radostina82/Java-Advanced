package MultidimensionalArrays.LAB;

import java.sql.DataTruncation;
import java.util.Scanner;

public class FindTheRealQueen7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = 8;
        char[][] matrix = readMatrix(scanner, size, "\\s+");

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char currentElement = matrix[row][col];

                if (currentElement == 'q') {
                    if (chek(matrix, row, col)) {
                        System.out.print(row + " " + col);
                    }
                }
            }
        }

    }

    public static boolean chek(char[][] matrix, int row, int col) {
        //проверявам от моя елемент на ляво по реда
        for (int i = col + 1; i < matrix[row].length; i++) {
            char charToChek = matrix[row][i];
            if (charToChek == 'q') {
                return false;
            }
        }
        //проверявам от моя елемент надолу по колоната
        for (int i = row + 1; i < matrix.length; i++) {
            char charToChek = matrix[i][col];
            if (charToChek == 'q') {
                return false;
            }
        }
        //проверявам от моя елемент нагоре по колоната
        for (int i = row - 1; i >= 0; i--) {
            char charToChek = matrix[i][col];
            if (charToChek == 'q') {
                return false;
            }
        }
        //от моя елемент по единия диагонал на ляво
        int element = col + 1;
        for (int i = row + 1; i < matrix.length && element<matrix[row].length; i++) {

            char charToChek = matrix[i][element];
            if (charToChek == 'q') {
                return false;
            }
            element++;
        }
        //по същия диагонал но противоположно
        int element1 = col - 1;
        for (int i = row - 1; i >= 0 && element1 >=0; i--) {

            char charToChek = matrix[i][element1];
            if (charToChek == 'q') {
                return false;

            }
            element1--;
        }
        //от моя елемент по другия диагонал
        int element2 = col - 1;
        for (int i = row + 1; i < matrix.length && element2>=0; i++) {

            char charToChek = matrix[i][element2];
            if (charToChek == 'q') {
                return false;
            }
            element2--;
        }
        int element3 = col + 1;
        for (int i = row - 1; i >= 0 && element3<matrix[row].length; i--) {

            char charToChek = matrix[i][element3];
            if (charToChek == 'q') {
                return false;
            }
            element3++;
        }
        return true;
    }

    public static char[][] readMatrix(Scanner scanner, int size, String pattern) {
        char[][] matrix = new char[size][size];
        for (int row = 0; row < size; row++) {
            matrix[row] = readArr(scanner, pattern, size);
        }
        return matrix;
    }

    public static char[] readArr(Scanner scanner, String pattern, int size) {
        char[] arr = new char[size];
        String[] token = scanner.nextLine().split(pattern);
        for (int i = 0; i < token.length; i++) {
            arr[i] = token[i].charAt(0);
        }
        return arr;
    }
}
