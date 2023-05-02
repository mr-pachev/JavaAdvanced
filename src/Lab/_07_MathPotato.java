package Lab;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Scanner;

public class _07_MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] kids = scanner.nextLine().split("\\s+");
        int jump = Integer.parseInt(scanner.nextLine());

        PriorityQueue<String> hotPotato = new PriorityQueue<>(); //опашка с приоритет

        for (int i = 0; i < kids.length; i++) {     //пълним опашката според входа от конзолата
            hotPotato.offer(kids[i]);
        }

        int counter = 0;                            //глобален брояч спред децата в опашката

        while (hotPotato.size() > 1) {
            counter++;

            for (int i = 1; i < jump; i++) {        //премества(джурка) децата в опашкана според подхвърлянията
                String currentKids = hotPotato.poll();
                hotPotato.offer(currentKids);
            }

            if (isPrime(counter)) {                 //проверка дали цикъла на завъртане на децата е просто число
                System.out.println("Prime " + hotPotato.peek());
            } else {
                System.out.println("Removed " + hotPotato.poll());
            }
        }
        System.out.println("Last is " + hotPotato.peek());
    }

    public static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
