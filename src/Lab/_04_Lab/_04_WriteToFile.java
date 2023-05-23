package Lab._04_Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _04_WriteToFile {
    public static void main(String[] args) throws IOException {

        String inputPath = "E:\\GitHubRepo\\JavaAdvanced\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\input.txt";
        String outputPath = "E:\\GitHubRepo\\JavaAdvanced\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\output.txt";

        FileInputStream inputStream = new FileInputStream(inputPath);       //отваряне на поток за четене
        FileOutputStream outputStream = new FileOutputStream(outputPath);   //отваряне на поток за писане

        int currentByte = inputStream.read();

        while ((int) currentByte > 0) {                                    //подсигуряваме си четене на всички символи от файла
            char currentSymbol = (char) currentByte;                       //представяне на int, като символ

            if (currentByte != '.' && currentByte != ',' && currentByte != '!' && currentByte != '?') {
                outputStream.write(currentByte);
            }

            currentByte = inputStream.read();
        }

        inputStream.close();
        outputStream.close();
    }
}
