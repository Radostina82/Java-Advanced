package MultidimensionalArrays.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Crossfire7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int []rowsAndCols = readArr(input, "\\s+");
        int rows =rowsAndCols[0];
        int cols =rowsAndCols[1];
        List<List<Integer>> matrix = getMatrix(rows, cols);

        input = scanner.nextLine();
        while (!input.equals("Nuke it from orbit")){
            int [] tokens = readArr(input, "\\s+");
            int row = tokens[0];
            int col = tokens[1];
            int radius = tokens[2];


            for (int currentRow = row-radius; currentRow <=row+radius ; currentRow++) {
                if (isBound(matrix, currentRow, col) && currentRow!=row){
                    matrix.get(currentRow).remove(col);
                }
               /* if (currentRow>=0 && currentRow< matrix.size() && col >=0 && col<matrix.get(currentRow).size()){
                    matrix.get(currentRow).remove(col);
                }*/
            }

            //трия ляво и дясно по реда
            for (int currentCol = col+radius; currentCol>=col-radius ; currentCol--) {
                if (isBound(matrix, row, currentCol)){
                    matrix.get(row).remove(currentCol);
                }
            }


            matrix.removeIf(List::isEmpty);
            input = scanner.nextLine();
        }

        printMatrix(matrix);
    }
    public static void printMatrix(List<List<Integer>> matrix){
        for (List<Integer> list : matrix) {
            for (Integer element : list) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static boolean isBound(List<List<Integer>> matrix, int rows, int cols){
        return rows>=0 && rows<matrix.size() && cols>=0 && cols<matrix.get(rows).size();
    }
    public static List<List<Integer>> getMatrix(int rows, int cols){
        List<List<Integer>> matrix = new ArrayList<>();
        int num = 1;
        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {

               matrix.get(row).add(num++);
            }
        }

        return matrix;
    }
    public static int[] readArr(String input, String pattern){
        return Arrays.stream(input.split(pattern)).mapToInt(Integer::parseInt).toArray();
    }
}
