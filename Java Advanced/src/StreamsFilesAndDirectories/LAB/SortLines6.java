package StreamsFilesAndDirectories.LAB;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SortLines6 {
    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Users\\r.petrova\\Desktop\\Java\\Java Advanced - май 2021\\4 STREAMS, FILES AND DIRECTORIES LAB\\input.txt";
        Path path = Paths.get(fileName);
        List<String> lines = Files.readAllLines(path);
        Collections.sort(lines);
        PrintStream printStream = new PrintStream("out6.txt");
        for (String line : lines) {

            printStream.println(line);
        }

    }
}
