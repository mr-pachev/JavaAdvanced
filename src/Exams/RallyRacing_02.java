package Exams;

import java.util.Scanner;

public class RallyRacing_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowAndColum = Integer.parseInt(scanner.nextLine());
        String numCar = scanner.nextLine();

        boolean isFinished = false;

        //кординати на тунела-> вход/изход
        int rowT1 = 0;
        int colT1 = 0;

        int rowT2 = 0;
        int colT2 = 0;

        String[][] matrix = new String[rowAndColum][rowAndColum];

        //пълнене на матрицата
        for (int row = 0; row < rowAndColum; row++) {
            String[] inputRow = scanner.nextLine().split("\\s+");
            matrix[row] = inputRow;
        }

        //взимане кординатите на тунела
        for (int row = 0; row < rowAndColum; row++) {
            for (int col = 0; col < rowAndColum; col++) {
                if (matrix[row][col].equals("T")) {
                    if (rowT1 == 0 && colT1 == 0) {
                        rowT1 = row;
                        colT1 = col;
                    }
                    rowT2 = row;
                    colT2 = col;
                }
            }
        }

        int currentRow = 0;
        int currentCol = 0;
        matrix[currentRow][currentCol] = "C";
        String input = scanner.nextLine();

        int kmPass = 0;

        while (!input.equals("End")) {
            matrix[currentRow][currentCol] = ".";       //старата позиция става "."

            switch (input) {
                case "up":
                    currentRow--;
                    break;
                case "down":
                    currentRow++;
                    break;
                case "left":
                    currentCol--;
                    break;
                case "right":
                    currentCol++;
                    break;
            }

            //нова позиция
            if (matrix[currentRow][currentCol].equals("T")) {
                matrix[currentRow][currentCol] = ".";
                kmPass += 30;

                //проверка кои кординати са вход и кои изход
                if (currentRow == rowT1 && currentCol == colT1) {
                    currentRow = rowT2;
                    currentCol = colT2;
                } else if (currentRow == rowT2 && currentCol == colT2) {
                    currentRow = rowT1;
                    currentCol = colT1;
                }
                matrix[currentRow][currentCol] = "C";

            } else if (matrix[currentRow][currentCol].equals("F")) {
                kmPass += 10;
                isFinished = true;
                matrix[currentRow][currentCol] = "C";
                break;
            } else {
                kmPass += 10;
                matrix[currentRow][currentCol] = "C";
            }

            input = scanner.nextLine();
        }

        //принтиране
        if (isFinished) {
            System.out.printf("Racing car %s finished the stage!%n", numCar);
        } else {
            System.out.printf("Racing car %s DNF.%n", numCar);
        }

        System.out.printf("Distance covered %s km.%n", kmPass);
        printMatrix(matrix);

    }

    //метод за принтиране на матрицата
    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + "");
            }
            System.out.println();
        }
    }
}
