package Exams;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class ItsChocolateTime_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] milk = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        ArrayDeque<Double> milkQueue = new ArrayDeque<>();
        for (int i = 0; i < milk.length; i++) {
            milkQueue.offer(milk[i]);
        }

        double[] cacao = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        ArrayDeque<Double> cacaoStack = new ArrayDeque<>();
        for (int i = 0; i < cacao.length; i++) {
            cacaoStack.push(cacao[i]);
        }

        Map<String, Integer> chocolateTypesMap = new TreeMap<>();
        chocolateTypesMap.put("Milk Chocolate", 0);
        chocolateTypesMap.put("Dark Chocolate", 0);
        chocolateTypesMap.put("Baking Chocolate", 0);

        double cacaoPercentage = 0;

        while (!milkQueue.isEmpty() && !cacaoStack.isEmpty()) {
            cacaoPercentage = cacaoStack.peek() / (milkQueue.peek() + cacaoStack.peek()) * 100;

            if (cacaoPercentage == 30) {
                chocolateTypesMap.put("Milk Chocolate", chocolateTypesMap.get("Milk Chocolate") + 1);
                milkQueue.poll();
                cacaoStack.pop();
            } else if (cacaoPercentage == 50) {
                chocolateTypesMap.put("Dark Chocolate", chocolateTypesMap.get("Dark Chocolate") + 1);
                milkQueue.poll();
                cacaoStack.pop();
            } else if (cacaoPercentage == 100) {
                chocolateTypesMap.put("Baking Chocolate", chocolateTypesMap.get("Baking Chocolate") + 1);
                milkQueue.poll();
                cacaoStack.pop();
            } else {
                cacaoStack.pop();
                milkQueue.offer(milkQueue.poll() + 10);
            }

        }

        boolean isFinish = true;
        for (Map.Entry<String, Integer> entry : chocolateTypesMap.entrySet()) {
            if (entry.getValue() == 0) {
                isFinish = false;
                System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
                break;
            }
        }

        if (isFinish){
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        }
        chocolateTypesMap.entrySet().stream()
                .filter(e -> e.getValue() > 0)
                .forEach(el -> {
                    System.out.printf("# %s --> %d%n", el.getKey(), el.getValue());
                });

    }
}
