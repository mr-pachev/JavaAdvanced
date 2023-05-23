package Exercise._04_Exerc;

import java.io.*;

public class _04_SerializeCustomObject {
    public static void main(String[] args) throws IOException {
        Course course = new Course("Java-Advanced-may", 500);

        String path = "E:\\GitHubRepo\\JavaAdvanced\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\course.ser";
        FileOutputStream outputStream = new FileOutputStream(path);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        objectOutputStream.writeObject(course);

    }
}
