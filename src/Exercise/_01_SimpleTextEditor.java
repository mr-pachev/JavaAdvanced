package Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _01_SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        StringBuilder text = new StringBuilder();
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            String command = input.split("\\s+")[0];

            if (command.equals("1")) {
                String currentText = input.split("\\s+")[1];
                text.append(currentText);
                stack.push(text.toString());

            } else if (command.equals("2")) {
                int sumErase = Integer.parseInt(input.split("\\s+")[1]);
                text.delete(text.length() - sumErase, text.length());
                stack.push(text.toString());

            } else if (command.equals("3")) {
                int index = Integer.parseInt(input.split("\\s+")[1]);
                System.out.println(text.charAt(index - 1));
            } else if (command.equals("4")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                text = new StringBuilder(stack.peek());
            }
        }
        
    }
}
