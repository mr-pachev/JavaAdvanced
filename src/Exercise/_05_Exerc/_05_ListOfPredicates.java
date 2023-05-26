package Exercise._05_Exerc;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _05_ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        BiPredicate<List<Integer>, Integer> isDivision = (list, a) -> {
            for (Integer s : list){
                if (a % s != 0){
                    return false;
                }
            }
            return  true;
        };

        for (int i = 1; i <= n; i++) {
            if (isDivision.test(numbersList, i)){
                System.out.print(i + " ");
            }
        }


    }
}
