package Exercise._04_Exerc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class _04_WordCount {
    public static void main(String[] args) {
        String inputPathList = "E:\\GitHubRepo\\JavaAdvanced\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        String inputPath = "E:\\GitHubRepo\\JavaAdvanced\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        String outputPath = "E:\\GitHubRepo\\JavaAdvanced\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\results.txt";

        try (BufferedReader readerList = Files.newBufferedReader(Path.of(inputPathList));
             BufferedReader reader = Files.newBufferedReader(Path.of(inputPath));
             BufferedWriter writer = Files.newBufferedWriter(Path.of(outputPath))) {

            //създаваме лист с думите за проверка
            String line = readerList.readLine();
            List<String> wordList = Arrays.stream(line.split("\\s+")).collect(Collectors.toList());

            Map<String, Integer> wordsMap = new HashMap<>();     //съдържа думите за проверка и техния брой срещания
            for (String s : wordList) {
                wordsMap.put(s, 0);
            }

            line = reader.readLine();

            String[] wordsArr = line.split("[ ,.]+");

            for (Map.Entry<String, Integer> entry : wordsMap.entrySet()) {

                for (int i = 0; i < wordsArr.length; i++) {
                    if (entry.getKey().equals(wordsArr[i])) {
                        wordsMap.put(entry.getKey(), entry.getValue() + 1);
                    }
                }
            }

            wordsMap.entrySet().stream().
                    sorted((s1, s2) -> s2.getValue().compareTo(s1.getValue()))
                    .forEach(entry -> {
                        try {
                            writer.write(String.format("%s - %d%n", entry.getKey(), entry.getValue()));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
