package StreamsFilesAndDirectories.LAB;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Set;

public class WriteToFile2 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\r.petrova\\Desktop\\Java\\Java Advanced - май 2021\\4 STREAMS, FILES AND DIRECTORIES LAB\\input.txt";
        FileInputStream inputStream = new FileInputStream(path);
        PrintStream printStream = new PrintStream("out.txt");

        Set<Character> set = Set.of(',', '.', '!', '?');
        int nextByte = inputStream.read();
        while (nextByte != -1) {
            char symbol = (char)nextByte;
          /*  if (symbol != ',' && symbol!='.' && symbol!='!' && symbol!='?'){
                System.out.print(symbol);
            }*/
            if (!set.contains(symbol)){
                printStream.print(symbol);
            }

                nextByte = inputStream.read();
        }
    }
}
