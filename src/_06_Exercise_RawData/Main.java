package _06_Exercise_RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sumCars = Integer.parseInt(scanner.nextLine());
        List<Car> carsList = new ArrayList<>();

        for (int currentCar = 1; currentCar <= sumCars; currentCar++) {
            String[] inputData = scanner.nextLine().split(" ");

            String modelCar = inputData[0];

            int engineSpeed = Integer.parseInt(inputData[1]);
            int enginePower = Integer.parseInt(inputData[2]);

            int cargoWeight = Integer.parseInt(inputData[3]);
            String cargoType = inputData[4];

            double tire1Pressure = Double.parseDouble(inputData[5]);
            int tire1Age = Integer.parseInt(inputData[6]);

            double tire2Pressure = Double.parseDouble(inputData[7]);
            int tire2Age = Integer.parseInt(inputData[8]);

            double tire3Pressure = Double.parseDouble(inputData[9]);
            int tire3Age = Integer.parseInt(inputData[10]);

            double tire4Pressure = Double.parseDouble(inputData[11]);
            int tire4Age = Integer.parseInt(inputData[12]);

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tire tire = new Tire(tire1Pressure, tire1Age, tire2Pressure, tire2Age, tire3Pressure, tire3Age, tire4Pressure, tire4Age);

            Car car = new Car(modelCar, engine, cargo, tire);
            carsList.add(car);
        }

        String command = scanner.nextLine();

        for (Car car : carsList) {

            if (car.isFragile(command)) {
                System.out.println(car);
            } else if (car.isFlamable(command)) {
                System.out.println(car);
            }
        }
    }
}
