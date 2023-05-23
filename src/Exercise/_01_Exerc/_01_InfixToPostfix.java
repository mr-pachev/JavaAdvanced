package Exercise._01_Exerc;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class _01_InfixToPostfix {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split(" ");
        ArrayDeque<String> operatorStack = new ArrayDeque<>();
        ArrayDeque<String> outputQueue = new ArrayDeque<>();

        for (String token : tokens) {
            if (!"-+/*()".contains(token)) {                //проверка дали е число
                outputQueue.offer(token);

            } else if (token.equals("(")) {                 //проверка дали е отваряща скоба
                operatorStack.push(token);

            } else if (token.equals(")")) {                 //проверка дали е затваряща скоба
                while (!operatorStack.peek().equals("(")) {
                    outputQueue.offer(operatorStack.pop());
                }
                operatorStack.pop();

            } else {
                if ("-+".contains(token)) {                 //проверка дали е оператор "-" или "+"
                    while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                        outputQueue.offer(operatorStack.pop());
                    }
                } else {
                    while (!operatorStack.isEmpty() && !"+-(".contains(operatorStack.peek())) {
                        outputQueue.offer(operatorStack.pop());
                    }
                }
                operatorStack.push(token);                  //пазим всичко различно от число
            }

        }

        while (!operatorStack.isEmpty()) {
            outputQueue.offer(operatorStack.pop());
        }
        System.out.println(String.join(" ", outputQueue));
    }
}
