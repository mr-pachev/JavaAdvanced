package Exams;

import java.util.*;
import java.util.stream.Collectors;

public class PastryShop_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquidsQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        String[] ingredient = scanner.nextLine().split("[,\\s+]+");

        Deque<Integer> ingredientStack = new ArrayDeque<>();
        Arrays.stream(ingredient)
                .mapToInt(Integer::parseInt)
                .forEach(ingredientStack::push);

        Map<String, Integer> advancedMaterialsMap = new LinkedHashMap<>();
        advancedMaterialsMap.put("Biscuit", 0);
        advancedMaterialsMap.put("Cake", 0);
        advancedMaterialsMap.put("Pie", 0);
        advancedMaterialsMap.put("Pastry", 0);

        while (!liquidsQueue.isEmpty() && !ingredientStack.isEmpty()) {
            int sum = liquidsQueue.peek() + ingredientStack.peek();

            if (sum == 25) {
                liquidsQueue.poll();
                ingredientStack.pop();
                advancedMaterialsMap.put("Biscuit", advancedMaterialsMap.get("Biscuit") + 1);
            } else if (sum == 50) {
                liquidsQueue.poll();
                ingredientStack.pop();
                advancedMaterialsMap.put("Cake", advancedMaterialsMap.get("Cake") + 1);
            } else if (sum == 75) {
                liquidsQueue.poll();
                ingredientStack.pop();
                advancedMaterialsMap.put("Pie", advancedMaterialsMap.get("Pie") + 1);
            } else if (sum == 100) {
                liquidsQueue.poll();
                ingredientStack.pop();
                advancedMaterialsMap.put("Pastry", advancedMaterialsMap.get("Pastry") + 1);
            } else {
                liquidsQueue.poll();
                ingredientStack.push(ingredientStack.pop() + 3);
            }
        }
        if (isReady(advancedMaterialsMap)) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        if (liquidsQueue.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.println("Liquids left: " + liquidsQueue.stream().map(String::valueOf)
                    .collect(Collectors.joining(", ")));

        }

        if (ingredientStack.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.println("Ingredients left: " + ingredientStack.stream().map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }

        advancedMaterialsMap.forEach((k, v) -> {
                    System.out.printf("%s: %d%n", k, v);
                });
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
}
