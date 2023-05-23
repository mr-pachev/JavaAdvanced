package Exercise._04_Exerc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class _04_ALLCAPITALS {
    public static void main(String[] args) {
        String inputPath = "E:\\GitHubRepo\\JavaAdvanced\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputPath = "E:\\GitHubRepo\\JavaAdvanced\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";


        try (BufferedReader reader = Files.newBufferedReader(Path.of(inputPath));
             BufferedWriter writer = Files.newBufferedWriter(Path.of(outputPath))){

            String line = reader.readLine();

            while (line != null){

                writer.write(line.toUpperCase());
                writer.newLine();                  //премества курсура на нов ред

                line = reader.readLine();
            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

