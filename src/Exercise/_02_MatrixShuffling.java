package Exercise;

import java.util.Scanner;

public class _02_MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String rowAndCol = scanner.nextLine();

        int row = Integer.parseInt(rowAndCol.split(" ")[0]);
        int col = Integer.parseInt(rowAndCol.split(" ")[1]);

        String[][] matrix = new String[row][col];

        fillMatrix(matrix, scanner);

        String input = scanner.nextLine();

        while (!input.equals("END")) {

            if (!isValid(input, matrix, row, col)) {
                System.out.println("Invalid input!");
            } else {
                int oldElementRow = Integer.parseInt(input.split("\\s+")[1]);
                int oldElementCol = Integer.parseInt(input.split("\\s+")[2]);
                String oldEl = matrix[oldElementRow][oldElementCol];

                int newElementRow = Integer.parseInt(input.split("\\s+")[3]);
                int newElementCol = Integer.parseInt(input.split("\\s+")[4]);
                String newEl = matrix[newElementRow][newElementCol];

                matrix[oldElementRow][oldElementCol] = newEl;
                matrix[newElementRow][newElementCol] = oldEl;
                printMatrix(matrix);
            }

            input = scanner.nextLine();
        }


    }

    //запълване на матрица от тип String
    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }

    public static boolean isValid(String input, String[][] matrix, int row, int col) {
        String[] inputData = input.split(" ");

        if (inputData.length != 5) {
            return false;
        }

        String word = inputData[0];
        int oldElementRow = Integer.parseInt(inputData[1]);
        int oldElementCol = Integer.parseInt(inputData[2]);

        int newElementRow = Integer.parseInt(inputData[3]);
        int newElementCol = Integer.parseInt(inputData[4]);

        if (!word.equals("swap")) {
            return false;
        } else if (oldElementRow < 0 || oldElementRow > row || oldElementCol < 0 || oldElementCol > col
                || newElementRow < 0 || newElementRow > row || newElementCol < 0 || newElementCol > col) {
            return false;
        }
        return true;
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
