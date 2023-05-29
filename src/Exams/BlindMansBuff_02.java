package Exams;

import java.util.Scanner;

public class BlindMansBuff_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split(" ");

        }

        int rowB = -1;
        int colB = -1;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("B")) {
                    rowB = row;
                    colB = col;
                    break;
                }
            }
        }
        int rowOldB = rowB;
        int colOldB = colB;

        String input = scanner.nextLine();
        int countTouched = 0;
        int countMoves = 0;

        while (!input.equals("Finish") && countTouched < 3) {
            String command = input;

            switch (command) {
                case "up":
                    rowB--;
                    break;
                case "down":
                    rowB++;
                    break;
                case "left":
                    colB--;
                    break;
                case "right":
                    colB++;
                    break;
            }

            if (isValid(matrix, rowB, colB)) {

                if (matrix[rowB][colB].equals("P")) {
                    countMoves++;
                    countTouched++;
                    matrix[rowB][colB] = "B";
                } else if (matrix[rowB][colB].equals("O")) {
                    rowB = rowOldB;
                    colB = colOldB;
                    input = scanner.nextLine();
                    continue;
                } else if (matrix[rowB][colB].equals("-")) {
                    countMoves++;
                    matrix[rowB][colB] = "B";
                }
                matrix[rowOldB][colOldB] = "-";
                rowOldB = rowB;
                colOldB = colB;
            }

            input = scanner.nextLine();
        }
        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d%n", countTouched, countMoves);
    }

    public static boolean isValid(String[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
    }
}
