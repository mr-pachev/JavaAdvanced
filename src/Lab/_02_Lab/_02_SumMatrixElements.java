package Lab._02_Lab;

import java.util.Scanner;

public class _02_SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int row = Integer.parseInt(input.split(", ")[0]);
        int colum = Integer.parseInt(input.split(", ")[1]);
        int sum = 0;

        int[][] matrix = new int[row][colum];

        for (int i = 0; i < row; i++) {
            input = scanner.nextLine();
            for (int j = 0; j < colum; j++) {
                int current = Integer.parseInt(input.split(", ")[j]);
                matrix(row, colum, current);
                sum += current;
            }
        }
        System.out.println(row);
        System.out.println(colum);
        System.out.println(sum);
    }
    //метод за зъпълване на матрица от тип int
    public static int[][] matrix(int row, int colum, int insert){
        int[][] matrix = new int[row][colum];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colum; j++) {
                matrix[i][j] = insert;
            }
        }
       return matrix;
    }
}
