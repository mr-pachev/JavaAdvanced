package Lab._03_Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _03_Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        numbers = numbers.stream()
                .sorted((s1, s2) -> s2.compareTo(s1))
                .collect(Collectors.toList());

        if (numbers.size() < 3){
            System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
        }else {
            for (int i = 0; i < 3; i++) {
                System.out.printf("%d ", numbers.get(i));
            }
        }
    }
}
