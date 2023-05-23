package Lab._04_Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _04_CopyBytes {
    public static void main(String[] args) throws IOException {
        String readPath = "E:\\GitHubRepo\\JavaAdvanced\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String writePath = "E:\\GitHubRepo\\JavaAdvanced\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\output.txt";

        FileInputStream inputStream = new FileInputStream(readPath);
        FileOutputStream outputStream = new FileOutputStream(writePath);

        int currentByte = inputStream.read();

        while (currentByte > 0) {
            char symbol = (char) currentByte;
            if (currentByte == 10 || currentByte == 32) {               //записва currentByte, като space или като NewLine
                outputStream.write(currentByte);
            } else {
                String currentDigit = String.valueOf(currentByte);      //взима currentByte(кода от ASCii таблицата) и го превръща в стинг
                for (int i = 0; i < currentDigit.length(); i++) {
                    outputStream.write(currentDigit.charAt(i));         //записва всеки пореден код но currentByte до паявата на space или NewLine
                }
            }

            currentByte = inputStream.read();
        }
        inputStream.close();
        outputStream.close();
    }
}
