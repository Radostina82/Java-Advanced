package StreamsFilesAndDirectories.Exercises;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class MergeTwoFiles7 {
    public static void main(String[] args) throws IOException {
        String inputOne = "C:\\Users\\r.petrova\\Desktop\\Java\\Java Advanced - май 2021\\4 EXERCISE STREAMS, FILES AND DIRECTORIES\\inputOne.txt";
        String inputTwo = "C:\\Users\\r.petrova\\Desktop\\Java\\Java Advanced - май 2021\\4 EXERCISE STREAMS, FILES AND DIRECTORIES\\inputTwo.txt";

        PrintWriter writer = new PrintWriter("output7.txt");
        Files.readAllLines(Path.of(inputOne)).forEach(writer::println);
        Files.readAllLines(Path.of(inputTwo)).forEach(writer::println);
        writer.close();
    }
}
