package Exams;

import java.util.Scanner;

public class ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int health = Integer.parseInt(scanner.nextLine());
        int rowsMatrix = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[rowsMatrix][];

        for (int row = 0; row < rowsMatrix; row++) {
            String input = scanner.nextLine();
            char[] currentRowSymbol = input.toCharArray();

            matrix[row] = currentRowSymbol;                         //запълване на реда на матрицата според входните данни
        }
        int rowP = -1;
        int colP = -1;

        //определяне позицията на Парис
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 'P') {
                    rowP = row;
                    colP = col;
                    break;
                }
            }
        }

        int oldRowP = rowP;
        int oldColP = colP;

        int rowDeadP = -1;
        int colDeadP = -1;

        String input = scanner.nextLine();
        boolean isDead = false;

        while (health > 0) {
            String[] inputData = input.split("\\s+");
            String command = inputData[0];
            int rowS = Integer.parseInt(inputData[1]);
            int colS = Integer.parseInt(inputData[2]);
            health--;

            matrix[rowS][colS] = 'S';

            if (command.equals("up")) {
                rowP--;
            } else if (command.equals("down")) {
                rowP++;
            } else if (command.equals("left")) {
                colP--;
            } else if (command.equals("right")) {
                colP++;
            }

            //проверяваме дали новото място от командата е валидно
            if (rowP < 0 || rowP >= matrix.length || colP < 0 || colP >= matrix[0].length) {
                rowP = oldRowP;
                colP = oldColP;
                input = scanner.nextLine();
                continue;
            } else {
                matrix[oldRowP][oldColP] = '-'; //след преместването на Парис остава -
                oldRowP = rowP;
                oldColP = colP;

                if (matrix[rowP][colP] == 'S') {
                    health -= 2;

                    if (health <= 0) {
                        matrix[rowP][colP] = 'X';
                        rowDeadP = rowP;
                        colDeadP = colP;
                        isDead = true;
                        break;
                    } else {
                        matrix[rowP][colP] = 'P';
                    }

                } else if (matrix[rowP][colP] == 'H') {
                    matrix[rowP][colP] = '-';
                    break;
                } else {

                    if (health <= 0) {
                        matrix[rowP][colP] = 'X';
                        rowDeadP = rowP;
                        colDeadP = colP;
                        isDead = true;
                        break;
                    } else {
                        matrix[rowP][colP] = 'P';
                    }
                }
            }
            input = scanner.nextLine();
        }

        if (isDead) {
            System.out.printf("Paris died at %d;%d.%n", rowDeadP, colDeadP);
        } else {
            System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", health);
        }

        printMatrix(matrix);
    }

    //принтиран на матрица
    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println(); //свали курсора на следващия ред
        }
    }
}
