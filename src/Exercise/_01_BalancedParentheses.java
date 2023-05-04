package Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01_BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split("")).collect(Collectors.toList());

        ArrayDeque<String> parentheses = new ArrayDeque<>();

        boolean isBalanced = false;

        for (int i = 0; i < input.size(); i++) {
            String currentBracket = input.get(i);

            if (currentBracket.equals("{") || currentBracket.equals("[") || currentBracket.equals("(")) {
                parentheses.push(currentBracket);

            } else if (currentBracket.equals("}") || currentBracket.equals("]") || currentBracket.equals(")")) {
                if (parentheses.peek().equals("{") && currentBracket.equals("}")) {
                    parentheses.pop();
                    isBalanced = true;
                } else if (parentheses.peek().equals("[") && currentBracket.equals("]")) {
                    parentheses.pop();
                    isBalanced = true;
                } else if (parentheses.peek().equals("(") && currentBracket.equals(")")) {
                    parentheses.pop();
                    isBalanced = true;
                } else {
                    isBalanced = false;
                    break;
                }
            }
        }
        if (isBalanced){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }

    }
}
