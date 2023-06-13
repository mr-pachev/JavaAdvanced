package Exams;

import java.util.Scanner;

public class Armory_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowAndColum = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[rowAndColum][];

        for (int rows = 0; rows < matrix.length; rows++) {
            matrix[rows] = scanner.nextLine().split("");
        }

        int counterPaid = 0;
        boolean isExit = false;

        int currentRowA = -1;
        int currentColA = -1;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col].equals("A")) {
                    currentRowA = row;
                    currentColA = col;
                }
            }
        }

        int newRowA = currentRowA;
        int newColA = currentColA;

        int rowM1 = -1;
        int colM1 = -1;

        int rowM2 = -1;
        int colM2 = -1;

        if (isExistM(matrix)) {     //ако има огледала взима кординатите им
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix.length; col++) {
                    if (matrix[row][col].equals("M") && rowM1 == -1) {
                        rowM1 = row;
                        colM1 = col;
                    }
                }
            }
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix.length; col++) {
                    if (matrix[row][col].equals("M") && rowM1 != -1) {
                        rowM2 = row;
                        colM2 = col;
                    }
                }
            }
        }

        String command = scanner.nextLine();

        while (true) {

            switch (command) {
                case "up":
                    newRowA--;
                    break;
                case "down":
                    newRowA++;
                    break;
                case "left":
                    newColA--;
                    break;
                case "right":
                    newColA++;
                    break;
            }

            matrix[currentRowA][currentColA] = "-";

            if (!isValid(matrix, newRowA, newColA)) {
                isExit = true;
                break;
            }

            currentRowA = newRowA;
            currentColA = newColA;

            if (isDigit(matrix[newRowA][newColA])) {          //ако новата позиция е попаднал на меч за купуване
                counterPaid += Integer.parseInt(matrix[newRowA][newColA]);
                matrix[newRowA][newColA] = "A";
            } else if (matrix[newRowA][newColA].equals("M")) { //ако новата позиция поподне на огледало
                matrix[newRowA][newColA] = "-";

                if (newRowA == rowM1 && newColA == colM1) {
                    currentRowA = rowM2;
                    currentColA = colM2;
                } else {
                    currentRowA = rowM1;
                    currentColA = colM1;
                }
                newRowA = currentRowA;
                newColA = currentColA;
                matrix[currentRowA][currentColA] = "A";
            }
            if (counterPaid >= 65){
                break;
            }
            command = scanner.nextLine();
        }

        if (isExit) {
            System.out.println("I do not need more swords!");
        } else {
            System.out.println("Very nice swords, I will come back for more!");
        }

        System.out.printf("The king paid %d gold coins.%n", counterPaid);
        printMatrix(matrix);

    }

    //метод за проверка дали има огледала в матрицата
    public static boolean isExistM(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col].equals("M")) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isValid(String[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix.length;
    }

    //метод за проверка дали string е число
    public static boolean isDigit(String string) {
        char ch = string.charAt(0);
        return Character.isDigit(ch);
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
