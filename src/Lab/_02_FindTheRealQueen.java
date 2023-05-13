package Lab;

import java.util.Scanner;

public class _02_FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] matrix = new String[8][];

        //запълване на матрицата
        for (int i = 0; i < matrix.length; i++) {
            String[] symbols = scanner.nextLine().split(" ");
            matrix[i] = symbols;
        }

        String queen = "q";
        //кординати на печелившата кралица
        int bestRow = 0;
        int bestColum = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                String currentSymbol = matrix[i][j];

                if (currentSymbol.equals(queen)) {                              //при наличие на кралица
                    if (isVertical(i, j, matrix)) {                            //проверява по вертикала
                        break;
                    }
                    if (isHorizontal(i, j, matrix)) {                          //проверява по хоризонтала
                        break;
                    }

                    String rowAndColum = isStartDiagonal(i, j, matrix);
                    int startRow = Integer.parseInt(rowAndColum.split("")[0]);
                    int startColum = Integer.parseInt(rowAndColum.split("")[1]);

                    if (isLeftDiagonal(startRow, startColum, i, matrix)) {     //проверява по левия диагонал
                        break;
                    }

                    rowAndColum = isStartDiagonalRight(i, j, matrix);
                    startRow = Integer.parseInt(rowAndColum.split("")[0]);
                    startColum = Integer.parseInt(rowAndColum.split("")[1]);

                    if (isRightDiagonal(startRow, startColum, i, matrix)) {      //проверява по десен диагонал
                        break;
                    }
                    bestRow = i;
                    bestColum = j;
                }
            }
        }

        System.out.printf("%d %d", bestRow, bestColum);

    }

    //метод проверка по вертикала
    public static boolean isVertical(int row, int colum, String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            String currentSymbol = matrix[i][colum];

            if (i != row) {
                if (currentSymbol.equals("q")) {
                    return true;
                }
            }
        }
        return false;
    }

    //метод проверка по хоризонтала
    public static boolean isHorizontal(int row, int colum, String[][] matrix) {
        for (int j = 0; j < matrix[row].length; j++) {
            String currentSymbol = matrix[row][j];

            if (j != colum) {
                if (currentSymbol.equals("q")) {
                    return true;
                }
            }
        }
        return false;
    }

    //метод проверка по ляв диагонал
    public static boolean isLeftDiagonal(int row, int colum, int currentRow, String[][] matrix) {
        int count = 0;
        for (int i = row; i < matrix.length; i++) {

            for (int j = colum + count; j < matrix[i].length; j++) {
                String currentSymbol = matrix[i][j];

                if (i != currentRow) {
                    if (currentSymbol.equals("q")) {
                        return true;
                    }
                }
                count++;
                break;
            }
        }
        return false;
    }

    //метод проверка по десен диагонал
    public static boolean isRightDiagonal(int row, int colum, int currentRow, String[][] matrix) {
        int count = 0;
        for (int i = matrix.length - 1; i >= 0; i--) {

            for (int j = colum + count; j < matrix[i].length; j++) {
                String currentSymbol = matrix[i][j];

                if (i != currentRow) {
                    if (currentSymbol.equals("q")) {
                        return true;
                    }
                }
                count++;
                break;
            }
        }
        return false;
    }

    //определя началото на ляв диагонал
    public static String isStartDiagonal(int row, int colum, String[][] matrix) {
        int startRow = row;
        int startColum = colum;
        String rowAndColum = "" + row + colum;

        if (row == 0) {
            return rowAndColum;
        }
        if (colum == 0) {
            return rowAndColum;
        }

        while (startRow > 0 && startColum > 0) {
            startRow--;
            startColum--;
            rowAndColum = "" + startRow + startColum;
        }
        return rowAndColum;
    }

    //определя началото на десен диагонал
    public static String isStartDiagonalRight(int row, int colum, String[][] matrix) {
        int startRow = row;
        int startColum = colum;
        String rowAndColum = "" + row + colum;

        if (row == matrix.length - 1) {
            rowAndColum = "" + (matrix.length - 1) + colum;
            return rowAndColum;
        }
        if (colum == matrix.length - 1) {
            rowAndColum = "" + row + (matrix.length - 1);
            return rowAndColum;
        }

        while (startRow < matrix.length - 1 && startColum > 0) {
            startRow++;
            startColum--;
            rowAndColum = "" + startRow + startColum;
        }
        return rowAndColum;
    }
}