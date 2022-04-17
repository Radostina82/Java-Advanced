package StreamsFilesAndDirectories.LAB;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class WriteEveryThirdLine5 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\r.petrova\\Desktop\\Java\\Java Advanced - май 2021\\4 STREAMS, FILES AND DIRECTORIES LAB\\input.txt";
        FileReader reader = new FileReader(path);
        PrintStream printStream = new PrintStream("out5.txt");
        Scanner scanner = new Scanner(reader);
        int count = 0;
        while (scanner.hasNext()) {
            count++;
            if (count % 3 == 0) {
                printStream.println(scanner.nextLine());
            } else {
                scanner.nextLine();
            }
        }
    }

}
