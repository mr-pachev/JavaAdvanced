package _08_Exercise_GenericBoxOfInteger;

import _08_Exercise_GenericBox.Box;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            int input = Integer.parseInt(scanner.nextLine());
            Box<Integer> box = new Box<>(input);
            System.out.println(box.toString());
        }
    }
}
