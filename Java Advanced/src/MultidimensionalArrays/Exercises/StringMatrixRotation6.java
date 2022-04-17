package MultidimensionalArrays.Exercises;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rotation = scanner.nextLine();
        int degree = Integer.parseInt(rotation.split("[()]+")[1]) % 360; //shtotot 360 e pylen kryg
        String input = scanner.nextLine();
        List<String> word = new ArrayList<>();
        int maxLength = 0;

        while (!input.equals("END")) {
            word.add(input);
            if (input.length() > maxLength) {
                maxLength = input.length();
            }
            input=scanner.nextLine();
        }

        char[][] matrix = getMatrix(word, maxLength);
        if (degree==90){
            for (int col = 0; col < maxLength; col++) {
                for (int row = word.size()-1; row >=0 ; row--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }else if (degree==180){
            for (int row = word.size()-1; row >=0 ; row--) {
                for (int col = maxLength-1; col >=0 ; col--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }else if (degree==270){
            for (int col = maxLength-1; col >=0 ; col--) {
                for (int row = 0; row < word.size(); row++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }else if (degree==0){
            for (char[] chars : matrix) {
                for (char element : chars) {
                    System.out.print(element);
                }
                System.out.println();
            }
        }
    }
    public static char[][] getMatrix(List<String> word, int maxLength){
        char[][]matrix = new char[word.size()][maxLength];
        for (int row = 0; row < word.size(); row++) {
            for (int col = 0; col < maxLength; col++) {
                if (col<word.get(row).length()){
                    matrix[row][col] = word.get(row).charAt(col);
                }else {
                    matrix[row][col] = ' ';
                }
            }
        }
        return matrix;
    }
}
