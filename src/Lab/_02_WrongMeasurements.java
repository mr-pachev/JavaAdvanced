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
            changeMatrix[i] = columElements;
        }

        int[] wrong = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int wrongValue = matrix[wrong[0]][wrong[1]];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int sum = 0;

                if (matrix[i][j] == wrongValue){                            //проверка дали дадения елемент съпвада с грешния

                    if(i == 0 && j == 0){                                   //първи ред и първа колона
                        if (matrix[i+1][j] != wrongValue && matrix[i][j+1] != wrongValue){
                            sum = matrix[i+1][j] + matrix[i][j+1];
                        }
                    }else if (i == 0 && j == matrix[i].length - 1){         //първи ред и последна колона
                        
                    }else if (i == row - 1 && j == 0){                      //последен ред и първа колона

                    }else if (i == row - 1 && j == matrix[i].length - 1){   //последен ред и последна колона

                    }


                }
            }
        }

    }
}
