package Exercise;

import java.util.*;
import java.util.stream.Collectors;

public class _01_ReverseNumbersWithAStack {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> inputList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int n : inputList) {
            stack.push(n);
        }

        while (stack.size() > 0){
            System.out.print(stack.pop() + " ");
        }
    }
}
