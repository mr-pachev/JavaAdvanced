package Exams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FormulaOne_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowAndColum = Integer.parseInt(scanner.nextLine());
        int sumCommands = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[rowAndColum][rowAndColum];
        boolean isFinish = false;

        for (int row = 0; row < rowAndColum; row++) {
            String[] input = scanner.nextLine().split("");
            for (int col = 0; col < rowAndColum; col++) {

                if (col < input.length) {
                    matrix[row][col] = input[col];
                } else {
                    matrix[row][col] = ".";
                }
            }
        }

        int currentRowP = -1;
        int currentColP = -1;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col].equals("P")) {
                    currentRowP = row;
                    currentColP = col;
                }
            }
        }
        int newRowP = currentRowP;
        int newColP = currentColP;

        List<String> commandsList = new ArrayList<>();
        for (int commandNum = 1; commandNum <= sumCommands; commandNum++) {
            String command = scanner.nextLine();
            commandsList.add(command);
        }

        for (int commandNum = 0; commandNum < commandsList.size(); commandNum++) {

                matrix[currentRowP][currentColP] = ".";
                switch (commandsList.get(commandNum)) {
                    case "up":
                        newRowP--;
                        if (newRowP < 0) {
                            newRowP = matrix.length - 1;
                        }
                        break;
                    case "down":
                        newRowP++;
                        if (newRowP >= matrix.length) {
                            newRowP = 0;
                        }
                        break;
                    case "left":
                        newColP--;
                        if (newColP < 0) {
                            newColP = matrix.length - 1;
                        }
                        break;
                    case "right":
                        newColP++;
                        if (newColP >= matrix.length) {
                            newColP = 0;
                        }
                        break;
                }

                if (matrix[newRowP][newColP].equals("B")){
                    commandNum--;
                }else if (matrix[newRowP][newColP].equals("T")){
                    newRowP = currentRowP;
                    newColP = currentColP;
                    matrix[newRowP][newColP] = "P";
                }else if (matrix[newRowP][newColP].equals("F")) {
                    isFinish = true;
                    matrix[newRowP][newColP] = "P";
                    break;
                }else {
                    currentRowP = newRowP;
                    currentColP = newColP;
                    matrix[newRowP][newColP] = "P";
                }

        }
        if (isFinish) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }

        printMatrix(matrix);
    }


    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + "");
            }
            System.out.println();
        }
    }
}
