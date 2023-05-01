package Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _01_BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> url = new ArrayDeque<>();

        String input = scanner.nextLine();

        while (!input.equals("Home")) {

            if (input.equals("back")) {
                if (url.size() == 1) {
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                } else {
                    url.pop();
                }
            } else {
                url.push(input);
            }

            System.out.println(url.peek());
            input = scanner.nextLine();
        }

    }
}
