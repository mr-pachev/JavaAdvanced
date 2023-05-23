package Exercise._03_Exerc;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _03_Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, String> phonebook = new LinkedHashMap<>();

        while (!input.equals("search")) {
            String[] inputData = input.split("\\-");
            String name = inputData[0];
            String number = inputData[1];

            phonebook.put(name, number);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("stop")) {
            if (phonebook.containsKey(input)) {

                for (Map.Entry<String, String> entry : phonebook.entrySet()) {
                    if (entry.getKey().equals(input)) {
                        System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
                    }
                }
            } else {
                System.out.printf("Contact %s does not exist.%n", input);
            }

            input = scanner.nextLine();
        }
    }
}
