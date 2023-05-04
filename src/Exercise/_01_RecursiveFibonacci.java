package Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _01_RecursiveFibonacci {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayDeque<Long> queue = new ArrayDeque<>(); //опашка, която ще съдържа поредното число на Фибоначи

        long N = Integer.parseInt(input.nextLine());
        System.out.println(getFibonacci(queue, N));
    }

    private static Long getFibonacci(ArrayDeque<Long> FibonacciQueue, Long N) {
        if (N < 2) {    //подсигуряване, че числото, на което се търси числото на Фибоначи ще запобне най-малко от 2
            return 1L;
        } else {
            FibonacciQueue.offer(0L);
            FibonacciQueue.offer(1L);
            for (int i = 0; i < N; i++) {
                long Sum = FibonacciQueue.poll() + FibonacciQueue.peek();
                FibonacciQueue.offer(Sum);
            }
        }
        FibonacciQueue.poll();
        return FibonacciQueue.peek();
    }
}