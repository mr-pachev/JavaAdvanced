package Demo_06_Exercise_CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sumEngines = Integer.parseInt(scanner.nextLine());
        Engine engine = null;
        List<Car> carList = new ArrayList<>();
        List<Engine> enginesList = new ArrayList<>();

        for (int currentEngin = 1; currentEngin <= sumEngines; currentEngin++) {
            String[] inputData = scanner.nextLine().split(" ");

            String enginModel = inputData[0];
            int enginPower = Integer.parseInt(inputData[1]);

            if (inputData.length == 2) {
                engine = new Engine(enginModel, enginPower);
            } else if (inputData.length == 3) {
                if (Character.isDigit(inputData[2].charAt(0))) {
                    String enginDisplacement = inputData[2];
                    engine = new Engine(enginModel, enginPower, enginDisplacement, 0);    //котаго има зададена кубатула
                } else {
                    String engineEfficiency = inputData[2];
                    engine = new Engine(enginModel, enginPower, engineEfficiency);     //когато има зададен ефективност
                }
            } else if (inputData.length == 4) {
                engine = new Engine(enginModel, enginPower, inputData[2], inputData[3]);
            }
            enginesList.add(engine);
        }

        int sumCars = Integer.parseInt(scanner.nextLine());
        Car car = null;

        for (int currentCar = 1; currentCar <= sumCars; currentCar++) {
            String[] inputData = scanner.nextLine().split(" ");

            String carModel = inputData[0];
            String enginModel = inputData[1];
            engine = isTypeEngin(enginesList, enginModel);      //създаване на обект с характеристиките на зададения модел двитател

            if (inputData.length == 2) {
                car = new Car(carModel, engine);
            } else if (inputData.length == 3) {
                if (Character.isDigit(inputData[1].charAt(0))) {
                    String weight = inputData[2];
                    car = new Car(carModel, engine, weight);    //когато има зададена кубатура
                } else {
                    String color = inputData[2];
                    car = new Car(carModel, engine, 0, color);
                }
            } else if (inputData.length == 4) {
                car = new Car(carModel, engine, inputData[2], inputData[3]);
            }
            carList.add(car);
        }
        System.out.println();
    }

    public  static Engine isTypeEngin (List<Engine> enginList, String model){
        Engine engines = null;
        for (Engine engine : enginList){
            if(engine.getModel().equals(model)){
                engines =  engine;
                break;
            }
        }
        return engines;
    }
}
