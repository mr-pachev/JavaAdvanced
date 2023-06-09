package Demo_08_Exercise;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numLines = Integer.parseInt(scanner.nextLine());
        Box<Integer> box = new Box<>(0);

        for (int currentRow = 1; currentRow <= numLines; currentRow++) {
           int input = Integer.parseInt(scanner.nextLine());
            box.addElement(input);
        }
        int firstIndex = scanner.nextInt();
        int secondIndex = scanner.nextInt();
        scanner.nextLine();

        box.swap(firstIndex, secondIndex);
        System.out.println(box.toString());
    }
}
