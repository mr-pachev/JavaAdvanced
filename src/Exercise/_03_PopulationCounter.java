package Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class _03_PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Integer>> countryMap = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("report")) {
            String[] inputData = input.split("\\|");

            String country = inputData[1];
            String city = inputData[0];
            int population = Integer.parseInt(inputData[2]);

            if (!countryMap.containsKey(country)) {                          //ако държавата я няма в мапа
                LinkedHashMap<String, Integer> cityMap = new LinkedHashMap<>();
                cityMap.put(city, population);
                countryMap.put(country, cityMap);

            } else {
                LinkedHashMap<String, Integer> cityMap = countryMap.get(country);     //взима вътрешния мап за дадената държава
                cityMap.put(city, population);
                countryMap.put(country, cityMap);
            }

            input = scanner.nextLine();
        }

        countryMap.entrySet().stream().sorted((e1, e2) -> {
            Long totalPopulationFirst = countryMap.get(e1.getKey()).entrySet().stream().mapToLong(Map.Entry::getValue).sum();
            Long totalPopulationSecond = countryMap.get(e2.getKey()).entrySet().stream().mapToLong(Map.Entry::getValue).sum();
            return Long.compare(totalPopulationSecond, totalPopulationFirst);
        }).forEach(entry -> {
            System.out.print(entry.getKey() + " ");

            StringBuilder builder = new StringBuilder();

            AtomicReference<Long> totalPopulation = new AtomicReference<>((long) 0);

            countryMap.get(entry.getKey()).entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                    .forEach(e -> {
                        builder.append(String.format("=>%s: %d%n", e.getKey(), e.getValue()));
                        totalPopulation.updateAndGet(v -> v + e.getValue());
                    });

            System.out.println(String.format("(total population: %s)", totalPopulation.toString()));
            System.out.print(builder.toString());
        });
    }
}
