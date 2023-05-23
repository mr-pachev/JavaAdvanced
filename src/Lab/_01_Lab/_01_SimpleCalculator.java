package Lab._01_Lab;

import java.util.*;

public class _01_SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        List<String> list = Arrays.asList(input);
        Collections.reverse(list);

        ArrayDeque<String> digit = new ArrayDeque<>();

        for (String s : list){  //пълним стека в съответствие с входа от конзолата
            digit.push(s);
        }

        int result = 0;

        while (digit.size() > 1){   //проверка дали в стека е останал  само резултата
            int firstNum = Integer.parseInt(digit.pop());
            String op = digit.pop();
            int secondNum = Integer.parseInt(digit.pop());

            if (op.equals("+")){
                result = firstNum + secondNum;
            }else if (op.equals("-")){
                result = firstNum - secondNum;
            }
            digit.push("" + result); //добавя резултата от досегашните аритметични действия до момента
        }
        System.out.println(digit.peek()); //принтера последния останал елемент в стека->резултата
    }
}
