package Exams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TreasureHunt_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int colum = scanner.nextInt();
        scanner.nextLine();

        String[][] matrix = new String[rows][colum];

        for (int row = 0; row < rows; row++) {
            String[] input = scanner.nextLine().split(" ");
            for (int col = 0; col < colum; col++) {
                //    matrix[row][col] = input[col];
                if (col < input.length) {
                    matrix[row][col] = input[col];
                } else {
                    matrix[row][col] = "-";
                }
            }
        }

        int currentRowY = -1;
        int currentColY = -1;

        int newRowY = -1;
        int newColY = -1;

        List<String> correctCommandsList = new ArrayList<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < colum; col++) {
                if (matrix[row][col].equals("Y")) {
                    currentRowY = row;
                    currentColY = col;
                }
            }
        }

        String command = scanner.nextLine();

        while (!command.equals("Finish")) {
            newRowY = currentRowY;
            newColY = currentColY;

            switch (command) {
                case "up":
                    newRowY--;
                    break;
                case "down":
                    newRowY++;
                    break;
                case "left":
                    newColY--;
                    break;
                case "right":
                    newColY++;
                    break;
            }

            if (!isValid(matrix, newRowY, newColY)) {
                newRowY = currentRowY;
                newColY = currentColY;
                command = scanner.nextLine();
                continue;
            }

            matrix[currentRowY][currentColY] = "-";         //старата позиция става "-"

            if (matrix[newRowY][newColY].equals("T")) {      //среща с дърво
                matrix[currentRowY][currentColY] = "Y";
                newRowY = currentRowY;
                newColY = currentColY;
                command = scanner.nextLine();
                continue;
            }

            if (matrix[newRowY][newColY].equals("X")){
                matrix[newRowY][newColY] = "X/Y";
            }else {
                matrix[newRowY][newColY] = "Y";
            }
            correctCommandsList.add(command);               //добавяне на коректна командо
            currentRowY = newRowY;
            currentColY = newColY;

            command = scanner.nextLine();
        }

        if (matrix[currentRowY][currentColY].equals("X/Y")){
            System.out.println("I've found the treasure!");
            System.out.print("The right path is ");
            System.out.print(correctCommandsList.toString().replaceAll("[\\[\\],]", "")
                    .replaceAll(" ", ", "));
        }else {
            System.out.println("The map is fake!");
        }
    }

    public static boolean isValid(String[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
    }
}
