package Exams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Meeting_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] male = scanner.nextLine().split("[\\s+]+");
        Deque<Integer> maleStack = new ArrayDeque<>();
        Arrays.stream(male)
                .mapToInt(Integer::parseInt)
                .forEach(maleStack::push);

        String[] female = scanner.nextLine().split("[,\\s+]+");
        Deque<Integer> femaleQueue = new ArrayDeque<>();
        Arrays.stream(female)
                .mapToInt(Integer::parseInt)
                .forEach(femaleQueue::offer);

        int matchesCount = 0;

        while (!femaleQueue.isEmpty() && !maleStack.isEmpty()) {
            int currentFemale = femaleQueue.peek();
            int currentMale = maleStack.peek();

            if (currentFemale <= 0) {
                femaleQueue.poll();
                continue;
            }
            if (currentMale <= 0) {
                maleStack.pop();
                continue;
            }

            if (currentFemale % 25 == 0){
                femaleQueue.poll();
                femaleQueue.poll();
                continue;
            }
            if (currentMale % 25 == 0){
                maleStack.pop();
                maleStack.pop();
                continue;
            }

            if (currentFemale == currentMale) {
                femaleQueue.poll();
                maleStack.pop();
                matchesCount++;
            } else {
                femaleQueue.poll();
                maleStack.push(maleStack.pop() - 2);
            }

        }

        System.out.printf("Matches: %d%n", matchesCount);
        if (maleStack.isEmpty()){
            System.out.println("Males left: none");
        }else {
            System.out.print("Males left: ");
            System.out.print(maleStack.toString().replaceAll("[\\[\\],]", "")
                    .replaceAll(" ", ", "));
            System.out.println();
        }

        if (femaleQueue.isEmpty()){
            System.out.println("Females left: none");
        }else {
            System.out.print("Females left: ");
            System.out.print(femaleQueue.toString().replaceAll("[\\[\\],]", "")
                    .replaceAll(" ", ", "));
        }
    }
}
