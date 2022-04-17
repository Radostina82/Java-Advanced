package MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] rowAndCol = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = rowAndCol[0];
        int cols = rowAndCol[1];
        String [][] matrix = getMatrixOfPalindrome(rows, cols);
        printMatrix(matrix);
    }

    public static void printMatrix(String[][]matrix){
        for (String[] strings : matrix) {
            for (String element : strings) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
    public static String[][] getMatrixOfPalindrome(int rows, int cols){
        String [][] matrix = new String[rows][cols];
        char element = 'a';
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = "" + element + (char)(element+col) + element;

            }
            element = (char)(element+1);
        }

        return matrix;
    }
}
