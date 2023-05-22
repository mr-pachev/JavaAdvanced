package Lab;

import java.io.File;
import java.util.*;

public class _04_NestedFolders {
    public static void main(String[] args) {
        File folders = new File("E:\\GitHubRepo\\JavaAdvanced\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        Deque<File> filesDeque = new ArrayDeque<>();
        filesDeque.offer(folders);

        List<String> fileList = new ArrayList<>();

        while (!filesDeque.isEmpty()) {
            File currentDir = filesDeque.removeFirst();             //премахва първия елемент от опашката

            if (currentDir.isDirectory()) {                         //проверка дали е папка
                for (File file : Objects.requireNonNull(currentDir.listFiles())) {
                    if (file.isDirectory()) {
                        filesDeque.offer(file);
                    }
                }
                fileList.add(currentDir.getName());
            }
        }
        fileList.forEach(System.out::println);
        System.out.printf("%d folders", fileList.size());

    }
}
