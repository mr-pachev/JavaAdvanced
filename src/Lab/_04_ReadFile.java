package Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class _04_ReadFile {
    public static void main(String[] args) throws IOException {
        String path = "E:\\GitHubRepo\\JavaAdvanced\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);            //отваряне на поток за четене

        int currentByte = inputStream.read();                               //променлива, която ще държи конкретния прочетен байт от зададения път на файла с помоща на read

        while (currentByte > 0){                                            //докато има байтове във файла
            System.out.print(Integer.toBinaryString(currentByte) + " ");    //конвертира Integer в двойчен вис

            currentByte = inputStream.read();
        }

        inputStream.close();                                                 //затваряне на потока
    }
}
