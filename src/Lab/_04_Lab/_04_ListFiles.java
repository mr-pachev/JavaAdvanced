package Lab._04_Lab;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class _04_ListFiles {
    public static void main(String[] args) throws IOException {
        File folder = new File("E:\\GitHubRepo\\JavaAdvanced\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        if(folder.isDirectory()){
            File[] allFiles = folder.listFiles();

            for (File s : allFiles){
                if(s.isFile()){
                    System.out.printf("%s: [%d]%n", s.getName(), s.length());
                }
            }
        }
    }
}
