package Lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01_MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();      //входа е стринг, зада може да се използва substring
        List<String> listExpression = Arrays.stream(input.split("")).collect(Collectors.toList()); //трябва ни листа, зада може да обходим целия израз

        ArrayDeque<String> expression = new ArrayDeque<>(); //в стека ще пазим индекса на срещнатите отваряще скоби

        for (int i = 0; i < listExpression.size(); i++) {
            if (listExpression.get(i).equals("(")){ //при отваряща скоба запаметяваме индекса й в стека
                expression.push("" + i);
            }
            if (listExpression.get(i).equals(")")){ //при затваряща скоба принтираме входящия израз от индекса на последно отварящата скоба до индекса на текущата затварящата скоба
                int startIndex = Integer.parseInt(expression.pop()); //премахваме използвания индекс на отварящата скоба от стека
                String currentExpr = input.substring(startIndex, i+1);
                System.out.println(currentExpr);
            }
        }

    }
}
