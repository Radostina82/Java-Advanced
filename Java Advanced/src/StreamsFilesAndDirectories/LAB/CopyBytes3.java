package StreamsFilesAndDirectories.LAB;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Set;

public class CopyBytes3 {
    public static void main(String[] args)throws IOException {
        String path = "C:\\Users\\r.petrova\\Desktop\\Java\\Java Advanced - май 2021\\4 STREAMS, FILES AND DIRECTORIES LAB\\input.txt";
        FileInputStream inputStream = new FileInputStream(path);
        Set<Character> set = Set.of(' ', '\n');
        PrintStream printStream = new PrintStream("out3.txt");
        int nextByte = inputStream.read();
        while (nextByte!=-1){
            char symbol = (char)nextByte;
            if (set.contains(symbol)){
                printStream.print((char)symbol);
            }else {
                printStream.print(nextByte);
            }
            nextByte=inputStream.read();
        }
    }
}
