package Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _02_Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int rowInput = Integer.parseInt(input.split(" ")[0]);
        int colInput = Integer.parseInt(input.split(" ")[1]);

        List<List<Integer>> matrix = new ArrayList<>();

        fillMatrix(matrix, rowInput, colInput);

        input = scanner.nextLine();

        while (!input.equals("Nuke it from orbit")) {
            int rowPoint = Integer.parseInt(input.split(" ")[0]);
            int colPoint = Integer.parseInt(input.split(" ")[1]);
            int radius = Integer.parseInt(input.split(" ")[2]);

            for (int row = rowPoint - radius; row < rowPoint + radius; row++) {
                if (isValid(matrix, row, colPoint)) {
                    matrix.get(row).remove(colPoint);
                }
            }
            for (int col = colPoint - radius; col < colPoint + radius; col++) {
                if (isValid(matrix, rowPoint, col)) {
                    int currentElement = matrix.get(rowPoint).get(col);
                    matrix.get(rowPoint).remove(col);
                }

            }

            matrix.removeIf(List::isEmpty);
            input = scanner.nextLine();
        }
        printMatrix(matrix, rowInput);
    }

    //запълване на матрицата
    private static void fillMatrix(List<List<Integer>> matrix, int row, int col) {
        int element = 0;
        for (int i = 0; i < row; i++) {
            List<Integer> rowList = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                element++;
                rowList.add(element);
            }
            matrix.add(rowList);
        }
    }

    //валидация на конкретната позиция от реда и колоната за премахване на елемент
    public static boolean isValid(List<List<Integer>> matrix, int row, int col) {
        return (row >= 0 && row < matrix.size() &&  col >= 0 && col < matrix.get(row).size());
    }

    //принтиран на матрица
    private static void printMatrix(List<List<Integer>> matrix, int rows) {
        for (int row = 0; row < rows; row++) {
            List<Integer> colList = matrix.get(row);
            System.out.println(colList.toString().replaceAll("[\\[\\],]", ""));
        }
    }

}