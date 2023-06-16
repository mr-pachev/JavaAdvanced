package Exams;

import java.util.Scanner;

public class MouseAndCheese_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowAndColum = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[rowAndColum][rowAndColum];
        int currentRowM = -1;
        int currentColM = -1;

        int cheesesCount = 0;

        for (int row = 0; row < rowAndColum; row++) {
            String[] input = scanner.nextLine().split("");
            for (int col = 0; col < rowAndColum; col++) {
                //    matrix[row][col] = input[col];
                if (col < input.length) {
                    matrix[row][col] = input[col];
                } else {
                    matrix[row][col] = "-";
                }
            }
        }

        for (int row = 0; row < rowAndColum; row++) {
            for (int col = 0; col < rowAndColum; col++) {
                if (matrix[row][col].equals("M")) {
                    currentRowM = row;
                    currentColM = col;
                    break;
                }
            }
        }

        int newRowM = currentRowM;
        int newColM = currentColM;

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            matrix[currentRowM][currentColM] = "-";

            switch (input) {
                case "up":
                    newRowM--;
                    break;
                case "down":
                    newRowM++;
                    break;
                case "left":
                    newColM--;
                    break;
                case "right":
                    newColM++;
                    break;
            }

            if (!isValidPosition(matrix, newRowM, newColM)) {
                System.out.println("Where is the mouse?");
                break;
            }

            if (matrix[newRowM][newColM].equals("c")) {
                cheesesCount++;
                currentRowM = newRowM;
                currentColM = newColM;
            }else if (matrix[newRowM][newColM].equals("B")){
                matrix[newRowM][newColM] = "-";
                continue;
            }
            currentRowM = newRowM;
            currentColM = newColM;
            matrix[newRowM][newColM] = "M";
            input = scanner.nextLine();
        }

        if (cheesesCount < 5) {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheesesCount);
        } else {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheesesCount);
        }

        printMatrix(matrix);

    }

    public static boolean isValidPosition(String[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix.length;
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + "");
            }
            System.out.println();
        }
    }
}
