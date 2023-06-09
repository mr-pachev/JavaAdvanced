package Lab._02_Lab;

import java.util.Scanner;

public class _02_FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] matrix = new char[8][8];

        //запълване на матрицата
        for (int i = 0; i < matrix.length; i++) {
            String[] input = scanner.nextLine().split(" ");
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = input[j].charAt(0);
            }
        }

        char queen = 'q';
        //кординати на валидната кралица
        int bestRow = 0;
        int bestColum = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                char currentSymbol = matrix[i][j];

                if (currentSymbol == queen && isValid(i, j, matrix)) {        //при наличие на кралица
                    bestRow = i;
                    bestColum = j;
                }
            }
        }

        System.out.printf("%d %d", bestRow, bestColum);

    }

    //метод проверка по вертикала
    public static boolean isVertical(int row, int colum, char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            char currentSymbol = matrix[i][colum];

            if (i != row) {
                if (currentSymbol == 'q') {
                    return false;
                }
            }
        }
        return true;
    }

    //метод проверка по хоризонтала
    public static boolean isHorizontal(int row, int colum, char[][] matrix) {
        for (int j = 0; j < matrix.length; j++) {
            char currentSymbol = matrix[row][j];

            if (j != colum) {
                if (currentSymbol == 'q') {
                    return false;
                }
            }
        }
        return true;
    }

    //метод проверка по ляв диагонал
    public static boolean isLeftDiagonal(int row, int colum, int currentRow, char[][] matrix) {

        while (row < matrix.length - 1 && colum < matrix.length - 1) {
            row++;
            colum++;

            char currentSymbol = matrix[row][colum];

            if (row != currentRow) {
                if (currentSymbol == 'q') {
                    return false;
                }
            }

        }
        return true;
    }

    //метод проверка по десен диагонал
    public static boolean isRightDiagonal(int row, int colum, int currentRow, char[][] matrix) {

        while (row > 0 && colum < matrix.length - 1) {
            row--;
            colum++;

            char currentSymbol = matrix[row][colum];

            if (row != currentRow) {
                if (currentSymbol == 'q') {
                    return false;
                }
            }

        }
        return true;
    }

    //определя началото на ляв диагонал
    public static String isStartDiagonal(int row, int colum, char[][] matrix) {
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
    public static String isStartDiagonalRight(int row, int colum, char[][] matrix) {
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

    //проверка за валидност на кралицата
    public static boolean isValid(int i, int j, char[][] matrix) {
        if (!isVertical(i, j, matrix)) {                            //проверява по вертикала
            return false;
        }
        if (!isHorizontal(i, j, matrix)) {                          //проверява по хоризонтала
            return false;
        }

        String rowAndColum = isStartDiagonal(i, j, matrix);
        int startRow = Integer.parseInt(rowAndColum.split("")[0]);
        int startColum = Integer.parseInt(rowAndColum.split("")[1]);

        if (!isLeftDiagonal(startRow, startColum, i, matrix)) {     //проверява по левия диагонал
            return false;
        }

        rowAndColum = isStartDiagonalRight(i, j, matrix);
        startRow = Integer.parseInt(rowAndColum.split("")[0]);
        startColum = Integer.parseInt(rowAndColum.split("")[1]);

        if (!isRightDiagonal(startRow, startColum, i, matrix)) {      //проверява по десен диагонал
            return false;
        }
        return true;
    }
}