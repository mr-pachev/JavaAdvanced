package Exercise._05_Exerc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _05_CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] numArr = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Comparator<Integer> evenThenOdd = (a, b) -> {
            if (a % 2 == 0 && b % 2 != 0) {
                return -1;
            } else if (a % 2 != 0 && b % 2 == 0) {
                return 1;
            }
            return a.compareTo(b);
        };

        Arrays.sort(numArr, evenThenOdd);
        Arrays.stream(numArr).forEach(n -> System.out.printf("%d ", n));
    }
}
