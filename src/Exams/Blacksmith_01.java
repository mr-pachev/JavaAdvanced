package Exams;

import java.util.*;

public class Blacksmith_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] steel = scanner.nextLine().split("[,\\s+]+");
        Deque<Integer> steelsQueue = new ArrayDeque<>();
        Arrays.stream(steel)
                .mapToInt(Integer::parseInt)
                .forEach(steelsQueue::offer);

        String[] carbon = scanner.nextLine().split("[,\\s+]+");
        Deque<Integer> carbonsStack = new ArrayDeque<>();
        Arrays.stream(carbon)
                .mapToInt(Integer::parseInt)
                .forEach(carbonsStack::push);

        Map<String, Integer> swordMap = new TreeMap<>();
        swordMap.put("Gladius", 0);
        swordMap.put("Shamshir", 0);
        swordMap.put("Katana", 0);
        swordMap.put("Sabre", 0);

        while (!steelsQueue.isEmpty() && !carbonsStack.isEmpty()) {
            int result = steelsQueue.peek() + carbonsStack.peek();

            if (result == 70) {
                swordMap.put("Gladius", swordMap.get("Gladius") + 1);
                steelsQueue.poll();
                carbonsStack.pop();
            } else if (result == 80) {
                swordMap.put("Shamshir", swordMap.get("Shamshir") + 1);
                steelsQueue.poll();
                carbonsStack.pop();
            } else if (result == 90) {
                swordMap.put("Katana", swordMap.get("Katana") + 1);
                steelsQueue.poll();
                carbonsStack.pop();
            } else if (result == 110) {
                swordMap.put("Sabre", swordMap.get("Sabre") + 1);
                steelsQueue.poll();
                carbonsStack.pop();
            } else {
                steelsQueue.poll();
                carbonsStack.push(carbonsStack.pop() + 5);
            }
        }

        if (counterSword(swordMap) > 0) {
            System.out.printf("You have forged %d swords.%n", counterSword(swordMap));
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }

        if (!steelsQueue.isEmpty()) {
            System.out.print("Steel left: ");
            //принтипане на списък
            System.out.print(steelsQueue.toString().replaceAll("[\\[\\],]", "")
                    .replaceAll(" ", ", "));
            System.out.println();
        } else {
            System.out.println("Steel left: none");
        }

        if (!carbonsStack.isEmpty()) {
            System.out.print("Carbon left: ");
            //принтипане на списък
            System.out.print(carbonsStack.toString().replaceAll("[\\[\\],]", "")
                    .replaceAll(" ", ", "));
            System.out.println();
        } else {
            System.out.println("Carbon left: none");
        }

        if (counterSword(swordMap) > 0) {
            swordMap.forEach((k, v) -> {
                        if (v > 0) {
                            System.out.printf("%s: %d%n", k, v);
                        }

                    }
            );
        }
    }

    public static int counterSword(Map<String, Integer> map) {
        int counter = 0;
        for (int swordCount : map.values()) {
            counter += swordCount;
        }
        return counter;
    }
}
