package Exam.ExamOctober2019;

import java.util.Arrays;
import java.util.Scanner;

public class BookWorm2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int rowAndCol = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[rowAndCol][rowAndCol];
        int[] player = new int[2];
        StringBuilder add = new StringBuilder();
        add.append(text);

        for (int i = 0; i < rowAndCol; i++) {
            String input = scanner.nextLine();
            matrix[i] = input.toCharArray();
            if (input.contains("P")) {
                player[0] = i;
                player[1] = input.indexOf("P");
            }
        }
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            if (input.equals("up")) {
                int row = player[0];
                int col = player[1];
                if (row - 1 >= 0) {
                    if (matrix[row - 1][col] != '-') {
                        add.append(matrix[row - 1][col]);
                    }
                    player[0] = row - 1;
                    matrix[row - 1][col] = 'P';
                    matrix[row][col] = '-';
                } else {

                        add.deleteCharAt(add.length() - 1);

                }

            } else if (input.equals("down")) {
                int row = player[0];
                int col = player[1];
                if (row + 1 < matrix.length) {
                    if (matrix[row + 1][col] != '-') {
                        add.append(matrix[row + 1][col]);
                    }
                    player[0] = row + 1;
                    matrix[row + 1][col] = 'P';
                    matrix[row][col] = '-';
                } else {
                    add.deleteCharAt(add.length() - 1);
                }

            } else if (input.equals("left")) {
                int row = player[0];
                int col = player[1];
                if (col - 1 >= 0) {
                    if (matrix[row][col - 1] != '-') {
                        add.append(matrix[row][col - 1]);
                    }
                    player[1] = col - 1;
                    matrix[row][col - 1] = 'P';
                    matrix[row][col] = '-';
                } else {
                        add.deleteCharAt(add.length() - 1);

                }

            } else if (input.equals("right")) {
                int row = player[0];
                int col = player[1];
                if (col + 1 < matrix[row].length) {
                    if (matrix[row][col + 1] != '-') {
                        add.append(matrix[row][col + 1]);
                    }
                    player[1] = col + 1;
                    matrix[row][col + 1] = 'P';
                    matrix[row][col] = '-';
                } else {
                        add.deleteCharAt(add.length() - 1);
                }
            }
            input = scanner.nextLine();
        }

        System.out.println(add.toString());
        for (char[] chars : matrix) {
            for (char element : chars) {
                System.out.print(element);
            }
            System.out.println();
        }
    }
}
