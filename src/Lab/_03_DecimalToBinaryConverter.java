package Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _03_DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> binary = new ArrayDeque<>();

        if (n == 0){
            System.out.println(0);
            return;
        }

        while (n != 0) {

            binary.push(String.valueOf(n % 2));
            n = n / 2;
        }

        while (!binary.isEmpty()){
            System.out.print(binary.pop());
        }
    }
}
