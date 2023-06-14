package Exams;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PawnWars_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] matrix = new String[8][8];

        for (int row = 0; row < matrix.length; row++) {
            String[] input = scanner.nextLine().split("");
            for (int col = 0; col < matrix[0].length; col++) {
                //    matrix[row][col] = input[col];
                if (col < input.length) {
                    matrix[row][col] = input[col];
                } else {
                    matrix[row][col] = "-";
                }
            }
        }

        int rowWhite = -1;
        int colWhite = -1;
        boolean whiteWin = false;
        boolean whitePromoted = false;

        int rowBlack = -1;
        int colBlack = -1;
        boolean blackWin = false;
        boolean blackPromoted = false;

        //взимане първоначалните кординатите на двете пешки
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (matrix[row][col].equals("w")) {
                    rowWhite = row;
                    colWhite = col;
                } else if (matrix[row][col].equals("b")) {
                    rowBlack = row;
                    colBlack = col;
                }
            }
        }

        Map<Integer, String> rowsMap = new HashMap<>();
        rowsMap.put(0, "8");
        rowsMap.put(1, "7");
        rowsMap.put(2, "6");
        rowsMap.put(3, "5");
        rowsMap.put(4, "4");
        rowsMap.put(5, "3");
        rowsMap.put(6, "2");
        rowsMap.put(7, "1");

        Map<Integer, String> columMap = new HashMap<>();
        columMap.put(0, "a");
        columMap.put(1, "b");
        columMap.put(2, "c");
        columMap.put(3, "d");
        columMap.put(4, "e");
        columMap.put(5, "f");
        columMap.put(6, "g");
        columMap.put(7, "h");

        while (rowWhite != 0 && rowBlack != 7) {

            if (rowWhite - 1 == rowBlack && (colWhite - 1 == colBlack || colWhite + 1 == colBlack)) {
                rowWhite = rowBlack;
                colWhite = colBlack;
                whiteWin = true;
                break;
            }
            rowWhite--;
            if (rowWhite == 0) {
                whitePromoted = true;
               continue;
            }

            if (rowBlack + 1 == rowWhite && (colBlack - 1 == colWhite || colBlack + 1 == colWhite)) {
                rowBlack = rowWhite;
                colBlack = colWhite;
                blackWin = true;
                break;
            }
            rowBlack++;
            if (rowBlack == 7) {
                blackPromoted = true;
            }
        }

        if (whiteWin) {
            System.out.printf("Game over! White capture on %s.", getCoordinates(rowsMap, columMap, rowWhite, colWhite));
        } else if (blackWin) {
            System.out.printf("Game over! Black capture on %s.", getCoordinates(rowsMap, columMap, rowBlack, colBlack));
        }

        if (whitePromoted) {
            System.out.printf("Game over! White pawn is promoted to a queen at %s.", getCoordinates(rowsMap, columMap, rowWhite, colWhite));
        } else if (blackPromoted) {
            System.out.printf("Game over! Black pawn is promoted to a queen at %s.", getCoordinates(rowsMap, columMap, rowBlack, colBlack));
        }

    }
    public static String getCoordinates ( Map<Integer, String> rowsMap, Map<Integer, String> columMap, int row, int col){
        return columMap.get(col) + rowsMap.get(row);
    }
}
