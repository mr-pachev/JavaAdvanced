package Exams;

import java.util.*;

public class ApocalypsePreparation_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> queue = new ArrayDeque<>();
        Deque<Integer> stack = new ArrayDeque<>();

        Map<String, Integer> resultMap = new HashMap<>();
        resultMap.put("Patch", 0);
        resultMap.put("Bandage", 0);
        resultMap.put("MedKit", 0);

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

        int counterPatch = 0;             //30
        int counterBandage = 0;           //40
        int counterMedKit = 0;            //100

        while (!queue.isEmpty() && !stack.isEmpty()) {
            int currentResult = queue.peek() + stack.peek();

            if (currentResult == 30) {
                counterPatch++;
                resultMap.put("Patch", counterPatch);
                queue.poll();
                stack.pop();
            } else if (currentResult == 40) {
                counterBandage++;
                resultMap.put("Bandage", counterBandage);
                queue.poll();
                stack.pop();
            } else if (currentResult == 100) {
                counterMedKit++;
                resultMap.put("MedKit", counterMedKit);
                queue.poll();
                stack.pop();
            } else if (currentResult > 100) {
                counterMedKit++;
                resultMap.put("MedKit", counterMedKit);
                queue.poll();
                stack.pop();
                stack.push(stack.pop() + (currentResult) - 100);
            } else {
                queue.poll();
                stack.push(stack.pop() + 10);
            }
        }

        if (queue.isEmpty() && !stack.isEmpty()) {
            System.out.println("Textiles are empty.");
        } else if (!queue.isEmpty()) {
            System.out.println("Medicaments are empty.");
        } else {
            System.out.println("Textiles and medicaments are both empty.");
        }

        resultMap.entrySet().stream()
                .sorted((s1, s2) -> s2.getValue().compareTo(s1.getValue()))
                .forEach(entry -> {
                    if (entry.getValue() != 0) {
                        System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
                    }
                });

        if (!stack.isEmpty()) {
            System.out.println("Medicaments left: " + stack.toString().replaceAll("[\\[\\],]", "")
                    .replaceAll(" ", ", "));
        } else {
            if (!queue.isEmpty()) {
                System.out.println("Textiles left: " + queue.toString().replaceAll("[\\[\\],]", "")
                        .replaceAll(" ", ", "));
            }
        }

    }
}