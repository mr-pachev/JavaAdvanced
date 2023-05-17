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
        //пълнене на първия Set
        for (int i = 0; i < firstPlayerCards.length; i++) {
            firstPlayerSet.add(firstPlayerCards[i]);
        }

        Set<Integer> secondPlayerSet = new LinkedHashSet<>();
        //пълнене на втория Set
        for (int i = 0; i < secondPlayerCards.length; i++) {
            secondPlayerSet.add(secondPlayerCards[i]);
        }


        for (int round = 1; round <= 50; round++) {             //играта е 50 рунда

            if (firstPlayerSet.isEmpty()) {                     //проверка дали първия играч има карти
                break;
            } else if (secondPlayerSet.isEmpty()) {             //проверка дали първия играч има карти
                break;
            }

            int cardFirstPlayer = firstPlayerSet.iterator().next();
            int cardSecondPlayer = secondPlayerSet.iterator().next();

            //премахване на текущата карта от всяко тесте
            firstPlayerSet.remove(cardFirstPlayer);
            secondPlayerSet.remove(cardSecondPlayer);

            if (cardFirstPlayer > cardSecondPlayer) {
                //добавяне в тестето на печелившия играч
                firstPlayerSet.add(cardFirstPlayer);              //добавя се първо печелившата карта
                firstPlayerSet.add(cardSecondPlayer);
            } else if (cardFirstPlayer < cardSecondPlayer){
                //добавяне в тестето на печелившия играч
                secondPlayerSet.add(cardFirstPlayer);
                secondPlayerSet.add(cardSecondPlayer);             //добавя се първо печелившата карта
            }
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
