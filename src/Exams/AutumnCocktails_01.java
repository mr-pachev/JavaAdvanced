package Exams;

import java.util.*;

public class AutumnCocktails_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] buckets = scanner.nextLine().split("[,\\s+]+");
        Deque<Integer> bucketsQueue = new ArrayDeque<>();
        Arrays.stream(buckets)
                .mapToInt(Integer::parseInt)
                .forEach(bucketsQueue::offer);

        String[] freshness = scanner.nextLine().split("[,\\s+]+");
        Deque<Integer> freshnessStack = new ArrayDeque<>();
        Arrays.stream(freshness)
                .mapToInt(Integer::parseInt)
                .forEach(freshnessStack::push);

        Map<String, Integer> cocktailsMap = new TreeMap<>();
        cocktailsMap.put("Pear Sour", 0);
        cocktailsMap.put("The Harvest", 0);
        cocktailsMap.put("Apple Hinny", 0);
        cocktailsMap.put("High Fashion", 0);

        while (!bucketsQueue.isEmpty() && !freshnessStack.isEmpty()) {

            int sum = bucketsQueue.peek() * freshnessStack.peek();

            if (sum == 150) {
                cocktailsMap.put("Pear Sour", cocktailsMap.get("Pear Sour") + 1);
                bucketsQueue.poll();
                freshnessStack.pop();
            } else if (sum == 250) {
                cocktailsMap.put("The Harvest", cocktailsMap.get("The Harvest") + 1);
                bucketsQueue.poll();
                freshnessStack.pop();
            } else if (sum == 300) {
                cocktailsMap.put("Apple Hinny", cocktailsMap.get("Apple Hinny") + 1);
                bucketsQueue.poll();
                freshnessStack.pop();
            } else if (sum == 400) {
                cocktailsMap.put("High Fashion", cocktailsMap.get("High Fashion") + 1);
                bucketsQueue.poll();
                freshnessStack.pop();
            }else if(bucketsQueue.peek() == 0) {
                bucketsQueue.poll();
            }
            else {
                bucketsQueue.offer(bucketsQueue.poll() + 5);
                freshnessStack.pop();
            }

        }

        if (isReady(cocktailsMap)) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if (!bucketsQueue.isEmpty()) {
            System.out.printf("Ingredients left: %d%n", sumBucketsQueue(bucketsQueue));
        }

        cocktailsMap.forEach((k, v) -> {
                    if (v > 0) {
                        System.out.printf(" # %s --> %d%n", k, v);
                    }
                }
        );
    }

    public static boolean isReady(Map<String, Integer> map) {
        boolean isReady = true;
        for (int countCurrentCocktail : map.values()) {
            if (countCurrentCocktail == 0) {
                isReady = false;
                break;
            }
        }
        return isReady;
    }

    public static int sumBucketsQueue(Deque<Integer> bucketsQueue) {
        int counter = 0;
        for (int n : bucketsQueue) {
            counter += n;
        }
        return counter;
    }
}
