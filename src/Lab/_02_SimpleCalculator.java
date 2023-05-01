package Lab;

import java.util.*;
import java.util.stream.Collectors;

public class _02_SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        List<String> list = Arrays.asList(input);
        Collections.reverse(list);

        ArrayDeque<String> digit = new ArrayDeque<>();

        for (String s : list){
            digit.push(s);
        }

        int result = 0;
        while (digit.size() > 1){
            int firstNum = Integer.parseInt(digit.pop());
            String op = digit.pop();
            int secondNum = Integer.parseInt(digit.pop());

            if (op.equals("+")){
                result = firstNum + secondNum;
            }else if (op.equals("-")){
                result = firstNum - secondNum;
            }
            digit.push("" + result);
        }
        System.out.println(digit.peek());
    }
}
