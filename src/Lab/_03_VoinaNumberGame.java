package Lab;

import java.util.*;

public class _03_VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstPlayerCards = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] secondPlayerCards = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Set<Integer> firstPlayerSet = new LinkedHashSet<>();
        isEntry(firstPlayerSet, firstPlayerCards);
        Set<Integer> secondPlayerSet = new LinkedHashSet<>();
        isEntry(secondPlayerSet, secondPlayerCards);

        int round = 0;

        while (!firstPlayerSet.isEmpty() && !secondPlayerSet.isEmpty() && round <= 50) {

            int cardFirstPlayer = firstPlayerSet.iterator().next();
            int cardSecondPlayer = secondPlayerSet.iterator().next();

            if (cardFirstPlayer > cardSecondPlayer) {
                //премахване на текущата карта от всяко тесте
                firstPlayerSet.remove(cardFirstPlayer);
                secondPlayerSet.remove(cardSecondPlayer);

                //добавяне в тестето на печелившия играч
                firstPlayerSet.add(cardFirstPlayer);      //добавя се първо печелившата карта
                firstPlayerSet.add(cardSecondPlayer);
            } else {
                //премахване на текущата карта от всяко тесте
                firstPlayerSet.remove(cardFirstPlayer);
                secondPlayerSet.remove(cardSecondPlayer);

                //добавяне в тестето на печелившия играч
                secondPlayerSet.add(cardSecondPlayer);      //добавя се първо печелившата карта
                secondPlayerSet.add(cardFirstPlayer);
            }
            round++;
        }

        if (firstPlayerSet.size() > secondPlayerSet.size()) {
            System.out.println("First player win!");
        } else if (firstPlayerSet.size() < secondPlayerSet.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }

    }

    //пълним Set-а
    public static void isEntry(Set<Integer> current, int[] array) {
        for (int i = 0; i < array.length; i++) {
            current.add(array[i]);
        }
    }
}
