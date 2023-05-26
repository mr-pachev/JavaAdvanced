package Exercise._05_Exerc;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class _05_CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] arr = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Function<Integer[], Integer> smallestNum = n -> Arrays.stream(arr)
                .mapToInt(e -> e)
                .min()
                .getAsInt();

        System.out.println(smallestNum.apply(arr));

    }
}
