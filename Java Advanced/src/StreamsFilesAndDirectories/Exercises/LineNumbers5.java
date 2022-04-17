package StreamsFilesAndDirectories.Exercises;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LineNumbers5 {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("C:\\Users\\r.petrova\\Desktop\\Java\\Java Advanced - май 2021\\4 EXERCISE STREAMS, FILES AND DIRECTORIES\\inputLineNumbers.txt");
        List<String> lines = Files.readAllLines(path);
        PrintWriter writer = new PrintWriter("output5.txt");
        int count = 0;
        for (String line : lines) {
            count++;
            writer.println(count + ". " + line);
        }
        writer.close();
    }
}
