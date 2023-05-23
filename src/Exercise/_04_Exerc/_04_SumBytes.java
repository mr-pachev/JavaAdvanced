package Exercise._04_Exerc;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class _04_SumBytes {
    public static void main(String[] args) {

        String inputPath = "E:\\GitHubRepo\\JavaAdvanced\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try (BufferedReader reader = Files.newBufferedReader(Path.of(inputPath));) {
            String line = reader.readLine();

            int count = 0;
            while (line != null) {                          //върти цикъла, докато има редове за чете от файла

                for (int i = 0; i < line.length(); i++) {
                    int asciiCode = line.codePointAt(i);    //взима ascii кода на всеки конкретен символ
                    count += asciiCode;
                }
                line = reader.readLine();
            }
            System.out.println(count);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
