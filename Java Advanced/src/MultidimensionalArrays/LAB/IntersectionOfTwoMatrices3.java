package MultidimensionalArrays.LAB;

import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = Integer.parseInt(scanner.nextLine());
        int col = Integer.parseInt(scanner.nextLine());
        char [][] matrix1 = readMatrix(row, col, scanner);
        char[][] matrix2 = readMatrix(row, col, scanner);

        char[][] output = getMatricesIntersection(matrix1, matrix2, row, col);

        printMatrix(output);
    }
    public static char[][] getMatricesIntersection(char[][] first, char [][] second, int rows, int cols){
        char [][]output = new char[rows][cols];
        for (int row = 0; row < first.length; row++) {
            char []arr1 = first[row];
            char [] arr2 = second[row];
            for (int col = 0; col < first[row].length; col++) {
                if (arr1[col] == arr2[col]){
                    output[row][col]=arr1[col];
                }else {
                    output[row][col] = '*';
                }
            }
        }
        return output;
    }
    public static char[][] readMatrix(int rows, int cols, Scanner scanner){
        char [][] matrix = new char[rows][cols];
        for (int row = 0; row <rows ; row++) {
           String []token = scanner.nextLine().split("\\s+");
            for (int col = 0; col < token.length; col++) {
                matrix[row][col] = token[col].charAt(0);
            }
        }
        return matrix;
    }

    public static void printMatrix(char[][] matrix) {
       /* for (int row = 0; row <= matrix.length-1 ; row++) {
            //int[] arr = matrix[row];
            for (int col = 0; col <= matrix[row].length-1 ; col++) {
                System.out.println(matrix[row][col] + " ");
            }
            System.out.println();
        }*/
//и двата записа правят едно и също
        for (char[] arr : matrix) {
            for (char element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
