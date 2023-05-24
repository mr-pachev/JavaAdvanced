package Lab._05_Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _05_SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> numList = Arrays.stream(scanner.nextLine().split(", "))
                                      .map(n -> Integer.parseInt(n))
                                       .collect(Collectors.toList());

        Function<List<Integer>, Integer> sumCount = num -> {
            int count = 0;
            for (int n : numList){
                count += n;
            }
            return count;
        };

        System.out.printf("Count = %d%n", numList.size());
        System.out.printf("Sum = %d%n", sumCount.apply(numList));
    }
}
