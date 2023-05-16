package Exercise;

import java.util.Scanner;

public class _02_Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int rowInput = Integer.parseInt(input.split(" ")[0]);
        int colInput = Integer.parseInt(input.split(" ")[1]);

        String[][] matrix = new String[rowInput][colInput];

        fillMatrix(matrix);

        input = scanner.nextLine();

        while (!input.equals("Nuke it from orbit")) {
            int rowLength = Integer.parseInt(input.split(" ")[0]);
            int colLength = Integer.parseInt(input.split(" ")[1]);
            int radius = Integer.parseInt(input.split(" ")[2]);

            removeElementColLeft(matrix, rowLength, colLength, radius);
            removeElementColRight(matrix, rowLength, colLength, radius);
            removeElementRowUp(matrix, rowLength, colLength, radius);
            removeElementRowDown(matrix, rowLength, colLength, radius);

            input = scanner.nextLine();
        }
        printMatrix(matrix);
    }

    private static void fillMatrix(String[][] matrix) {
        int element = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                element++;
                matrix[row][col] = "" + element;
            }
        }
    }

    public static void removeElementColLeft(String[][] matrix, int pointRow, int pointCol, int radius) {
        int currentCol = pointCol;
        while (currentCol >= pointCol - radius && currentCol >= 0) {
            matrix[pointRow][currentCol] = " ";
            currentCol--;
        }
    }

    public static void removeElementColRight(String[][] matrix, int pointRow, int pointCol, int radius) {
        int currentCol = pointCol;
        while (currentCol <= pointCol + radius && currentCol < matrix[pointRow].length) {
            matrix[pointRow][currentCol] = " ";
            currentCol++;
        }
    }

    public static void removeElementRowUp(String[][] matrix, int pointRow, int pointCol, int radius) {
        int currentRow = pointRow;
        while (currentRow >= pointRow - radius && currentRow >= 0) {
            matrix[currentRow][pointCol] = " ";
            currentRow--;
        }
    }

    public static void removeElementRowDown(String[][] matrix, int pointRow, int pointCol, int radius) {
        int currentRow = pointRow;
        while (currentRow <= pointRow + radius && currentRow < matrix.length) {
            matrix[currentRow][pointCol] = " ";
            currentRow++;
        }
    }

    //принтиран на матрица
    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println(); //свали курсора на следващия ред
        }
    }
}