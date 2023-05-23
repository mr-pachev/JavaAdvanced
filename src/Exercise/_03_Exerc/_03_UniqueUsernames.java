package Exercise._03_Exerc;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _03_UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Set<String> userNames = new LinkedHashSet<>();

        for (int i = 1; i <= n; i++) {
            userNames.add(scanner.nextLine());
        }

        userNames.forEach(name -> System.out.println(name));
    }
}
