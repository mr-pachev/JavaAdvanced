package Lab._03_Lab;

import java.util.*;

public class _03_ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, List<String>> shopMap = new TreeMap<>();

        while (!input.equals("Revision")) {
            String[] inputData = input.split(", ");

            String shop = inputData[0];
            String product = inputData[1];
            String price = inputData[2];

            if (!shopMap.containsKey(shop)) {
                List<String> list = new ArrayList<>();
                list.add(product);
                list.add(price);
                shopMap.put(shop, list);
            } else {
                List<String> currentList = shopMap.get(shop);
                currentList.add(product);
                currentList.add(price);
                shopMap.put(shop, currentList);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : shopMap.entrySet()) {
            System.out.printf("%s->%n", entry.getKey());

            int count = 0;
            for (int i = 0; i < entry.getValue().size(); i++) {
                if (count == 0){
                    System.out.printf("Product: %s, ", entry.getValue().get(i));
                    count++;
                }else if (count == 1){
                    System.out.printf("Price: %.1f%n", Double.parseDouble(entry.getValue().get(i)));
                    count = 0;
                }
            }

        }
    }
}
