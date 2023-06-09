package _09_Exercise_ListyIterator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ListyIterator listyIterator = new ListyIterator();

        while (!input.equals("END")) {
            String[] inputData = input.split(" ");

            switch (inputData[0]) {
                case "Create":
                    if (inputData.length > 1) {
                        for (int i = 1; i < inputData.length; i++) {
                            listyIterator.addElement(inputData[i]);
                        }
                    } else {
                        listyIterator = new ListyIterator();
                    }
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Print":
                    listyIterator.print();
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
            }
            input = scanner.nextLine();
        }

    }
}
