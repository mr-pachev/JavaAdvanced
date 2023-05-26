package Exercise._05_Exerc;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _05_FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> getSmallestNum = list -> list.stream()
                .mapToInt(e -> e)
                .min()
                .getAsInt();

        int smallest = getSmallestNum.apply(numbersList);

        BiConsumer<List<Integer>, Integer> printList = (a,b) -> System.out.println(a.lastIndexOf(b));

        printList.accept(numbersList, smallest);
    }
}
