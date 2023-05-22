package Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class _04_ExtractIntegers {
    public static void main(String[] args) throws IOException {
        String readPath = "E:\\GitHubRepo\\JavaAdvanced\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String writePath = "E:\\GitHubRepo\\JavaAdvanced\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\Streams-and-Files\\output.txt";

        FileInputStream inputStream = new FileInputStream(readPath);
        FileOutputStream outputStream = new FileOutputStream(writePath);

        Scanner scanner = new Scanner(inputStream);
        PrintWriter writer = new PrintWriter(outputStream);

        while (scanner.hasNext()) {                             //проверява дали има следващ символ във файла за четена

            if (scanner.hasNextInt()) {                         //проверява дали следващия символ е цяло число
                int currentNum = scanner.nextInt();             //взима следващото цяло число
                writer.println(currentNum);
            }
            scanner.next();                                     //преминава на следващато дума
        }

       writer.close();
    }
}
