package Exams;

import java.util.Arrays;
import java.util.Scanner;

public class MouseInTheKitchen_02_Final {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputData = Arrays.stream(scanner.nextLine()
                        .split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = inputData[0];
        int colum = inputData[1];

        String[][] matrix = new String[rows][colum];

        for (int row = 0; row < rows; row++) {
            String[] input = scanner.nextLine().split("");
            for (int col = 0; col < colum; col++) {

                if (col < input.length) {
                    matrix[row][col] = input[col];
                } else {
                    matrix[row][col] = "*";
                }
            }
        }

        int currentRowM = -1;
        int currentColM = -1;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < colum; col++) {
                if (matrix[row][col].equals("M")) {
                    currentRowM = row;
                    currentColM = col;
                }
            }
        }

        int newRowM = currentRowM;
        int newColM = currentColM;

        String input = scanner.nextLine();

        while (!input.equals("danger")) {
            matrix[currentRowM][currentColM] = "*";

            switch (input) {
                case "up":
                    newRowM--;
                    break;
                case "down":
                    newRowM++;
                    break;
                case "right":
                    newColM++;
                    break;
                case "left":
                    newColM--;
                    break;
            }

            if (!isValid(matrix, newRowM, newColM)) {                         //проверка доли излиза от шкофо
                matrix[currentRowM][currentColM] = "M";
                System.out.println("No more cheese for tonight!");
                break;
            }

            if (matrix[newRowM][newColM].equals("C")) {
                matrix[newRowM][newColM] = "M";
                currentRowM = newRowM;
                currentColM = newColM;

            } else if (matrix[newRowM][newColM].equals("T")) {                //проверка доли попада в капан
                matrix[newRowM][newColM] = "M";
                System.out.println("Mouse is trapped!");
                break;

            } else if (matrix[newRowM][newColM].equals("@")) {                //проверка дали стига до стена
                newRowM = currentRowM;
                newColM = currentColM;
                matrix[newRowM][newColM] = "M";
            } else {
                matrix[newRowM][newColM] = "M";
                currentRowM = newRowM;
                currentColM = newColM;
            }

            if (!isExistCheese(matrix)) {
                System.out.println("Happy mouse! All the cheese is eaten, good night!");
                break;
            }

            input = scanner.nextLine();
        }
        if (isExistCheese(matrix) && input.equals("danger")) {
            System.out.println("Mouse will come back later!");
        }
        printMatrix(matrix);
    }

    public static boolean isValid(String[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
    }


    //метод за проверка дали в матрицата има сирене
    public static boolean isExistCheese(String[][] matrix) {
        boolean isExist = false;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("C")) {
                    isExist = true;
                    return isExist;
                }
            }
        }
        return isExist;
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
