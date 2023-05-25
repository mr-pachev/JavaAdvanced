package Exams;

import java.util.Scanner;

public class TheSquirrel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowAndCol = Integer.parseInt(scanner.nextLine());
        String[] directions = scanner.nextLine().split(", ");

        String[][] matrix = new String[rowAndCol][];
        int countHazelnut = 0;

        //пълним матрицата
        for (int row = 0; row < matrix.length; row++) {
            String[] currentRowInput = scanner.nextLine().split("");
            matrix[row] = currentRowInput;
        }

        int rowS = isSquirrelPosition(matrix)[0];
        int colS = isSquirrelPosition(matrix)[1];
        boolean isNotCollected = true;

        //обхождаме посоките
        for (int direction = 0; direction < directions.length; direction++) {
            String currentDirection = directions[direction];

            switch (currentDirection) {
                case "up":
                    rowS--;
                    break;
                case "down":
                    rowS++;
                    break;
                case "left":
                    colS--;
                    break;
                case "right":
                    colS++;
                    break;
            }

            if (isNotValid(matrix, rowS, colS)) {        //ако катерицата е извън полето
                System.out.println("The squirrel is out of the field.");
                isNotCollected = false;
                break;

            } else {
                if (matrix[rowS][colS].equals("t")) {    //ако катерицата попадне на капан
                    System.out.println("Unfortunately, the squirrel stepped on a trap...");
                    isNotCollected = false;
                    break;
                } else if (matrix[rowS][colS].equals("h")) {
                    countHazelnut++;
                }
            }

            if (countHazelnut >= 3) {                    //проверка дали катерицата е събрала 3 лешника
                System.out.println("Good job! You have collected all hazelnuts!");
                isNotCollected = false;
                break;
            }
        }
        if (isNotCollected) {                             //проверка дали катерицата е минала през полето, но не е успяла да събере лешниците
            System.out.println("There are more hazelnuts to collect.");
            System.out.printf("Hazelnuts collected: %d", 3 - countHazelnut);
        }else {
            System.out.printf("Hazelnuts collected: %d", countHazelnut);
        }

    }

    //определя стартовата позиция на катерицата
    public static int[] isSquirrelPosition(String[][] matrix) {
        int[] squirrelPosition = new int[2];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col].equals("s")) {
                    squirrelPosition[0] = row;
                    squirrelPosition[1] = col;
                    break;
                }
            }
        }
        return squirrelPosition;
    }

    //валидация на бъдещата позиция
    public static boolean isNotValid(String[][] matrix, int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix.length;
    }
}
