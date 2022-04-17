package Exam.June2020;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Snake2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rowAndCol = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[rowAndCol][rowAndCol];
        int[] positionSnake = new int[2];
        ArrayDeque<Integer> positionsBurrows = new ArrayDeque<>();
        int food = 0;
        for (int i = 0; i < rowAndCol; i++) {
            String line = scanner.nextLine();
            matrix[i] = line.toCharArray();
            if (line.contains("S")){
                positionSnake[0]=i;
                positionSnake[1]=line.indexOf('S');
            }else if (line.contains("B")){
                positionsBurrows.offer(i);
                positionsBurrows.offer(line.indexOf('B'));
            }
        }

        boolean isOut = false;
        while (food<10){
            String  command=scanner.nextLine();
          int row = positionSnake[0];
          int col = positionSnake[1];
            matrix[row][col] = '.';
          if (command.contains("up")){
              row = row-1;
              if (!isInBound(matrix, row, col)){
                  isOut = true;
                  break;
              }else {
                  if (matrix[row][col] =='*'){
                      food++;
                      positionSnake[0]= row;
                  }else if (matrix[row][col] =='B'){
                      if (row == positionsBurrows.peek() && col == positionsBurrows.peek()){
                          row = positionsBurrows.poll();
                          col = positionsBurrows.poll();
                          int newRow = positionsBurrows.poll();
                          int newCol = positionsBurrows.poll();
                          matrix[row][col] = '.';
                          positionSnake[0] = newRow;
                          positionSnake[1]= newCol;
                      }else {
                          row = positionsBurrows.poll();
                          col = positionsBurrows.poll();
                          int newRow = positionsBurrows.poll();
                          int newCol = positionsBurrows.poll();
                          matrix[row][col] = '.';
                          row = newRow;
                          col = newCol;
                          positionSnake[0] = newRow;
                          positionSnake[1]= newCol;
                      }
                  }else {
                      positionSnake[0]= row;
                  }
              }
          }else if (command.equals("down")){
              row = row+1;
              if (!isInBound(matrix, row, col)){
              isOut = true;
              break;
          }else {

              if (matrix[row][col] =='*'){
                  food++;
                  positionSnake[0]= row;
              }else if (matrix[row][col] =='B'){
                  if (row == positionsBurrows.peek() && col == positionsBurrows.peek()){
                      row = positionsBurrows.poll();
                      col = positionsBurrows.poll();
                      int newRow = positionsBurrows.poll();
                      int newCol = positionsBurrows.poll();
                      matrix[row][col] = '.';
                      positionSnake[0] = newRow;
                      positionSnake[1]= newCol;
                  }else {
                      row = positionsBurrows.poll();
                      col = positionsBurrows.poll();
                      int newRow = positionsBurrows.poll();
                      int newCol = positionsBurrows.poll();
                      matrix[row][col] = '.';
                      row = newRow;
                      col = newCol;
                      positionSnake[0] = newRow;
                      positionSnake[1]= newCol;
                  }
              }else {
                  positionSnake[0]= row;
              }
          }

          }else if (command.equals("left")){
              col = col -1;
              if (!isInBound(matrix, row, col)){
                  isOut = true;
                  break;
              }else {

                  if (matrix[row][col] =='*'){
                      food++;
                      positionSnake[1]= col;
                  }else if (matrix[row][col] =='B'){
                      if (row == positionsBurrows.peek() && col == positionsBurrows.peek()){
                          row = positionsBurrows.poll();
                          col = positionsBurrows.poll();
                          int newRow = positionsBurrows.poll();
                          int newCol = positionsBurrows.poll();
                          matrix[row][col] = '.';
                          positionSnake[0] = newRow;
                          positionSnake[1]= newCol;
                      }else {
                          row = positionsBurrows.poll();
                          col = positionsBurrows.poll();
                          int newRow = positionsBurrows.poll();
                          int newCol = positionsBurrows.poll();
                          matrix[row][col] = '.';
                          row = newRow;
                          col = newCol;
                          positionSnake[0] = newRow;
                          positionSnake[1]= newCol;
                      }
                  }else {
                      positionSnake[1]= col;
                  }
              }
          }else if (command.equals("right")){
              col = col +1;
              if (!isInBound(matrix, row, col)){
                  isOut = true;
                  break;
              }else {

                  if (matrix[row][col] =='*'){
                      food++;
                      positionSnake[1]= col;
                  }else if (matrix[row][col] =='B'){
                      if (row == positionsBurrows.peek() && col == positionsBurrows.peek()){
                          row = positionsBurrows.poll();
                          col = positionsBurrows.poll();
                          int newRow = positionsBurrows.poll();
                          int newCol = positionsBurrows.poll();
                          matrix[row][col] = '.';
                          positionSnake[0] = newRow;
                          positionSnake[1]= newCol;
                      }else {
                          row = positionsBurrows.poll();
                          col = positionsBurrows.poll();
                          int newRow = positionsBurrows.poll();
                          int newCol = positionsBurrows.poll();
                          matrix[row][col] = '.';
                          row = newRow;
                          col = newCol;
                          positionSnake[0] = newRow;
                          positionSnake[1]= newCol;
                      }
                  }else {
                      positionSnake[1]= col;
                  }
              }
          }
          matrix[row][col] = 'S';

      }
       if(isOut){
           System.out.println("Game over!");
       }
       if (food==10){
           System.out.println("You won! You fed the snake.");
       }
        System.out.println("Food eaten: " + food);
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
    public static boolean isInBound(char[][] matrix, int row, int col){
        return row>=0 && row<matrix.length && col>=0 && col < matrix[row].length;
    }
}
