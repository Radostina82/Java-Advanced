package StreamsFilesAndDirectories.Exercises;

import java.io.File;

public class GetFolderSize8 {
    public static void main(String[] args) {
        String path = "C:\\Users\\r.petrova\\Desktop\\Java\\Java Advanced - май 2021\\4 EXERCISE STREAMS, FILES AND DIRECTORIES\\Exercises Resources";
        File folder = new File(path);

        int folderSize = 0;
        for (File file : folder.listFiles()) {
            folderSize += file.length();
        }

        System.out.println("Folder size: " + folderSize);
    }
}
