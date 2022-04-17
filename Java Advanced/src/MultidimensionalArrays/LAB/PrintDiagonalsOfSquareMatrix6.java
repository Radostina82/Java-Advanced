package MultidimensionalArrays.LAB;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int [][]matrix = readMatrix(scanner, size,0, "\\s+");
        int[][] matrixDiagonal = new int[2][size];
        int first = 0;
        int second= size-1;

        for (int col = 0; col < matrix.length; col++) {
          matrixDiagonal[0][col]=matrix[first][col];
          matrixDiagonal[1][col] = matrix[second][col];
          first++;
          second--;
        }

        for (int[] arr : matrixDiagonal) {
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static int[][] readMatrix(Scanner scanner, int rows,int col, String pattern){
        int [][]matrix = new int[rows][col];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(pattern)).mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
