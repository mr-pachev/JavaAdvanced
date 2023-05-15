package Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _02_StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int rotate = Integer.parseInt(input.split("[\\(|\\)]")[1]);

        input = scanner.nextLine();
        int sumRow = 0;                                         //определя броя на редовете за матрицата
        int maxLength = 0;                                      //определяне броя на колоните за матрицата
        List<String> inputData = new ArrayList<>();             //съдържа всички думи на матрицата

        while (!input.equals("END")) {
            sumRow++;

            //определя броя на колоните
            if (input.length() > maxLength) {
                maxLength = input.length();
            }

            inputData.add(input);
            input = scanner.nextLine();
        }

        char[][] matrix = new char[sumRow][maxLength];

        fillMatrix(matrix, inputData);                          //пълнене на матрицата

        int countRotation = rotate / 90;

        char[][] resultMatrix = new char[sumRow][maxLength];    //матрица, която ще съдържа n-пъти превъртяната matrix
        for (int i = 0; i < sumRow; i++) {
            resultMatrix[i] = matrix[i].clone();
        }

        for (int i = 1; i <= countRotation; i++) {              //определя колко пъти ще завъртаме матрицата, като редовете се сменят с броя колони
            int currentRow = resultMatrix.length;
            int currentCol = resultMatrix[currentRow - 1].length;
            resultMatrix = isRotate(resultMatrix, currentRow, currentCol);
        }
        printMatrix(resultMatrix);
    }

    private static void fillMatrix(char[][] matrix, List<String> list) {
        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length; col++) {
                if (col < list.get(row).length()) {
                    matrix[row][col] = list.get(row).toCharArray()[col];
                } else {
                    matrix[row][col] = ' ';
                }
            }

        }
    }

    //при 90 градуса ротация
    public static char[][] isRotate(char[][] matrix, int i, int j) {
        char[][] rotateMatrix = new char[j][i];
        for (int col = 0; col < j; col++) {
            int count = -1;                 //помага за новото запълване на колоните на матрицата
            for (int row = matrix.length - 1; row >= 0; row--) {
                count++;
                rotateMatrix[col][count] = matrix[row][col];
            }
        }
        return rotateMatrix;
    }

    //принтиран на матрица
    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println(); //свали курсора на следващия ред
        }
    }

}
