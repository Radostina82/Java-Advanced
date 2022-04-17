package StreamsFilesAndDirectories.LAB;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayDeque;

public class NestedFolders8 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\r.petrova\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources");
        ArrayDeque<File> queues = new ArrayDeque<>();
        queues.offer(file);
        PrintStream printStream = new PrintStream("out8.txt");
int count = 0;
        while (!queues.isEmpty()){
            File innerFile = queues.poll();
            for (File f : innerFile.listFiles()) {
                if (f.isDirectory()){
                    count++;
                    printStream.println(f.getName());
                    queues.offer(f);
                }
            }
        }
        printStream.println(count + " folders");

    }
}
