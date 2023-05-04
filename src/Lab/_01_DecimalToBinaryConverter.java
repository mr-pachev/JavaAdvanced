package Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _01_DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> binary = new ArrayDeque<>();

        if (n == 0){   //проверка дали числото за конвертиране не е равно на нула
            System.out.println(0);
            return;
        }

        while (n != 0) {
            binary.push(String.valueOf(n % 2)); //добавяме остатъка(0 или 1)->запазва двойчното число отзад напред
            n = n / 2;  //сменя разликата на числото
        }

        while (!binary.isEmpty()){ //цикъл за принтиране на стека->полученото двойчно число отзад напред
            System.out.print(binary.pop());
        }
    }
}
