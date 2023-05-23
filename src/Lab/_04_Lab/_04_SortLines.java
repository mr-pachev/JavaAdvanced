package Lab._04_Lab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class _04_SortLines {
    public static void main(String[] args) throws IOException {
        Path readPath = Paths.get("E:\\GitHubRepo\\JavaAdvanced\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
        Path writePath = Paths.get("E:\\GitHubRepo\\JavaAdvanced\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\output.txt");

        List<String> currentLine = Files.readAllLines(readPath);

        Collections.sort(currentLine);
        Files.write(writePath, currentLine);

    }
}
