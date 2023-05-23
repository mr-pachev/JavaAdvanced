package Exercise._03_Exerc;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _03_PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> elements = new TreeSet<>();

        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split(" ");
            elements.addAll(List.of(input));   //пълни сета директно с масива
        }

        elements.forEach(e -> System.out.print(e + " "));
    }
}
