package Exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class _01_MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            int commandNum = scanner.nextInt();

            if (commandNum == 1) {
                int element = scanner.nextInt();
                stack.push(element);
            } else if (commandNum == 2) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (commandNum == 3) {
                System.out.println(Collections.max(stack));
            }
        }

    }
}
