package Exercise._05_Exerc;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _05_ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       List<Integer> numList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

       int number = Integer.parseInt(scanner.nextLine());

        Collections.sort(numList);

        Predicate<Integer> isDivision = n -> n % number != 0;

        Function<List<Integer>, List<Integer>> divisionList = list -> {
           return list = list.stream().
                    filter(isDivision)
                    .collect(Collectors.toList());
        };

        Consumer<List<Integer>> printList = list -> list.forEach(s -> System.out.printf("%d ", s));

        printList.accept(divisionList.apply(numList));
    }
}
