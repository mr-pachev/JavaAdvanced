package Lab._05_Lab;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class _05_SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(numList.toString().replaceAll("[\\[\\],]", "")
                .replaceAll(" ", ", "));

        Collections.sort(numList);

        System.out.println(numList.toString().replaceAll("[\\[\\],]", "")
                .replaceAll(" ", ", "));
    }
}
