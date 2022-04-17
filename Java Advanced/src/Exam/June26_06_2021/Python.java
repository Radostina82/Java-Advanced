package Exam.June26_06_2021;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Python {
    public static int countFood = 0;
    public static int length = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        //String[] commands = Arrays.stream(scanner.nextLine().split(", ")).map(e -> e).toArray(String[]::new);
        char[][] matrix = new char[size][size];
        int[] positions = new int[2];
        List<String> commands = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine().replaceAll("\\s+", "");
            matrix[i] = line.toCharArray();
            if (line.contains("s")) {
                positions[0] = i;
                positions[1] = line.indexOf("s");
            }
            if (line.contains("f")) {
                for (char c : line.toCharArray()) {
                    if (c == 'f') {
                        countFood++;
                    }
                }
            }
        }

        boolean isDie = false;
        for (int i = 0; i < commands.size(); i++) {
            String command = commands.get(i);

                if (command.equals("up")) {
                    if (movePython(matrix, positions, -1, 0)) {
                        isDie = true;
                        break;
                    }
                } else if (command.equals("down")) {
                    if (movePython(matrix, positions, +1, 0)) {
                        isDie = true;
                        break;
                    }
                } else if (command.equals("left")) {
                    if (movePython(matrix, positions, 0, -1)) {
                        isDie = true;
                        break;
                    }
                } else if (command.equals("right")) {
                    if (movePython(matrix, positions, 0, +1)) {
                        isDie = true;
                        break;
                    }
                }
            if (countFood == 0) {
                System.out.printf("You win! Final python length is %d", length);
                break;
            }
            commands.set(i, "");
        }

        if (countFood > 0 && !commands.contains("left") && !isDie) {
            System.out.printf("You lose! There is still %d food to be eaten.", countFood);
        }
    }

    public static boolean movePython(char[][] matrix, int[] positions, int row, int col) {
        int startRow = positions[0];
        int startCol = positions[1];
        int newRow = indexInBounds(startRow + row, matrix.length - 1);
        int newCol = indexInBounds(startCol + col, matrix.length - 1);

        if (matrix[newRow][newCol] == 'f') {
            matrix[newRow][newCol] = '*';
            countFood--;
            length++;

        } else if (matrix[newRow][newCol] == 'e') {
            System.out.println("You lose! Killed by an enemy!");
            return true;
        }
        matrix[startRow][startCol] = '*';
        
        positions[0] = newRow;
        positions[1] = newCol;
        return false;
    }

    public static int indexInBounds(int index, int bounds) {
        if (index < 0) {
            index = bounds;
        } else if (index > bounds) {
            index = 0;
        }
        return index;
    }
}
