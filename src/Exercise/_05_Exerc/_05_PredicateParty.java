package Exercise._05_Exerc;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class _05_PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> questList = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        String input = scanner.nextLine();
        Map<String, List<String>> commandMap = new LinkedHashMap<>();

        BiFunction<List<String>, String, String> startWitchString = (list, s) -> {
            for (String e : list) {
                if (e.startsWith(s)) {
                    return e;
                }
            }
            return "";
        };

        BiFunction<List<String>, String, String> endWitchString = (list, s) -> {
            for (String e : list) {
                if (e.endsWith(s)) {
                    return e;
                }
            }
            return "";
        };

        BiFunction<List<String>, Integer, String> lengthType = (list, s) -> {
            for (String e : list) {
                if (e.length() == s) {
                    return e;
                }
            }
            return "";
        };

        BiFunction<List<String>, String, Integer> matchSum = (list, a) -> {
            int count = 0;
            for (String s : list) {
                if (a.equals(s)) {
                    count++;
                }
            }
            return count;
        };


        Consumer<List<String>> printList = list -> System.out.print(list.toString().replaceAll("[\\[\\],]", "")
                .replaceAll(" ", ", "));

        while (!input.equals("Party!")) {
            String[] inputData = input.split("\\s+");

            String command = inputData[0];
            String type = inputData[1];
            String criteria = inputData[2];

            List<String> list = new ArrayList<>();
            list.add(type);
            list.add(criteria);
            if (commandMap.containsKey(command)) {
                list = commandMap.get(command);
                list.add(type);
                list.add(criteria);
            }
            commandMap.put(command, list);

            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : commandMap.entrySet()) {
            String command = entry.getKey();
            for (int i = 0; i < entry.getValue().size(); i += 2) {

                String type = entry.getValue().get(i);
                String criteria = entry.getValue().get(i + 1);
                int length = 0;

                if (isDigit(criteria)) {
                    length = Integer.parseInt(criteria);
                }

                if (command.equals("Double")) {
                    if (type.equals("StartsWith")) {
                        String current = startWitchString.apply(questList, criteria);
                        if (!current.isEmpty()) {
                            if (matchSum.apply(questList, current) % 2 != 0) {
                                questList.remove(current);
                            }
                            questList.add(current);
                            questList.add(current);
                        }
                    } else if (type.equals("EndsWith")) {
                        String current = endWitchString.apply(questList, criteria);
                        if (!current.isEmpty()) {
                            if (matchSum.apply(questList, current) % 2 != 0) {
                                questList.remove(current);
                            }
                            questList.add(current);
                            questList.add(current);
                        }
                    } else if (type.equals("Length")) {
                        String current = lengthType.apply(questList, length);
                        if (!current.isEmpty()) {
                            if (matchSum.apply(questList, current) % 2 != 0) {
                                questList.remove(current);
                            }
                            questList.add(current);
                            questList.add(current);
                        }
                    }
                } else if (command.equals("Remove")) {
                    if (type.equals("StartsWith")) {
                        String current = startWitchString.apply(questList, criteria);
                        if (!current.isEmpty()) {
                            questList.remove(current);
                        }
                    } else if (type.equals("EndsWith")) {
                        String current = endWitchString.apply(questList, criteria);
                        if (!current.isEmpty()) {
                            questList.remove(current);
                        }
                    } else if (type.equals("Length")) {
                        String current = lengthType.apply(questList, length);
                        if (!current.isEmpty()) {
                            questList.remove(current);
                        }
                    }
                }
            }
        }

        Collections.sort(questList);

        if (questList.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            printList.accept(questList);
            System.out.print(" are going to the party!");
        }
    }

    public static boolean isDigit(String words) {
        char word = words.charAt(0);

        return Character.isDigit(word);
    }
}
