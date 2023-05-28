package _06_Lab_Constructors;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int carsNum = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= carsNum; i++) {
            String[] inputData = scanner.nextLine().split("\\s+");

            if (inputData.length == 1) {
                Car car = new Car(inputData[0]);
                System.out.print(car);
            } else if (inputData.length == 2) {
                Car car = new Car(inputData[0], inputData[1]);
                System.out.print(car);
            } else if (inputData.length == 3) {
                Car car = new Car(inputData[0], inputData[1], Integer.parseInt(inputData[2]));
                System.out.print(car);
            }
        }

    }
}
