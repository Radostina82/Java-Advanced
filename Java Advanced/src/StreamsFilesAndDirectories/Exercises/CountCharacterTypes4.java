package StreamsFilesAndDirectories.Exercises;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CountCharacterTypes4 {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("C:\\Users\\r.petrova\\Desktop\\Java\\Java Advanced - май 2021\\4 EXERCISE STREAMS, FILES AND DIRECTORIES\\input.txt");
        List<String> lines = Files.readAllLines(path);
        int sumVowels = 0;
        int sumConsonants  = 0;
        int sumPunctuation = 0;
        //BufferedWriter writer = new BufferedWriter(new FileWriter());
        PrintWriter writer = new PrintWriter("output4.txt");
        for (String line : lines) {
            for (char characters : line.toCharArray()) {
                if (characters=='a' || characters == 'e' || characters=='i' || characters=='o' || characters=='u'){
                    sumVowels ++;
                }else if (characters=='!' || characters==',' || characters=='.' || characters=='?'){
                    sumPunctuation++;
                }else if (characters!= ' '){
                    sumConsonants++;
                }
            }
        }
        writer.write("Vowels: " + sumVowels);
        writer.println();
        writer.write("Consonants: " + sumConsonants);
        writer.println();
        writer.write("Punctuation: " + sumPunctuation);
        writer.close();
    }
}
