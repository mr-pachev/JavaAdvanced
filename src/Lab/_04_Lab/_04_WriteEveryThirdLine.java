package Lab._04_Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class _04_WriteEveryThirdLine {
    public static void main(String[] args) throws FileNotFoundException {
        String readPath = "E:\\GitHubRepo\\JavaAdvanced\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String writePath = "E:\\GitHubRepo\\JavaAdvanced\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\output.txt";

        FileInputStream inputStream = new FileInputStream(readPath);
        FileOutputStream outputStream = new FileOutputStream(writePath);

        Scanner scanner = new Scanner(inputStream);
        PrintWriter printWriter = new PrintWriter(outputStream);

        int countLine = 1;
        String line = scanner.nextLine();

        while (scanner.hasNextLine()) {

            if (countLine % 3 == 0) {
                printWriter.println(line);
            }

            countLine++;
            line = scanner.nextLine();
        }
        scanner.close();
        printWriter.close();
    }
}
