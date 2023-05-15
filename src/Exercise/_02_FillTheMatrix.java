package Exercise;

import java.util.Scanner;

public class _02_FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int n = Integer.parseInt(input.split(", ")[0]);
        String type = input.split(", ")[1];

        int[][] matrix = new int[n][n];

        if (type.equals("A")){
            isTypeA(matrix, n);
        }
        if (type.equals("B")){
            isTypeB(matrix, n);
        }
        System.out.println();
    }

    public static void isTypeA(int[][] matrix, int n) {
        int currentNumElement = 0;

        for (int col = 0; col < matrix[0].length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                currentNumElement++;
                matrix[row][col] = currentNumElement;
            }
        }
    }

    public static void isTypeB(int[][] matrix, int n) {
        int currentNumElement = 0;

        for (int col = 0; col < matrix[0].length; col++) {

            if ((col - 1) % 2 != 0){
                for (int row = 0; row < matrix.length; row++) {
                    currentNumElement++;
                    matrix[row][col] = currentNumElement;
                }
            }else {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    currentNumElement++;
                    matrix[row][col] = currentNumElement;
                }
            }

        }
    }
}
