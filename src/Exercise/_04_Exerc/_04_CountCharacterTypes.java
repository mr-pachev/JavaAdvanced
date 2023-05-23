package Exercise._04_Exerc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class _04_CountCharacterTypes {
    public static void main(String[] args) {
        String inputPath = "E:\\GitHubRepo\\JavaAdvanced\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try (BufferedReader reader = Files.newBufferedReader(Path.of(inputPath));){

            List<Character> lower = List.of('a', 'o', 'e', 'i', 'u');
            List<Character> punctuation = List.of('?', '!', '.', ',');

            int lowersCount = 0;
            int punctuationsCount = 0;
            int othersCount = 0;

            String line = reader.readLine();

            while(line != null){

                for (int i = 0; i < line.length(); i++) {
                    char symbol = line.charAt(i);

                    if (lower.contains(symbol)){
                        lowersCount++;
                    }else if (punctuation.contains(symbol)){
                       punctuationsCount++;
                    }else if (symbol != ' '){
                       othersCount++;
                    }
                }

                line = reader.readLine();
            }

            System.out.printf("Vowels: %d%nOther symbols: %d%nPunctuation: %d%n", lowersCount, othersCount, punctuationsCount);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
