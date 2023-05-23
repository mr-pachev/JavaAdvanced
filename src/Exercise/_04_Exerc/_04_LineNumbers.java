package Exercise._04_Exerc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class _04_LineNumbers {
    public static void main(String[] args) {
        String inputPath = "E:\\GitHubRepo\\JavaAdvanced\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        String outputPath = "E:\\GitHubRepo\\JavaAdvanced\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";


        try (BufferedReader reader = Files.newBufferedReader(Path.of(inputPath));
             BufferedWriter writer = Files.newBufferedWriter(Path.of(outputPath))) {

            String line = reader.readLine();
            int lineCount = 0;

            while (line != null) {
                lineCount++;

                writer.write(lineCount + ". " + line);
                writer.newLine();
                line = reader.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
