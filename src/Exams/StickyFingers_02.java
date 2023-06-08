package Exams;

import java.util.Scanner;

public class StickyFingers_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowAndColum = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[rowAndColum][];
        String[] command = scanner.nextLine().split(",");

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split(" ");
        }

        int curRowD = -1;
        int curColD = -1;
        ;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col].equals("D")) {
                    curRowD = row;
                    curColD = col;
                }
            }
        }

        int stolenMoney = 0;
        int currentStolenMoney = 0;
        boolean isGetsCaught = false;

        for (int i = 0; i < command.length; i++) {

            switch (command[i]) {
                case "up":
                    if (isValidIndex(matrix, curRowD - 1)) {
                        matrix[curRowD][curColD] = "+";       //старата позиция става +
                        curRowD--;                            //позицията се променя

                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
                case "down":
                    if (isValidIndex(matrix, curRowD + 1)) {
                        matrix[curRowD][curColD] = "+";       //старата позиция става +
                        curRowD++;                            //позицията се променя

                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
                case "left":
                    if (isValidIndex(matrix, curColD - 1)) {
                        matrix[curRowD][curColD] = "+";       //старата позиция става +
                        curColD--;                            //позицията се променя
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
                case "right":
                    if (isValidIndex(matrix, curColD + 1)) {
                        matrix[curRowD][curColD] = "+";       //старата позиция става +
                        curColD++;                            //позицията се променя
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
            }
            if (matrix[curRowD][curColD].equals("$")) {
                currentStolenMoney = curRowD * curColD;
                System.out.printf("You successfully stole %d$.%n", currentStolenMoney);
                stolenMoney += currentStolenMoney;
                matrix[curRowD][curColD] = "D";
            }else if (matrix[curRowD][curColD].equals("P")){
                isGetsCaught = true;
                matrix[curRowD][curColD] = "#";
                break;
            }else {
                matrix[curRowD][curColD] = "D";
            }
        }

        if (isGetsCaught) {
            System.out.printf("You got caught with %d$, and you are going to jail.%n", stolenMoney);
        } else {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", stolenMoney);
        }

        printMatrix(matrix);
    }

    public static boolean isValidIndex(String[][] matrix, int index) {
        return index >= 0 && index < matrix.length;
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println(); //свали курсора на следващия ред
        }
    }
}
