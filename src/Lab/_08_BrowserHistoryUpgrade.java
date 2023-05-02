package Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _08_BrowserHistoryUpgrade {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> urlBack = new ArrayDeque<>();
        ArrayDeque<String> urlForward = new ArrayDeque<>();

        String input = scanner.nextLine();

        while (!input.equals("Home")) {

            if (input.equals("back")) {
                if (urlBack.size() <= 1) {                  //проверка дали в стека има един елемент->не може да се върнем на предишна стратица
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                } else {
                    urlForward.addFirst(urlBack.pop());     //премехваме страницата на която сме в момента и я добавяме към бъдещите
                    System.out.println(urlBack.peek());     //принтираме последния елемент от стека
                }

            } else if (input.equals("forward")) {
                if (urlForward.size() < 1) {                //проверка дали в опашката има елементи
                    System.out.println("no next URLs");
                    input = scanner.nextLine();
                    continue;
                } else {
                    urlBack.push(urlForward.peek());        //добавяме текущата страница към историята в стека
                    System.out.println(urlForward.poll());  //премахваме текущата страница->не е вече бъдеща страница
                    input = scanner.nextLine();
                    continue;
                }

            } else {
                urlBack.push(input);                        //запълваме стека с история на сайтовете
                urlForward.clear();                         //чистим опашката за навигиране напред
                System.out.println(urlBack.peek());         //принтираме последния добавен елемент от стека->текущото състояние
            }

            input = scanner.nextLine();
        }
    }
}