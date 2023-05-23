package Exercise._04_Exerc;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class _04_GetFolderSize {
    public static void main(String[] args) {

        File current = new File("E:\\GitHubRepo\\JavaAdvanced\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources");

        int countByte = 0;

       if (current.exists()){
           if(current.isDirectory()){                       //проверка дали е папка
               File[] listFile = current.listFiles();       //създаваме масива с файловете и папките

               for (File s: listFile){
                   if (!s.isDirectory()){                   //ако поредния елемент не е папка
                       countByte += s.length();
                   }

               }
           }
       }
        System.out.printf("Folder size: %d", countByte);

    }
}
