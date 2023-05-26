package Exercise._05_Exerc;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class _05_KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arr = scanner.nextLine().split("\\s+");

        Consumer<String> printElement = el -> System.out.printf("Sir %s%n", el);

        Arrays.stream(arr).forEach(printElement);

    }
}
