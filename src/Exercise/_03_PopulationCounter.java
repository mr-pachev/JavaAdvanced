package Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _03_PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Integer>> countryMap = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while(!input.equals("report")){
            String[] inputData = input.split("\\|");

            String country = inputData[1];
            String city = inputData[0];
            int population = Integer.parseInt(inputData[2]);

            if (!countryMap.containsKey(country)){                          //ако държавата я няма в мапа
                LinkedHashMap<String, Integer> cityMap = new LinkedHashMap<>();
                cityMap.put(city, population);
                countryMap.put(country, cityMap);

            }else {
                LinkedHashMap<String, Integer> cityMap = countryMap.get(country);     //взима вътрешния мап за дадената държава
                cityMap.put(city, population);
                countryMap.put(country, cityMap);
            }

            input = scanner.nextLine();
        }

        System.out.println();
    }
}
