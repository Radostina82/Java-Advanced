package Exam.August2020;

import java.util.Scanner;

public class Bee2 {
    public static int pollinatedFlowers = 0;
    public static int[] beePosition = new int[2];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rowAndCol = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[rowAndCol][rowAndCol];
        boolean isLost = false;
        for (int i = 0; i < rowAndCol; i++) {
            String line = scanner.nextLine();
            matrix[i] = line.toCharArray();
            if (line.contains("B")) {
                beePosition[0] = i;
                beePosition[1] = line.indexOf('B');
            }
        }
        String input = scanner.nextLine();
        while (!input.equals("End")) {

            if (input.equals("up")) {

                if (isMove(matrix, beePosition, -1, 0)) {
                    isLost = true;
                    break;
                }

            } else if (input.equals("down")) {
                if (isMove(matrix, beePosition, +1, 0)) {
                    isLost = true;
                    break;
                }

            } else if (input.equals("left")) {
                if (isMove(matrix, beePosition, 0, -1)) {
                    isLost = true;
                    break;
                }

            } else if (input.equals("right")) {
                if (isMove(matrix, beePosition, 0, +1)) {
                    isLost = true;
                    break;
                }
            }


            input = scanner.nextLine();
        }
        if (isLost) {
            System.out.println("The bee got lost!");
        }
        if (pollinatedFlowers<5){
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5-pollinatedFlowers);
        }else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinatedFlowers);
        }
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

    public static boolean isOutOfBounds(char[][] matrix, int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }

    private static boolean isMove(char[][] matrix, int[] beePosition, int rowIndex, int colIndex) {
        int row = beePosition[0];
        int col = beePosition[1];
        int newRow = row + rowIndex;
        int newCol = col + colIndex;
        matrix[row][col] = '.';
        boolean isNotMove = false;
        if (isOutOfBounds(matrix, newRow, newCol)) {
            isNotMove = true;

        }else {
            if (matrix[newRow][newCol] == 'f') {
                pollinatedFlowers++;
            } else if (matrix[newRow][newCol] == 'O') {
                if (rowIndex == -1) {
                    matrix[newRow][newCol] = '.';
                    newRow += rowIndex;
                    if (isOutOfBounds(matrix, newRow, newCol)) {
                        return true;
                    } else {
                        if (matrix[newRow][newCol] == 'f') {
                            pollinatedFlowers++;
                        }
                    }
                } else if (rowIndex == 1) {
                    matrix[newRow][newCol] = '.';
                    newRow += rowIndex;
                    if (isOutOfBounds(matrix, newRow, newCol)) {
                        return true;
                    } else {
                        if (matrix[newRow][newCol] == 'f') {
                            pollinatedFlowers++;
                        }
                    }

                } else if (colIndex == -1) {
                    matrix[newRow][newCol] = '.';
                    newCol += colIndex;
                    if (isOutOfBounds(matrix, newRow, newCol)) {
                        return true;
                    } else {
                        if (matrix[newRow][newCol] == 'f') {
                            pollinatedFlowers++;
                        }
                    }

                } else if (colIndex == 1) {
                    matrix[newRow][newCol] = '.';
                    newCol += colIndex;
                    if (isOutOfBounds(matrix, newRow, newCol)) {
                        return true;
                    } else {
                        if (matrix[newRow][newCol] == 'f') {
                            pollinatedFlowers++;
                        }
                    }
                }
            }
            beePosition[0] = newRow;
            beePosition[1] = newCol;
            matrix[newRow][newCol] = 'B';
        }
        return isNotMove;
    }
}
