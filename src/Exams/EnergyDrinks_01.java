package Exams;

import java.util.*;

public class EnergyDrinks_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] caffeine = scanner.nextLine().split("[,\\s+]+");

        Stack<Integer> caffeineStack = new Stack<>();
        Arrays.stream(caffeine)
                .mapToInt(Integer::parseInt)
                .forEach(caffeineStack::push);

        String[] energyDrink = scanner.nextLine().split("[,\\s+]+");
        Queue<Integer> energyDrinkQueue = new ArrayDeque<>();
        Arrays.stream(energyDrink)
                .mapToInt(Integer::parseInt)
                .forEach(energyDrinkQueue::offer);

        int sumCaffeineTake = 0;
        int maxCaffeinePerDay = 300;

        while(!caffeineStack.isEmpty() && !energyDrinkQueue.isEmpty()){
            int currentSumCaffeine = caffeineStack.peek() * energyDrinkQueue.peek();

            if (currentSumCaffeine <= maxCaffeinePerDay){
                maxCaffeinePerDay -= currentSumCaffeine;
                sumCaffeineTake += currentSumCaffeine;
                caffeineStack.pop();
                energyDrinkQueue.poll();
            }else {
                caffeineStack.pop();
                energyDrinkQueue.offer(energyDrinkQueue.poll());

                if (sumCaffeineTake - 30 >= 0){
                    maxCaffeinePerDay += 30;
                    sumCaffeineTake -= 30;
                }

            }
        }

        if (energyDrinkQueue.isEmpty()){
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }else {
            System.out.print("Drinks left: ");
            System.out.println(energyDrinkQueue.toString().replace("[","").replace("]",""));
        }

        System.out.printf("Stamat is going to sleep with %d mg caffeine.", sumCaffeineTake);
    }
}
