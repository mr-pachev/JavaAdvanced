package Lab;

import java.util.Scanner;

public class _02_IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int row = Integer.parseInt(scanner.nextLine());
        int colum = Integer.parseInt(scanner.nextLine());

        String[][] firstMatrix = new String[row][colum];

        for (int i = 0; i < row; i++) {
            String currentColum = scanner.nextLine();
            for (int j = 0; j < colum; j++) {
                firstMatrix[i][j] = currentColum.split(" ")[j];
            }
        }

        String[][] secondMatrix = new String[row][colum];

        for (int i = 0; i < row; i++) {
            String currentColum = scanner.nextLine();
            for (int j = 0; j < colum; j++) {
                secondMatrix[i][j] = currentColum.split(" ")[j];
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colum; j++) {
                if (firstMatrix[i][j].equals(secondMatrix[i][j])) {
                    System.out.printf("%s ", firstMatrix[i][j]);
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }

    }
}
