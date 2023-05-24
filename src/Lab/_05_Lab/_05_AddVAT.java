package Lab._05_Lab;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _05_AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> pricesList = Arrays.stream(scanner.nextLine().split(", "))
                .map(n -> Double.parseDouble(n))
                .collect(Collectors.toList());

        Function<Double, Double> currentVAT = num -> (num * 0.2) + num; //смята ДДС на всяко подадено число
        Consumer<Double> print =  s -> System.out.printf("%.2f%n", s);  //принтира всяко подадено число

        System.out.println("Prices with VAT:");
        for (double n : pricesList){
           print.accept(currentVAT.apply(n));
        }

    }
}
