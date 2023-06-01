package _06_Exercise_CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sumEngines = Integer.parseInt(scanner.nextLine());

        List<Car> carList = new ArrayList<>();
        List<Engine> enginesList = new ArrayList<>();

        Engine engine = null;

        for (int currentEngin = 1; currentEngin <= sumEngines; currentEngin++) {
            String[] inputData = scanner.nextLine().split(" ");

            String enginModel = inputData[0];
            int enginPower = Integer.parseInt(inputData[1]);

            if (inputData.length == 2) {
                engine = new Engine(enginModel, enginPower);
            } else if (inputData.length == 3) {
                if (Character.isDigit(inputData[2].charAt(0))) {                                  //проверка дали елемента та индекс 2(displacements or efficiency) е цифра
                    String enginDisplacement = inputData[2];
                    engine = new Engine(enginModel, enginPower, enginDisplacement, 0);    //котаго има зададена кубатура
                } else {
                    String engineEfficiency = inputData[2];
                    engine = new Engine(enginModel, enginPower, engineEfficiency);                //когато има зададена ефективност
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
            engine = isTypeEngin(enginesList, enginModel);          //създаване на обект с характеристиките на зададения модел двитател

            if (inputData.length == 2) {
                car = new Car(carModel, engine);
            } else if (inputData.length == 3) {
                if (Character.isDigit(inputData[2].charAt(0))) {    //проверка дали елемента та индекс 2(weight or color) е цифра
                    String weight = inputData[2];
                    car = new Car(carModel, engine, weight);        //когато има зададена кубатура
                } else {
                    String color = inputData[2];
                    car = new Car(carModel, engine, 0, color);
                }
            } else if (inputData.length == 4) {
                car = new Car(carModel, engine, inputData[2], inputData[3]);
            }
            carList.add(car);
        }

        for (Car currentCar : carList){
            System.out.print(currentCar.toString());
        }
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
