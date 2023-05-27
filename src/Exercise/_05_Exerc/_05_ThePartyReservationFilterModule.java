package Exercise._05_Exerc;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _05_ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> questsList = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        List<String> filterList = new ArrayList<>();            //съдържа филтрираните гости(няма да присъстват в questList)

        String input = scanner.nextLine();

        while (!input.equals("Print")) {
            String[] inputData = input.split(";");

            String command = inputData[0];
            String type = inputData[1];
            String criteria = inputData[2];

            Predicate<String> currentPredicate = null;

            //задаване на условие
            if (type.equals("Starts with")) {
                currentPredicate = s -> s.startsWith(criteria);
            } else if (type.equals("Ends with")) {
                currentPredicate = s -> s.endsWith(criteria);
            } else if (type.equals("Length")) {
                currentPredicate = s -> s.length() == Integer.parseInt(criteria);
            } else if (type.equals("Contains")) {
                currentPredicate = s -> s.contains(criteria);
            }

            if (command.contains("Add")) {
                List<String> addFilterList = new ArrayList<>();     //текущ списък с хора за добавяне в списъка с филтрираните(премахнати) гости

                //обхождане на листа с гости и проверка кои отговарят на УСЛОВИЕТО-филтъра
                for (String s : questsList) {
                    if (currentPredicate.test(s)) {
                        addFilterList.add(s);                        //дадения гост се добавя в текущия списък за добавяне на филтрирани(премахнати) гости в основния
                    }
                }
                filterList.addAll(addFilterList);
            } else if (command.contains("Remove")) {
                List<String> removeFilterList = new ArrayList<>();   //текущ списък с хора за премахване от списъка с филтрираните(премахнати) гости

                //обхождане на листа с гости и проверка кои отговарят на УСЛОВИЕТО-филтъра
                for (String s : questsList) {
                    if (currentPredicate.test(s)) {
                        removeFilterList.add(s);                      //даденият гост се добавя в текущия списък за премахване на филтрирани(премахнати) гости от основния списък
                    }
                }
                filterList.removeAll(removeFilterList);               //премахване на филтрирани гости от основния списък
            }

            input = scanner.nextLine();
        }

        questsList.removeAll(filterList);

        if (!questsList.isEmpty()) {
            System.out.print(questsList.toString().replaceAll("[\\[\\],]", ""));
        }
    }
}
