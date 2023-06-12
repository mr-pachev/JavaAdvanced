package Exams;

import java.util.*;

public class KAT_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] licensePlate = scanner.nextLine().split("[,\\s+]+");
        Deque<Integer> licensePlateQueue = new ArrayDeque<>();
        Arrays.stream(licensePlate)
                .mapToInt(Integer::parseInt)
                .forEach(licensePlateQueue::offer);

        String[] cars = scanner.nextLine().split("[,\\s+]+");
        Deque<Integer> carsStack = new ArrayDeque<>();
        Arrays.stream(cars)
                .mapToInt(Integer::parseInt)
                .forEach(carsStack::push);


        int dayCounter = 0;
        int carCounter = 0;

        while (!licensePlateQueue.isEmpty() && !carsStack.isEmpty()) {
            dayCounter++;
            int currentLicensePlate = licensePlateQueue.poll();
            int currentCars = carsStack.pop();
            int diff = 0;

            if (currentLicensePlate > currentCars) {                //когато опашката е по-голяма
                diff = currentLicensePlate - (currentCars * 2);
                carCounter += currentCars;;
                if(diff > 0){
                    licensePlateQueue.offer(diff);
                }

            } else {                                                //когато стека е по-голям или равен
                diff = 0;

                carCounter += currentLicensePlate / 2;
                diff = currentCars - (currentLicensePlate / 2);
                carsStack.addLast(diff);
            }
        }

        System.out.printf("%d cars were registered for %d days!%n", carCounter, dayCounter);

        if (!licensePlateQueue.isEmpty()) {
            System.out.printf("%d license plates remain!%n", sumEleDeque(licensePlateQueue));
        }
        if (!carsStack.isEmpty()) {
            System.out.printf("%d cars remain without license plates!%n", sumEleDeque(carsStack));
        }
        if (licensePlateQueue.isEmpty() && carsStack.isEmpty()) {
            System.out.println("Good job! There is no queue in front of the KAT!");
        }
    }

    public static int sumEleDeque(Deque<Integer> queue) {
        int sum = 0;
        for (int n : queue) {
            sum += n;
        }
        return sum;
    }

}
