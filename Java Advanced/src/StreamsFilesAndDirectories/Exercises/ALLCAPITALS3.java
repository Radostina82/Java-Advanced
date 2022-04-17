package StreamsFilesAndDirectories.Exercises;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Locale;

public class ALLCAPITALS3 {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("C:\\Users\\r.petrova\\Desktop\\Java\\Java Advanced - май 2021\\4 EXERCISE STREAMS, FILES AND DIRECTORIES\\input.txt");
        List<String> lines = Files.readAllLines(path);

       // lines.forEach(line -> line.toUpperCase(Locale.ROOT));
        BufferedWriter writer = new BufferedWriter(new FileWriter("output3.txt"));
        for (String line : lines) {
            writer.write(line.toUpperCase());
            writer.newLine();
        }
        writer.close();
    }
}
