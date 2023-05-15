package Exercise;

import java.util.Scanner;

public class _02_MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int row = scanner.nextInt();
        int col = scanner.nextInt();

        int[][] matrix = new int[row][col];

        isFillMatrix(matrix, scanner);

        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i <= matrix.length - 3 && j <= matrix[i].length - 3) {
                    currentSum = isSumMatrix(matrix, i, j);
                    if (currentSum >= maxSum) {
                        maxSum = currentSum;
                    }
                }
            }
        }
        System.out.printf("Sum = %d%n", maxSum);
        printMatrix(matrix);
    }

    public static void isFillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
    }

    //сумиране на елементите в матрица 3x3
    public static int isSumMatrix(int[][] matrix, int startRow, int startCol) {
        int sum = 0;
        for (int row = startRow; row < startRow + 3; row++) {
            for (int col = startCol; col < startCol + 3; col++) {
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
