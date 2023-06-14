package Exams;

import java.util.*;

public class FoodFinder_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] vowelLetters = scanner.nextLine().split("[,\\s+]+");
        Deque<String> vowelLettersQueue = new ArrayDeque<>();

        for (String vowelLetter : vowelLetters) {
            vowelLettersQueue.offer(vowelLetter);
        }

        String[] consonantLetters = scanner.nextLine().split("[,\\s+]+");
        Deque<String> consonantLettersStack = new ArrayDeque<>();

        for (String consonantLetter : consonantLetters) {
            consonantLettersStack.push(consonantLetter);
        }

        String[] pear = "pear".split("");
        Set<String> pearSet = new LinkedHashSet<>();
        pearSet.addAll(Arrays.asList(pear));

        String[] flour = "flour".split("");
        Set<String> flourSet = new LinkedHashSet<>();
        flourSet.addAll(Arrays.asList(flour));

        String[] pork = "pork".split("");
        Set<String> porkSet = new LinkedHashSet<>();
        porkSet.addAll(Arrays.asList(pork));

        String[] olive = "olive".split("");
        Set<String> oliveSet = new LinkedHashSet<>();
        oliveSet.addAll(Arrays.asList(olive));

        while (!consonantLettersStack.isEmpty()) {
            String currentVowelLetter = vowelLettersQueue.poll();
            String currentConsonantLetter = consonantLettersStack.pop();

            if (pearSet.contains(currentVowelLetter)) {
                pearSet.remove(currentVowelLetter);
            }
            if (pearSet.contains(currentConsonantLetter)) {
                pearSet.remove(currentConsonantLetter);
            }

            if (flourSet.contains(currentVowelLetter)) {
                flourSet.remove(currentVowelLetter);
            }
            if (flourSet.contains(currentConsonantLetter)) {
                flourSet.remove(currentConsonantLetter);
            }

            if (porkSet.contains(currentVowelLetter)) {
                porkSet.remove(currentVowelLetter);
            }
            if (porkSet.contains(currentConsonantLetter)) {
                porkSet.remove(currentConsonantLetter);
            }

            if (oliveSet.contains(currentVowelLetter)) {
                oliveSet.remove(currentVowelLetter);
            }
            if (oliveSet.contains(currentConsonantLetter)) {
                oliveSet.remove(currentConsonantLetter);
            }
            vowelLettersQueue.offer(currentVowelLetter);
        }

        System.out.printf("Words found: %d%n", countFindWords(pearSet, flourSet, porkSet, oliveSet));
        if (pearSet.isEmpty()){
            System.out.println("pear");
        }
        if (flourSet.isEmpty()){
            System.out.println("flour");
        }
        if (porkSet.isEmpty()){
            System.out.println("pork");
        }
        if (oliveSet.isEmpty()){
            System.out.println("olive");
        }

    }
    public static int countFindWords (Set<String> one, Set<String> two, Set<String> tree, Set<String> four){
        int count = 0;
        if (one.isEmpty()){
            count++;
        }
        if (two.isEmpty()){
            count++;
        }
        if (tree.isEmpty()){
            count++;
        }
        if (four.isEmpty()){
            count++;
        }
        return count;
    }
}
