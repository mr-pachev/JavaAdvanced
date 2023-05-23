package Exercise._02_Exerc;

import java.util.Scanner;

public class _02_MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int row = scanner.nextInt();
        int col = scanner.nextInt();

        int[][] matrix = new int[row][col];

        isFillMatrix(matrix, scanner);

        int maxSum = Integer.MIN_VALUE;
        int[][] winMatrix = new int[3][3];
        int currentSum = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i <= matrix.length - 3 && j <= matrix[i].length - 3) {
                    currentSum = isSumMatrix(matrix, i, j);
                    if (currentSum > maxSum) {
                        maxSum = currentSum;
                        isFillWinMatrix(matrix, winMatrix, i, j);
                    }
                }
            }
        }
        System.out.printf("Sum = %d%n", maxSum);
        printMatrix(winMatrix);
    }

    public static void isFillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
    }

    public static void isFillWinMatrix(int[][] matrix, int[][] winMatrix, int startRow, int startCol) {

        int endRow = startRow + 3;
        int endCol = startCol + 3;
        for (int row = startRow,  i = 0; row < endRow; row++, i++) {
            for (int col = startCol, j = 0; col < endCol; col++, j++) {
                winMatrix[i][j] = matrix[row][col];
            }
        }
    }

    //сумиране на елементите в матрица 3x3
    public static int isSumMatrix(int[][] matrix, int startRow, int startCol) {
        int sum = 0;
        int endRow = startRow + 3;
        int endCol = startCol + 3;
        for (int row = startRow; row < endRow; row++) {
            for (int col = startCol; col < endCol; col++) {
                sum += matrix[row][col];
            }
        }
        return sum;
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println(); //свали курсора на следващия ред
        }
    }
}
