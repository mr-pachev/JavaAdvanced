package Exercise._05_Exerc;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class _05_PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int conditionalLength = Integer.parseInt(scanner.nextLine());

        String[] namesArr = scanner.nextLine().split("\\s+");

        Predicate<String> isRespondLength = s -> s.length() == conditionalLength;
        BiConsumer<String[], Predicate> printArr = (s1, s2) -> {
            Arrays.stream(s1).filter(isRespondLength).forEach(e -> System.out.println(e));
        };

        printArr.accept(namesArr, isRespondLength);
    }
}
