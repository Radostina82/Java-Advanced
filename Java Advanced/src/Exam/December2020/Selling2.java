package Exam.December2020;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Selling2 {
    public static int price = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        int[] position = new int[2];

        List<Integer> pillars = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine();
            matrix[i] = line.toCharArray();
            if (line.contains("S")) {
                position[0] = i;
                position[1] = line.indexOf("S");
            }
            if (line.contains("O")) {
                pillars.add(i);
                pillars.add(line.indexOf("O"));
            }
        }

        boolean isInBounds = false;

        while (price < 50) {
            String command = scanner.nextLine();

            if (command.equals("up")) {
               if(movePlayer(matrix, position, pillars, -1, 0)){
                  isInBounds =true;
                  break;
               }
            } else if (command.equals("down")) {
                if(movePlayer(matrix, position, pillars, +1, 0)){
                    isInBounds =true;
                    break;
                }
            } else if (command.equals("left")) {
                if(movePlayer(matrix, position, pillars, 0, -1)){
                    isInBounds =true;
                    break;
                }
            } else if (command.equals("right")) {
                if(movePlayer(matrix, position, pillars, 0, +1)){
                    isInBounds =true;
                    break;
                }
            }
        }
        if (isInBounds){
            System.out.println("Bad news, you are out of the bakery.");
        }
        if (price>=50){
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.println("Money: " + price);
        printMatrix(matrix);
    }
    public static void printMatrix(char[][] matrix){
        for (char[] arr : matrix) {
            for (char c : arr) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
    public static boolean movePlayer(char[][] matrix, int[] positions, List<Integer> pillars, int currentRow, int currentCol) {
        int row = positions[0];
        int col = positions[1];
        int newRow = row + currentRow;
        int newCol = col + currentCol;
        boolean isOut = false;
        if (!isInBound(matrix, newRow, newCol)) {
            matrix[row][col] = '-';
            isOut=true;

        }else {
            if (Character.isDigit(matrix[newRow][newCol])) {
                price +=Integer.parseInt(String.valueOf(matrix[newRow][newCol]));
            } else if (matrix[newRow][newCol] == 'O') {
                if (newRow == pillars.get(0) && newCol == pillars.get(1)) {
                    matrix[newRow][newCol] = '-';
                    newRow = pillars.get(2);
                    newCol = pillars.get(3);
                } else {
                    matrix[newRow][newCol] = '-';
                    newRow = pillars.get(0);
                    newCol = pillars.get(1);
                }
            }
            matrix[row][col] = '-';
            matrix[newRow][newCol] = 'S';
            positions[0] = newRow;
            positions[1] = newCol;
        }
        return isOut;
    }

    public static boolean isInBound(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }
}
