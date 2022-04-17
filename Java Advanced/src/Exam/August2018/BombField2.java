package Exam.August2018;

import java.util.Arrays;
import java.util.Scanner;

public class BombField2 {
public static int countBomb=0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        char [][] matrix = new char[size][size];
        String [] commands = Arrays.stream(scanner.nextLine().split(",")).map(e-> e).toArray(String[]::new);
        int[] position= new int[2];
        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine().replaceAll("\\s+", "");
            matrix[i] = line.toCharArray();
            if (line.contains("s")){
                position[0] = i;
                position[1]=line.indexOf("s");
            }
            if (line.contains("B")){
                for (char c : line.toCharArray()) {
                    if (c=='B'){
                        countBomb++;
                    }
                }
            }
        }
        boolean isEnd = false;
        for (String command : commands) {
            if (command.equals("up")){
           if( movePlayer(matrix, position, -1,0)){
               isEnd = true;
               break;
           };
            }else if (command.equals("down")){
              if(  movePlayer(matrix, position, +1,0)){
                  isEnd = true;
                  break;
              }
            }else if (command.equals("left")){
               if( movePlayer(matrix, position, 0,-1)){
                   isEnd = true;
                   break;
               }
            }else if (command.equals("right")){
               if( movePlayer(matrix, position, 0,+1)){
                   isEnd = true;
                   break;
               }
               if (countBomb==0){
                   break;
               }
            }
        }
        if (countBomb==0){
            System.out.println("Congratulations! You found all bombs!");
        }else
        if (isEnd){
            System.out.println("END! " + countBomb + " bombs left on the field" );
        }
       else if (countBomb>0){
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", countBomb, position[0], position[1]);
        }
    }
    public static boolean movePlayer(char[][] matrix, int[] position, int row, int col){
        int startRow = position[0];
        int startCol = position[1];
        int newRow = startRow + row;
        int newCol = startCol + col;
        boolean isEnd = false;
        if (isBounds(matrix, newRow, newCol)){
           if (matrix[newRow][newCol] == 'B'){
               countBomb--;
               System.out.println("You found a bomb!");

           }
           if (matrix[newRow][newCol] == 'e'){
               isEnd = true;
           }
            matrix[startRow][startCol] = '+';
            position[0] = newRow;
            position[1] = newCol;
        }
        return isEnd;
    }

    private static boolean isBounds(char[][] matrix, int newRow, int newCol) {
        return newRow>=0 && newRow<matrix.length && newCol>=0 && newCol<matrix[newRow].length;
    }
}
