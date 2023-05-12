package Lab;

import java.util.Scanner;

public class _02_PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowAndColum = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[rowAndColum][rowAndColum];

        //пълнене на матрицата
        for (int i = 0; i < rowAndColum; i++) {
            String digit = scanner.nextLine();
            for (int j = 0; j < rowAndColum; j++) {
                matrix[i][j] = Integer.parseInt(digit.split(" ")[j]);
            }
        }

        //принтеране първи диагонал
        for (int i = 0; i < rowAndColum; i++) {
            for (int j = 0; j < rowAndColum; j++) {
                if (i == j) {
                    System.out.print(matrix[i][j] + " ");
                }
            }
        }
        System.out.println();                                           //нов ред за втория диагонал

        //принтиране навтория диагонал
        for (int i = rowAndColum-1; i >= 0; i--) {                      //запчва от последния ред до достигане на първи ред
            for (int j = (rowAndColum-1) - i; j < rowAndColum; j++) {   //първата колона върви с промяната на редовете
                System.out.print(matrix[i][j] + " ");
                break;                                                  //след принтиране конретния елемент на колоната преминаваме на следващия ред
            }
        }

    }
}
