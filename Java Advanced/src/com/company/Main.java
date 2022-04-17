package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;


import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] rowAndCol = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = rowAndCol[0];
        int cols = rowAndCol[1];
        char[][] matrix = new char[rows][cols];
        String input = "";
        boolean isDies = false;

        int[] posPlayer = new int[2];
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < matrix.length; i++) {
            input = scanner.nextLine();
            for (int j = 0; j < input.length(); j++) {
                char currentChar = input.charAt(j);
                if (currentChar == 'P') {
                    matrix[i][j] = '.';
                    posPlayer[0] = i;//row
                    posPlayer[1] = j;//col
                    continue;
                }
                if (currentChar == 'B') {
                    queue.offer(i);//row
                    queue.offer(j);//col
                }
                matrix[i][j] = currentChar;
            }
        }
        input = scanner.nextLine();

        for (char c : input.toCharArray()) {
            int playerRow = posPlayer[0];
            int playerCol = posPlayer[1];

            moveBunnies(matrix, queue);

            if (c == 'U') {//nagore
                playerRow -= 1;

            } else if (c == 'D') {//nadolu
                playerRow += 1;
            } else if (c == 'L') {//lqvo
                playerCol -= 1;
            } else if (c == 'R') {//dqsno
                playerCol += 1;
            }
            if (!isBound(playerRow, playerCol, matrix)) {
                break;
            }
            posPlayer[0] = playerRow;
            posPlayer[1] = playerCol;

            if (matrix[playerRow][playerCol] != '.') {
                isDies = true;
                break;
            }

        }
        printMatrix(matrix);
        if (isDies){
            System.out.print("dead: ");
        }else {
            System.out.print("won: ");
        }
        System.out.print(posPlayer[0] + " " + posPlayer[1]);
    }

    public static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char element : chars) {
                System.out.print(element);
            }
            System.out.println();
        }
    }

    private static void moveBunnies(char[][] matrix, ArrayDeque<Integer> queue) {
        int length = queue.size() / 2;
        for (int i = 0; i < length; i++) {
            int row = queue.poll();
            int col = queue.poll();
            for (int j = 0; j < matrix[row].length; j++) {
                if (isBound(row + 1, col, matrix) && matrix[row + 1][col] != 'B') {//nadolu
                    matrix[row + 1][col] = 'B';
                    queue.offer(row + 1);
                    queue.offer(col);
                }
                if (isBound(row - 1, col, matrix) && matrix[row - 1][col] != 'B') {//nagore
                    matrix[row - 1][col] = 'B';
                    queue.offer(row - 1);
                    queue.offer(col);
                }
                if (isBound(row , col-1, matrix) && matrix[row][col - 1] != 'B') {//nalqvo
                    matrix[row][col - 1] = 'B';
                    queue.offer(row);
                    queue.offer(col - 1);
                }
                if (isBound(row , col +1, matrix) && matrix[row][col + 1] != 'B') {//nadqsno
                    matrix[row][col + 1] = 'B';
                    queue.offer(row);
                    queue.offer(col + 1);
                }
            }
        }
    }

    private static boolean isBound(int i, int col, char[][] matrix) {
        return i >= 0 && i < matrix.length && col >= 0 && col < matrix[i].length;
    }

}