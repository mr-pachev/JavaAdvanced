package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _02_WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int row = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[row][];
        int[][] changeMatrix = new int[row][];

        //запълване на матрицата със зададени само брой редове
        for (int i = 0; i < row; i++) {
            int[] columElements = Arrays.stream(scanner.nextLine()
                            .split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[i] = columElements;
        }

        for (int i = 0; i < row; i++) {
            changeMatrix[i] = matrix[i].clone();
        }

        int[] wrong = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int wrongValue = matrix[wrong[0]][wrong[1]];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int sum = 0;

                if (matrix[i][j] == wrongValue) {                             //проверка дали дадения елемент съпвада с грешния

                    if (i == 0 && j == 0) {                                   //първи ред и първа колона
                        if (matrix[i + 1][j] != wrongValue) {                 //долу
                            sum += matrix[i + 1][j];
                        }
                        if (matrix[i][j + 1] != wrongValue) {                 //дясно
                            sum += matrix[i][j + 1];
                        }

                    } else if (i == 0 && j == matrix[i].length - 1) {         //първи ред и последна колона
                        if (matrix[i + 1][j] != wrongValue) {                 //долу
                            sum += matrix[i + 1][j];
                        }
                        if (matrix[i][j - 1] != wrongValue) {                 //ляво
                            sum += matrix[i][j - 1];
                        }

                    } else if (i == row - 1 && j == 0) {                      //последен ред и първа колона
                        if (matrix[i - 1][j] != wrongValue) {                 //горе
                            sum += matrix[i - 1][j];
                        }
                        if (matrix[i][j + 1] != wrongValue) {                 //дясно
                            sum += matrix[i][j + 1];
                        }

                    } else if (i == row - 1 && j == matrix[i].length - 1) {   //последен ред и последна колона
                        if (matrix[i - 1][j] != wrongValue) {                 //горе
                            sum += matrix[i - 1][j];
                        }
                        if (matrix[i][j - 1] != wrongValue) {                 //ляво
                            sum += matrix[i][j - 1];
                        }

                    } else if (i == 0) {                                       //първи ред
                        if (matrix[i + 1][j] != wrongValue) {                  //долу
                            sum += matrix[i + 1][j];
                        }
                        if (matrix[i][j - 1] != wrongValue) {                  //ляво
                            sum += matrix[i][j - 1];
                        }
                        if (matrix[i][j + 1] != wrongValue) {                  //дясно
                            sum += matrix[i][j + 1];
                        }

                    } else if (i == row - 1) {                                 //последен ред
                        if (matrix[i - 1][j] != wrongValue) {                  //горе
                            sum += matrix[i - 1][j];
                        }
                        if (matrix[i][j - 1] != wrongValue) {                  //ляво
                            sum += matrix[i][j - 1];
                        }
                        if (matrix[i][j + 1] != wrongValue) {                  //дясно
                            sum += matrix[i][j + 1];
                        }

                    } else if (j == 0) {                                        //първа колона
                        if (matrix[i - 1][j] != wrongValue) {                  //горе
                            sum += matrix[i - 1][j];
                        }
                        if (matrix[i + 1][j] != wrongValue) {                  //долу
                            sum += matrix[i + 1][j];
                        }
                        if (matrix[i][j + 1] != wrongValue) {                  //дясно
                            sum += matrix[i][j + 1];
                        }

                    } else if (j == matrix[i].length - 1) {                      //последна колона
                        if (matrix[i - 1][j] != wrongValue) {                  //горе
                            sum += matrix[i - 1][j];
                        }
                        if (matrix[i + 1][j] != wrongValue) {                  //долу
                            sum += matrix[i + 1][j];
                        }
                        if (matrix[i][j - 1] != wrongValue) {                  //ляво
                            sum += matrix[i][j - 1];
                        }
                    } else {
                        if (matrix[i - 1][j] != wrongValue) {                  //горе
                            sum += matrix[i - 1][j];
                        }
                        if (matrix[i + 1][j] != wrongValue) {                  //долу
                            sum += matrix[i + 1][j];
                        }
                        if (matrix[i][j - 1] != wrongValue) {                  //ляво
                            sum += matrix[i][j - 1];
                        }
                        if (matrix[i][j + 1] != wrongValue) {                  //дясно
                            sum += matrix[i][j + 1];
                        }
                    }

                    changeMatrix[i][j] = sum;
                }
            }
        }
        for (int i = 0; i < changeMatrix.length; i++) {
            for (int j = 0; j < changeMatrix[i].length; j++) {
                System.out.printf("%d ", changeMatrix[i][j]);
            }
            System.out.println();
        }
    }
}
