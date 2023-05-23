package Exercise._02_Exerc;

import java.util.Arrays;
import java.util.Scanner;

public class _02_MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int row = scanner.nextInt();
        int col = scanner.nextInt();
        String[][] matrix = new String[row][col];

        fillMatrix(matrix, row, col);
        printMatrix(matrix);

    }

    private static void fillMatrix(String[][] matrix, int row, int col) {

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.println();
                char one = (char) (97 + i);
                char two = (char) (97 + i + j);
                char tree = (char) (97 + i);

                char[] currentElement = {one, two, tree};
                String element = String.valueOf(currentElement[0]) + String.valueOf(currentElement[1] + String.valueOf(currentElement[2]));
                matrix[i][j] = element;
            }
        }
    }
    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println(); //свали курсора на следващия ред
        }
    }
}
