package Lab._03_Lab;

import java.util.*;

public class _03_CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, List<String>>> continentsMap = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String[] inputData = scanner.nextLine().split(" ");

            String continent = inputData[0];
            String country = inputData[1];
            String city = inputData[2];

            if (!continentsMap.containsKey(continent)) {                                    //проверка дали континетна не е записан
                Map<String, List<String>> countriesMap = new LinkedHashMap<>();             //нов мап за държавите
                List<String> cityList = new ArrayList<>();                                  //нов лист за градовете

                cityList.add(city);
                countriesMap.put(country, cityList);
                continentsMap.put(continent, countriesMap);
            } else {
                Map<String, List<String>> countriesMap = continentsMap.get(continent);      //взимаме държавите от текущия континет

                if (!countriesMap.containsKey(country)) {                                   //проверка дали държавата не е записана
                    Map<String, List<String>> newCountries = new LinkedHashMap<>();         //нов мап за държавите
                    List<String> cityList = new ArrayList<>();                              //нов списък за градовете

                    cityList.add(city);
                    countriesMap.put(country, cityList);
                } else {
                    List<String> cityList = countriesMap.get(country);                      //взима градовете за текущата държава

                    cityList.add(city);
                    countriesMap.put(country, cityList);
                }
                continentsMap.put(continent, countriesMap);
            }
        }

        for (Map.Entry<String, Map<String, List<String>>> entry : continentsMap.entrySet()) {
            System.out.printf("%s:%n", entry.getKey());

            for (Map.Entry<String, List<String>> inerEntry : entry.getValue().entrySet()) {
                System.out.println("  " + inerEntry.getKey() + " -> " + String.join(", ", inerEntry.getValue())); //String.join->помага за принтирането на листа
            }

        }

    }
}
