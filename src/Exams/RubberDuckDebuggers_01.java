package Exams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class RubberDuckDebuggers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> queue = new ArrayDeque<>();
        Deque<Integer> stack = new ArrayDeque<>();

        int[] firstLine = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] secondLine = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        //пълнене на опашката
        for (int i = 0; i < firstLine.length; i++) {
            queue.offer(firstLine[i]);
        }

        //пълнене на стека
        for (int i = 0; i < secondLine.length; i++) {
            stack.push(secondLine[i]);
        }

        int counterDarthVaderDucky = 0;             //0 - 60
        int counterThorDucky = 0;                   //61 – 120
        int counterBigBlueRubberDucky = 0;          //121 - 180
        int counterSmallYellowRubberDucky = 0;      //181 - 240

        while (!queue.isEmpty()) {
            int currentResult = queue.peek() * stack.peek();

            if (currentResult >= 0 && currentResult <= 60) {
                counterDarthVaderDucky++;
                queue.poll();
                stack.pop();
            } else if (currentResult >= 61 && currentResult <= 120) {
                counterThorDucky++;
                queue.poll();
                stack.pop();
            } else if (currentResult >= 121 && currentResult <= 180) {
                counterBigBlueRubberDucky++;
                queue.poll();
                stack.pop();
            } else if (currentResult >= 181 && currentResult <= 240) {
                counterSmallYellowRubberDucky++;
                queue.poll();
                stack.pop();
            }else {    //задължително трябва да се завъртат опашката и стека, докато сбора от конретните ем елементи не стане <= 240
               stack.push(stack.pop() - 2);
               queue.offer(queue.poll());
            }
        }
        System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded: ");
        System.out.printf("Darth Vader Ducky: %d%n", counterDarthVaderDucky);
        System.out.printf("Thor Ducky: %d%n", counterThorDucky);
        System.out.printf("Big Blue Rubber Ducky: %d%n", counterBigBlueRubberDucky);
        System.out.printf("Small Yellow Rubber Ducky: %d%n", counterSmallYellowRubberDucky);

    }
}
