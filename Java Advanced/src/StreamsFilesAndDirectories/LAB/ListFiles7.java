package StreamsFilesAndDirectories.LAB;

import java.io.File;
import java.util.logging.FileHandler;

public class ListFiles7 {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\r.petrova\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");
        File [] files = file.listFiles();
        for (File file1 : files) {
            if (!file1.isDirectory()){
                System.out.println(file1.getName() + ": " + "[" + file1.length() + "]");
            }
        }
    }
}
