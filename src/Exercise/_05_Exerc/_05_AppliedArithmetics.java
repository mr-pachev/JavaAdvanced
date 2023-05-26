package Exercise._05_Exerc;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _05_AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        Function<List<Integer>, List<Integer>> addList = list -> list.stream()
                .map(e -> e + 1)
                .collect(Collectors.toList());

        Function<List<Integer>, List<Integer>> multiplyList = list -> list.stream()
                .map(e -> e * 2)
                .collect(Collectors.toList());

        Function<List<Integer>, List<Integer>> subtractList = list -> list.stream()
                .map(e -> e - 1)
                .collect(Collectors.toList());

        Consumer<List<Integer>> printList = list -> list.forEach(s -> System.out.printf("%d ", s));

        while (!input.equals("end")) {

            switch (input) {
                case "add":
                    numList = addList.apply(numList);
                    break;
                case "multiply":
                    numList = multiplyList.apply(numList);
                    break;
                case "subtract":
                    numList = subtractList.apply(numList);
                    break;
                case "print":
                    printList.accept(numList);
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
