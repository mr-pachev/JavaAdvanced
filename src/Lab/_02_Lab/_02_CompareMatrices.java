package Lab._02_Lab;

import java.util.Scanner;

public class _02_CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int colum = scanner.nextInt();

        int[][] matrixOne = new int[rows][colum];

        for (int currentRolw = 0; currentRolw < rows; currentRolw++) {              //четем редовете на матрицата
            for (int currentColum = 0; currentColum < colum; currentColum++) {      //четем всяка колоно от конкретния ред на матрицата
                int input = scanner.nextInt();                                      //четем поредното число от реда
                matrixOne[currentRolw][currentColum] = input;                       //запълваме колоната от конкретния ред на матрицата
            }
        }

        rows = scanner.nextInt();
        colum = scanner.nextInt();

        int[][] matrixTwo = new int[rows][colum];

        if (matrixOne.length != matrixTwo.length){                          //проверка дали двете матрици имат еднакви размери
            System.out.println("not equal");
            return;
        }

        for (int currentRolw = 0; currentRolw < rows; currentRolw++) {
            for (int currentColum = 0; currentColum < colum; currentColum++) {
                int input = scanner.nextInt();
                matrixTwo[currentRolw][currentColum] = input;
            }
        }

        //цикъл за обхождане на двете еднакви по брой и редове матрици
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colum; j++) {
                if (matrixOne[i][j] != matrixTwo[i][j]){                    //сравняване всяка колона но конкретния ред от конкретната матрица
                    System.out.println("not equal");
                    return;
                }
            }
        }
        System.out.println("equal");
    }
}
