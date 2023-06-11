package Exams;

import java.util.Scanner;

public class NavyBattle_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int rowAndColum = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[rowAndColum][];

        int currentRowS = -1;
        int currentColS = -1;

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split("");
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j].equals("S")) {
                    currentRowS = i;
                    currentColS = j;
                }
            }
        }

        int countCruisersDes = 0;
        int countMinesFind = 0;

        while (countCruisersDes < 3 && countMinesFind < 3) {
            String command = scanner.nextLine();

            matrix[currentRowS][currentColS] = "-";

            switch (command) {
                case "up":
                    currentRowS--;
                    break;
                case "down":
                    currentRowS++;
                    break;
                case "left":
                    currentColS--;
                    break;
                case "right":
                    currentColS++;
                    break;
            }

            if (matrix[currentRowS][currentColS].equals("*")) {
                countMinesFind++;
                //TODO
            } else if (matrix[currentRowS][currentColS].equals("C")) {
                countCruisersDes++;
                //TODO
            }
            matrix[currentRowS][currentColS] = "S";
        }
        if (countMinesFind == 3) {
            System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n", currentRowS, currentColS);
        }
        if (countCruisersDes == 3) {
            System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
        }

        printMatrix(matrix);

    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + "");
            }
            System.out.println(); //свали курсора на следващия ред
        }
    }
}
