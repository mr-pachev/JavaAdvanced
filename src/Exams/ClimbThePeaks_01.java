package Exams;

import java.util.*;
import java.util.stream.Collectors;

public class ClimbThePeaks_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dailyPortion = scanner.nextLine().split(", ");
        Stack<Integer> dailyPortionStack = new Stack<>();
        Arrays.stream(dailyPortion)
                .mapToInt(Integer::parseInt)
                .forEach(dailyPortionStack::push);

        String[] dailyStamina = scanner.nextLine().split(", ");
        Queue<Integer> dailyStaminaQueue = new ArrayDeque<>();
        Arrays.stream(dailyStamina)
                .mapToInt(Integer::parseInt)
                .forEach(dailyStaminaQueue::offer);

        List<String> peaksList = new ArrayList<>();

        Map<Integer, String> peaksMap = new LinkedHashMap<>(); //съдържа върховете и нужното за покоряването им, след покоряването на върха той се премахва
        peaksMap.put(80, "Vihren");
        peaksMap.put(90, "Kutelo");
        peaksMap.put(100, "Banski Suhodol");
        peaksMap.put(60, "Polezhan");
        peaksMap.put(70, "Kamenitza");

        int counterPeaks = 0;
        int counterDays = 0;

        while (counterPeaks < 5 && counterDays < 7 && !dailyPortionStack.isEmpty() && !dailyStaminaQueue.isEmpty()) {
            int sum = dailyPortionStack.peek() + dailyStaminaQueue.peek();
            counterDays++;

            for (Map.Entry<Integer, String> entry : peaksMap.entrySet()) {
                if (sum >= entry.getKey()){
                    peaksList.add(entry.getValue());
                    peaksMap.remove(entry.getKey());
                    counterPeaks++;
                }
                break;
            }

            dailyPortionStack.pop();
            dailyStaminaQueue.poll();
        }

        if (counterPeaks == 5) {
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
        } else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }
        if (!peaksList.isEmpty()) {
            System.out.println("Conquered peaks:");
            peaksList.forEach(peak -> {
                System.out.println(peak);
            });
        }

    }
}