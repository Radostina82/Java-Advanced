package StreamsFilesAndDirectories.LAB;

import javax.imageio.IIOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile1 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\r.petrova\\Desktop\\Java\\Java Advanced - май 2021\\4 STREAMS, FILES AND DIRECTORIES LAB\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);
        Scanner scanner = new Scanner(inputStream);// четем ред по ред
      /*  while (scanner.hasNext()) {
            System.out.println(Integer.toBinaryString(scanner.nextByte()));}
            */


           int read = inputStream.read();//чета байт по байт
                while (read!=-1){
                    System.out.print(Integer.toBinaryString(read) + " ");
                    read = inputStream.read();
                }

        }
    }

