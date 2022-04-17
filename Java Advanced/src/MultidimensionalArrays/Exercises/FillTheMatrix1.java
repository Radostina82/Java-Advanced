package MultidimensionalArrays.Exercises;

import java.util.Scanner;

public class FillTheMatrix1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String []input = scanner.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        String command= input[1];
        int [][]matrix = new int[size][size];

        if (command.equals("A")){
          matrix =  getPatternA(size);
        }else if (command.equals("B")){
           matrix = getPatternB(size);
        }
printMatrix(matrix);
    }
    public static int[][] getPatternB(int size){
        int[][]matrix = new int[size][size];
        int element = 1;
        for (int col = 0; col < size; col++) {
            if (col%2==0){
                for (int row = 0; row < size; row++) {
                    matrix[row][col] = element++;
                }
            }else {
                for (int row = size-1; row >=0 ; row--) {
                    matrix[row][col] = element++;
                }
            }
        }

        return matrix;
    }
    public static void printMatrix(int [][]matrix){
        for (int[] arr : matrix) {
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
    public static int[][] getPatternA(int size){
        int [][]matrix = new int[size][size];
        int element = 1;
        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                matrix[row][col] =element++;
            }
        }
        return matrix;
    }
}
