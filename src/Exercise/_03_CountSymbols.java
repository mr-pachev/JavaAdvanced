package Exercise;

import java.util.*;
import java.util.stream.Collectors;

public class _03_CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        char[] lettersList = input.toCharArray();

        Map<Character, Integer> symbolMap = new TreeMap<>();

        for (int i = 0; i < lettersList.length; i++) {

            if (!symbolMap.containsKey(lettersList[i])) {
                symbolMap.put(lettersList[i], 1);
            }else {
                symbolMap.put(lettersList[i], symbolMap.get(lettersList[i]) + 1);
            }
        }

        symbolMap.forEach((k,v) -> {
                    System.out.printf("%c: %d time/s%n", k, v);
                }
        );

    }
}
