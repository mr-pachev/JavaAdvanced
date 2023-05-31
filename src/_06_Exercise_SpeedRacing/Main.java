package _06_Exercise_SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sumCar = Integer.parseInt(scanner.nextLine());

        Map<String, Car> carsMap = new LinkedHashMap<>();               //съдържа имената на моделите и обектита(характеристиките на дадения модел)

        //пълнене на мапа
        for (int currentCar = 1; currentCar <= sumCar; currentCar++) {
            String[] inputData = scanner.nextLine().split(" ");

            String model = inputData[0];
            double fuelAmount = Double.parseDouble(inputData[1]);
            double fuelCostFor1Km = Double.parseDouble(inputData[2]);

            Car car = new Car(model, fuelAmount, fuelCostFor1Km);
            carsMap.put(model, car);
        }

        String input = scanner.nextLine();

        while(!input.equals("End")){
            String[] inputData = input.split(" ");
            String model = inputData[1];
            int amountOfKm = Integer.parseInt(inputData[2]);            //километри за изминаване

            Car car = carsMap.get(model);                               //взимаме характеристиките(обекта) на дадения модел

            if (!car.isTravel(amountOfKm)){                             //ако колата няма достатъчнопари за изминаване на дадените километри
                System.out.println("Insufficient fuel for the drive");
            }

            input = scanner.nextLine();
        }

        carsMap.forEach((k,v) -> {
            System.out.println(v.toString());
                }
        );
    }
}
