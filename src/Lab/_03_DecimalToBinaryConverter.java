package Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _03_DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> binary = new ArrayDeque<>();
        int decimal;

        while (n > 0) {
            decimal = n % 2;
            n = n / 2;
            binary.push("" + decimal);
        }

        while (!binary.isEmpty()){
            System.out.print(binary.pop());
        }
    }
}
