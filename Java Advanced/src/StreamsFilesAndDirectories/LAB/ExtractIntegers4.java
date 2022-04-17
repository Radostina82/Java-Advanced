package StreamsFilesAndDirectories.LAB;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class ExtractIntegers4 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\r.petrova\\Desktop\\Java\\Java Advanced - май 2021\\4 STREAMS, FILES AND DIRECTORIES LAB\\input.txt";
        FileInputStream fileInputStream = new FileInputStream(path);

        PrintStream printStream = new PrintStream("out4.txt");
        Scanner scanner = new Scanner(fileInputStream);

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                printStream.println(scanner.nextInt());
            }
            scanner.next();
        }
    }
}
