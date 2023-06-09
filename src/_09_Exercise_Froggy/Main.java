package _09_Exercise_Froggy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Lake lake = new Lake();

        while (!input.equals("END")) {
            int[] inputNum = Arrays.stream(input.split("[\\s+,]+"))
                    .mapToInt(Integer::parseInt).toArray();

            for (int i = 0; i < inputNum.length; i++) {
                lake.addElement(inputNum[i]);
            }

            input = scanner.nextLine();
        }

        lake.printLake();

    }
}
