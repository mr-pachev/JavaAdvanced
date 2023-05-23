package Lab._02_Lab;

import java.util.Scanner;

public class _02_PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int row = scanner.nextInt();
        int columns = scanner.nextInt();
        int[][] matrix = new int[row][columns];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < columns; j++) {
                int input = scanner.nextInt();
                matrix[i][j] = input;
            }
        }

        int digit = scanner.nextInt();
        boolean isEqual = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == digit) {
                    System.out.printf("%d %d%n", i, j);
                    isEqual = true;
                }
            }
        }

        if (!isEqual) {
            System.out.println("not found");
        }
    }
}
