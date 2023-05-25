package Lab._05_Lab;

import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class _05_FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startBound = scanner.nextInt();
        int endBound = scanner.nextInt();
        scanner.nextLine();                                     //скенера трябва да слезе на нов ред

        String oddOrEvent = scanner.nextLine();

        Predicate<Integer> isEvent = s -> s % 2 == 0;           //проверка дали числото е четно
        Predicate<String> isEvenCommand = s -> s.equals("even");

        printBound(startBound, endBound, isEvent, isEvenCommand, oddOrEvent);

    }

    public static void printBound(int start, int end, Predicate<Integer> isEvent, Predicate<String> isEvenCommand, String oddOrEvent) {

        for (int i = start; i <= end; i++) {
            if (isEvenCommand.test(oddOrEvent) && isEvent.test(i)) {
                System.out.print(i + " ");
            } else if (!isEvenCommand.test(oddOrEvent) && !isEvent.test(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
