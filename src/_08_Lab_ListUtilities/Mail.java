package _08_Lab_ListUtilities;

import java.util.Arrays;
import java.util.List;

public class Mail {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 98, 55);

        System.out.println("Min - " +  ListUtils.getMin(list));
        System.out.println("Max - " +  ListUtils.getMax(list));
    }
}
