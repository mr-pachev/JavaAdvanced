package Lab._05_Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _05_CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> textList = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        List<String> upperCaseWordsList = new ArrayList<>();

        Predicate<String> isUpperCase = word -> {
            char firstLetter = word.charAt(0);
            return Character.isUpperCase(firstLetter);
        };

        for (String s : textList) {
            if (isUpperCase.test(s)) {
                upperCaseWordsList.add(s);
            }
        }

        System.out.println(upperCaseWordsList.size());
        upperCaseWordsList.forEach(s -> System.out.println(s));
    }
}
