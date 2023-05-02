package Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _06_HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] kids = scanner.nextLine().split("\\s+");
        int jump = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> hotPotato = new ArrayDeque<>();

        for (int i = 0; i < kids.length; i++) {     //пълним опашката според входа от конзолата
            hotPotato.offer(kids[i]);
        }

        while (hotPotato.size() > 1) {              //цикъл докато остане само едно дете в опашката

            for (int i = 1; i < jump; i++) {        //пренарежда децата в опошката според броя на хвърлянията->с едно завъртане по-малко
                String currentKids = hotPotato.peek();
                hotPotato.poll();
                hotPotato.offer(currentKids);
            }
            System.out.println("Removed " + hotPotato.poll());
        }
        System.out.println("Last is " + hotPotato.peek());
    }
}
