package StreamsFilesAndDirectories.Exercises;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SumLines1 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\r.petrova\\Desktop\\Java\\Java Advanced - май 2021\\" +
                "4 EXERCISE STREAMS, FILES AND DIRECTORIES\\input.txt";
        Files.readAllLines(Path.of(path)).stream().map(String::toCharArray).
                forEach(charArray -> {
                    int sum = 0;
                    for (char c : charArray) {
                        sum+=c;
                    }
                    System.out.println(sum);
                });



    }
}
