package Exercise._04_Exerc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class _04_MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        String inputPathOne = "E:\\GitHubRepo\\JavaAdvanced\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String inputPathTwo = "E:\\GitHubRepo\\JavaAdvanced\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
        String outputPath = "E:\\GitHubRepo\\JavaAdvanced\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\merges.txt";

        Path pathReadOne = Paths.get(inputPathOne);
        Path pathReadTwo = Paths.get(inputPathTwo);
        Path pathWriter = Paths.get(outputPath);

        List<String> firstList = Files.readAllLines(pathReadOne);
        List<String> secondtList = Files.readAllLines(pathReadTwo);

        Set<String> numSet = new TreeSet<>();

        numSet.addAll(firstList);
        numSet.addAll(secondtList);

        Files.write(pathWriter, numSet);

    }
}
