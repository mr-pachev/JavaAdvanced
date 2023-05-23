package Exercise._03_Exerc;

import java.util.*;

public class _03_HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Set<String>> playersCardsMap = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {
            Set<String> cardsSet = new LinkedHashSet<>();           //подсигурява дадения играч да има неповтарящи се карти
            String[] inputData = input.split("\\: ");
            String name = inputData[0];
            String[] cardsArr = inputData[1].split(", ");

            if (!playersCardsMap.containsKey(name)) {
                cardsSet.addAll(Arrays.asList(cardsArr));
                playersCardsMap.put(name, cardsSet);
            } else {
                playersCardsMap.get(name).addAll(Arrays.asList(cardsArr));
                playersCardsMap.put(name, playersCardsMap.get(name));
            }
            input = scanner.nextLine();
        }

        playersCardsMap.entrySet().forEach(entry -> {
            String name = entry.getKey();
            Set<String> current = entry.getValue();
            System.out.printf("%s: %d%n", name, isSummation(current));
        });
    }

//пресмята сумата на всеки конкретен играч според уникалните му карти
    public static int isSummation(Set<String> currentSet) {
        Map<String, Integer> symbolMap = templateMap();             //взимаме мапа с символите и конкретната им стойност

        int sum = 0;
        for (String s : currentSet) {                               //обхождаме картите на дадения играч
            if (s.startsWith("10")) {                               //ако картата започва с 10
                int type = symbolMap.get(s.split("")[2]);
                int power = 10 * type;
                sum += power;
            } else {                                                //всибки други случаи
                int power = symbolMap.get(s.split("")[0]);    //взимаме стойността на дадения елемент от мапа със символи и стойности
                int type = symbolMap.get(s.split("")[1]);     //взимаме стойността на дадения елемент от мапа със символи и стойности
                sum += (power * type);
            }
        }
        return sum;
    }

    //пълним си мап с даден символ и съответната му стойност
    public static Map<String, Integer> templateMap() {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("2", 2);
        map.put("3", 3);
        map.put("4", 4);
        map.put("5", 5);
        map.put("6", 6);
        map.put("7", 7);
        map.put("8", 8);
        map.put("9", 9);
        map.put("J", 11);
        map.put("Q", 12);
        map.put("K", 13);
        map.put("A", 14);
        map.put("C", 1);
        map.put("D", 2);
        map.put("H", 3);
        map.put("S", 4);
        return map;
    }

}
