package Exercise._04_Exerc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class _04_CopyAPicture {
    public static void main(String[] args) throws IOException {

        FileInputStream inputStream = new FileInputStream("E:\\GitHubRepo\\JavaAdvanced\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Pic.jpg");
        FileOutputStream outputStream = new FileOutputStream("E:\\GitHubRepo\\JavaAdvanced\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Pic-copy.jpg");

        int currentByte = inputStream.read();

        while (currentByte != -1) {

            outputStream.write(currentByte);

            currentByte = inputStream.read();
        }
        inputStream.close();
        outputStream.close();
    }
}
