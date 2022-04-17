package StreamsFilesAndDirectories.Exercises;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Stream;

public class WordCount6 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\r.petrova\\Desktop\\Java\\Java Advanced - май 2021\\4 EXERCISE STREAMS, FILES AND DIRECTORIES\\words.txt";
        List<String> lines = Files.readAllLines(Path.of(path));
        String pathFind = "C:\\Users\\r.petrova\\Desktop\\Java\\Java Advanced - май 2021\\4 EXERCISE STREAMS, FILES AND DIRECTORIES\\text.txt";
        List<String> linesFind = Files.readAllLines(Path.of(pathFind));
        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
        PrintWriter writer = new PrintWriter("result6.txt");
        for (String line : lines) {
            Arrays.stream(line.split("\\s+")).forEach(word -> result.put(word, 0) );
        }
        for (String line : linesFind) {
            Arrays.stream(line.split("\\s+")).forEach(word -> {
                if (result.containsKey(word)){
                    result.put(word, result.get(word) + 1);
                }
            });
        }
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            writer.println(entry.getKey() + " - " + entry.getValue());
        }
        writer.close();
    }
}
