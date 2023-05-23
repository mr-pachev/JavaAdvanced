package Exercise._03_Exerc;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _03_SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] setSize = Arrays.stream(scanner.nextLine()
                                .split(" "))
                                .mapToInt(Integer::parseInt)
                                 .toArray();

        Set<Integer> setOne = new LinkedHashSet<>();
        Set<Integer> setTwo = new LinkedHashSet<>();

        for (int i = 1; i <= setSize[0]; i++) {
            setOne.add(Integer.parseInt(scanner.nextLine()));
        }

        for (int i = 1; i <= setSize[1]; i++) {
            setTwo.add(Integer.parseInt(scanner.nextLine()));
        }
        setOne.retainAll(setTwo);

        setOne.forEach(element -> System.out.printf("%d ", element));
    }
}
