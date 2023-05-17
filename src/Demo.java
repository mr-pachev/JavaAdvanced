import java.util.*;
import java.util.Scanner;

public class Demo {
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

            int colStart = colPoint - radius; //начална точка от конкретния List за премахване по хоризонтала
            int colEnd = colPoint + radius;   //крайна точка от конкретния List за премахване по хоризонтала
            int rowStart = rowPoint - radius; //начален реда от, който ще започне премахване по вертикала
            int rowEnd = rowPoint + radius;   //краен реда до, който ще се премахва по вертикала

            //премахване наляво
            if (isValid(matrix, rowPoint, colStart)) {
                for (int col = colStart; col <= colPoint; col++) {
                    matrix.get(rowPoint).set(col, 0);
                }
            } else {
                for (int col = 0; col <= colPoint; col++) {
                    matrix.get(rowPoint).set(col, 0);
                }
            }

            //премахване надясно
            if (isValid(matrix, rowPoint, colEnd)) {
                for (int col = colPoint + 1; col <= colEnd; col++) {
                    matrix.get(rowPoint).set(col, 0);
                }
            } else {
                for (int col = colPoint + 1; col < matrix.get(rowPoint).size(); col++) {
                    matrix.get(rowPoint).set(col, 0);
                }
            }

            //премахване нагоре
            if (isValid(matrix, rowPoint, rowStart)) {
                for (int row = rowStart; row <= rowPoint; row++) {
                    matrix.get(row).set(colPoint, 0);
                }
            } else {
                for (int row = 0; row <= rowPoint; row++) {
                    matrix.get(row).set(colPoint, 0);
                }
            }

            //премахване надолу
            if (isValid(matrix, rowPoint, rowEnd)) {
                for (int row = rowEnd - 1; row > rowPoint; row--) {
                    matrix.get(row).set(colPoint, 0);
                }
            } else {
                for (int row = matrix.size() - 1; row > rowPoint; row--) {
                    matrix.get(row).set(colPoint, 0);
                }
            }

            isRemove(matrix);

            input = scanner.nextLine();
        }


        printMatrix(matrix, matrix.size());
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
        return (row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size());
    }

    //цикъл за премахване на елемент със стойност 0
    public static void isRemove(List<List<Integer>> matrix) {
        for (int row = 0; row < matrix.size(); row++) {
            List<Integer> rowList = matrix.get(row);

            for (int col = 0; col < matrix.get(row).size(); col++) {

                for (int name : new ArrayList<Integer>(rowList)) {
                    int a = name;
                    if (name == 0) {
                        rowList.remove(matrix.get(row).get(col));
                    }
                }
            }
        }
    }

    //принтиран на матрица
    private static void printMatrix(List<List<Integer>> matrix, int rows) {
        for (int row = 0; row < rows; row++) {
            List<Integer> colList = matrix.get(row);
            for (int col = 0; col < matrix.get(row).size(); col++) {

                if (colList.get(col) == 0) {
                    colList.remove(col);
                }

            }
            System.out.println(colList.toString().replaceAll("[\\[\\],]", ""));
        }
    }

}
