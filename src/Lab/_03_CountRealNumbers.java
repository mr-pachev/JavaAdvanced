package Lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _03_CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] digit = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> digitMap = new LinkedHashMap<>();

        //пълнене на map-а
        for (int i = 0; i < digit.length; i++) {
            digitMap.putIfAbsent(digit[i], 0);
        }

        //обхождане на map-а и проверка всяко число колко пъти се среща
        for (int i = 0; i < digit.length; i++) {
            if (digitMap.containsKey(digit[i])){
                digitMap.put(digit[i], digitMap.get(digit[i]) + 1);
            }
        }

        //принтиране на map-а
        digitMap.forEach((k,v) -> {
            System.out.printf("%.1f -> ", k);
            System.out.printf("%d%n", v);
                }
        );
    }
}
