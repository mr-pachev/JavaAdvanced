package Exams;

import java.util.*;
import java.util.stream.Collectors;

public class TempleOfDoom_01_Final {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tools = scanner.nextLine().split("\\s+");
        Deque<Integer> toolsQueue = new ArrayDeque<>();
        Arrays.stream(tools)
                .mapToInt(Integer::parseInt)
                .forEach(toolsQueue::offer);


        String[] substances = scanner.nextLine().split("\\s+");
        Deque<Integer> substancesStack = new ArrayDeque<>();
        Arrays.stream(substances)
                .mapToInt(Integer::parseInt)
                .forEach(substancesStack::push);


        List<Integer> challengesList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (!toolsQueue.isEmpty() && !substancesStack.isEmpty()) {
            int sum = toolsQueue.peek() * substancesStack.peek();

            if (challengesList.contains(sum)){
                toolsQueue.poll();
                substancesStack.pop();
                challengesList.remove((Integer) sum);
            }else {
                toolsQueue.offer(toolsQueue.poll() + 1);
                substancesStack.push(substancesStack.pop() - 1);

                if (substancesStack.peek() <= 0){
                    substancesStack.pop();
                }
            }
        }

        if (challengesList.isEmpty()){
            System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
        }else {
            System.out.println("Harry is lost in the temple. Oblivion awaits him.");
        }

        if (!toolsQueue.isEmpty()){
            System.out.print("Tools: ");
            System.out.println(toolsQueue.toString().replaceAll("[\\[\\],]", "")
                    .replaceAll(" ", ", "));
        }
        if (!substancesStack.isEmpty()){
            System.out.print("Substances: ");
            System.out.println(substancesStack.toString().replaceAll("[\\[\\],]", "")
                    .replaceAll(" ", ", "));
        }
        if (!challengesList.isEmpty()){
            System.out.print("Challenges: ");
            System.out.println(challengesList.toString().replaceAll("[\\[\\],]", "")
                    .replaceAll(" ", ", "));
        }
    }
}
