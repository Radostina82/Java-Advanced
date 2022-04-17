package StreamsFilesAndDirectories.Exercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SumBytes2 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\r.petrova\\Desktop\\Java\\Java Advanced - май 2021\\" +
                "4 EXERCISE STREAMS, FILES AND DIRECTORIES\\input.txt";
        List<String> line = Files.readAllLines(Path.of(path));
        int sumTotal = 0;
        for (String s : line) {
            int sum = 0;
            for (char character : s.toCharArray()) {
                sum += character;
            }
            sumTotal += sum;
        }
        System.out.println(sumTotal);
    }
}
