package Lab._02_Lab;

import java.util.Scanner;

public class _02_MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int row = Integer.parseInt(input.split(", ")[0]);
        int colum = Integer.parseInt(input.split(", ")[1]);

        int[][] matrix = new int[row][colum];

        //пълнене на матрицата
        for (int i = 0; i < row; i++) {
            input = scanner.nextLine();
            for (int j = 0; j < colum; j++) {
                matrix[i][j] = Integer.parseInt(input.split(", ")[j]);
            }
        }
        //maxSum е първата 2x2 от матрицата
        int maxSum = matrix[0][0] + matrix[0][1] + matrix[1][0] + matrix[1][1];

        int currentRow = 0;     //конретния ред започва от първия ред
        int currentColum = 0;   //конретната колона започва от първата колона

        //обхождането на матрицата е събразено да има 2x2
        for (int i = 0; i < row - 1; i++) {
            for (int j = 0; j < colum - 1; j++) {
                int currentSum = matrix[i][j] + matrix[i][j + 1] + matrix[i + 1][j] + matrix[i + 1][j + 1];

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    currentRow = i;
                    currentColum = j;
                }
            }
        }
        System.out.printf("%d %d%n", matrix[currentRow][currentColum], matrix[currentRow][currentColum + 1]);
        System.out.printf("%d %d%n", matrix[currentRow + 1][currentColum], matrix[currentRow + 1][currentColum + 1]);
        System.out.println(maxSum);
    }
}
