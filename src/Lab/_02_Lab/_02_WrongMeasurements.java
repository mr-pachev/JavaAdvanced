package Lab._02_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _02_WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int row = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[row][];
        int[][] changeMatrix = new int[row][];

        //запълване на матрицата със зададени само брой редове
        for (int i = 0; i < row; i++) {
            int[] columElements = Arrays.stream(scanner.nextLine()
                                  .split(" "))
                                  .mapToInt(Integer::parseInt)
                                  .toArray();

            matrix[i] = columElements;
        }

        for (int i = 0; i < row; i++) {
            changeMatrix[i] = matrix[i].clone();
        }

        int wrongValueRow = scanner.nextInt();
        int wrongValueColum = scanner.nextInt();

        int wrongValue = matrix[wrongValueRow][wrongValueColum];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int sum = 0;

                if (matrix[i][j] == wrongValue) {                                       //проверка дали дадения елемент съпвада с грешни
                    changeMatrix[i][j] = isSum(matrix, i, j, wrongValue);
                }
            }
        }
        for (int i = 0; i < changeMatrix.length; i++) {
            for (int j = 0; j < changeMatrix[i].length; j++) {
                System.out.printf("%d ", changeMatrix[i][j]);
            }
            System.out.println();
        }
    }
    public static int isSum (int[][] matrix ,int row, int colum, int wrongDigit){
        int sum = 0;
        if (row - 1 >= 0 && matrix[row - 1][colum] != wrongDigit){                      //не е първи ред и горното число не е грешно
            sum += matrix[row - 1][colum];
        }
        if (row + 1 < matrix.length && matrix[row + 1][colum] != wrongDigit){           //не е последен ред и долното число не е грешно
            sum += matrix[row + 1][colum];
        }
        if (colum - 1 >= 0 && matrix[row][colum - 1] != wrongDigit){                    //не е първа колона и лявото число не е грешно
            sum += matrix[row][colum - 1];
        }
        if (colum + 1 < matrix[row].length && matrix[row][colum + 1] != wrongDigit){     //не е последна колона и дясното число не е грешно
            sum += matrix[row][colum + 1];
        }
        return sum;
    }
}
