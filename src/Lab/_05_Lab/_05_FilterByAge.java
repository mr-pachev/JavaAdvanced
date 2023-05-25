package Lab._05_Lab;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class _05_FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> peopleMap = new LinkedHashMap<>();


        for (int i = 1; i <= n; i++) {
            String[] inputData = scanner.nextLine().split(", ");
            peopleMap.putIfAbsent(inputData[0], Integer.parseInt(inputData[1]));
        }

        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String printFormat = scanner.nextLine();

        Function<Map<String, Integer>, Map<String, Integer>> sortMap = map -> {   //функция за сортиране на днойностите на мап взависимост от condition
            if (condition.equals("older")) {
                map = peopleMap.entrySet().stream()
                        .filter(a -> a.getValue() >= age)
                        .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
            } else if (condition.equals("younger")) {
                map = peopleMap.entrySet().stream()
                        .filter(a -> a.getValue() <= age)
                        .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
            }
            return map;
        };

        Map<String, Integer> sortedPeopleMap = sortMap.apply(peopleMap);            //нов сортиран мап

        BiConsumer<Map<String, Integer>, String> printMap = (map, s) -> {
            if (printFormat.equals("name age")) {
                sortedPeopleMap.forEach((k, v) -> {
                    System.out.printf("%s - %d%n", k, v);
                });
            } else if (printFormat.equals("name")) {
                sortedPeopleMap.keySet().forEach(k -> System.out.println(k));
            } else if (printFormat.equals("age")) {
                sortedPeopleMap.values().forEach(v -> System.out.println(v));
            }
        };

        printMap.accept(sortedPeopleMap, condition);
    }
}
