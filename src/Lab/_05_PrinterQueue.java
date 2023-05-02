package Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _05_PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> docs = new ArrayDeque<>();

        while (!input.equals("print")) {

            if (input.equals("cancel")) {

                if (!docs.isEmpty()) {
                    System.out.println("Canceled " + docs.poll());
                } else {
                    System.out.println("Printer is on standby");
                }
                input = scanner.nextLine();
                continue;
            }

            docs.offer(input);
            input = scanner.nextLine();
        }

        while (docs.size() > 0){
            System.out.println(docs.poll());
        }
    }
}
