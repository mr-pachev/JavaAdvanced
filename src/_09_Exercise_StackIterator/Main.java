package _09_Exercise_StackIterator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Stack<Integer> stack = new Stack<>();

        while (!input.equals("END")) {
            String[] inputData = input.split("[\\s+,]+");


                switch (inputData[0]){
                    case "Push":
                        for (int i = 1; i < inputData.length; i++) {
                            stack.puch(Integer.parseInt(inputData[i]));
                        }
                        break;
                    case "Pop":
                        stack.pop();
                        break;
            }

            input = scanner.nextLine();
        }

        stack.printStack();
    }
}
