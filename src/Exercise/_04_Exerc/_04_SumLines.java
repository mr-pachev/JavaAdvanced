package Exercise._04_Exerc;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class _04_SumLines {
    public static void main(String[] args) {
        String inputPath = "E:\\GitHubRepo\\JavaAdvanced\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try (BufferedReader reader = Files.newBufferedReader(Path.of(inputPath));) {
            String line = reader.readLine();

            while (line != null) {                          //върти цикъла, докато има редове за чете от файла
                int count = 0;

                for (int i = 0; i < line.length(); i++) {
                    int asciiCode = line.codePointAt(i);    //взима ascii кода на всеки конкретен символ
                    count += asciiCode;
                }

                System.out.println(count);
                line = reader.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
