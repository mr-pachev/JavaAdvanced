package Exercise._05_Exerc;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class _05_PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> guestsList = Arrays.stream(scanner.nextLine().split("\\s+"))
                                          .collect(Collectors.toCollection(ArrayList::new));

        String inputData = scanner.nextLine();

        while (!inputData.equals("Party!")) {

            Predicate<String> predicate = null;                             //създаваме УСЛОВИЕ, което ще е различно според даденият случай

            String criteria = inputData.split("\\s+")[2];             //взима последната част от входните данни

            if (inputData.contains("Length")) {                             //когато съдържа Length
                predicate = x -> x.length() == Integer.parseInt(criteria);  //задава се УСЛОВИЕТО -> проверява дали зададения String е с дължината на criteria

            } else if (inputData.contains("StartsWith")) {                  //когато съдържа StartWith
                predicate = x -> x.startsWith(criteria);                    //задава се УСЛОВИЕТО -> проверява дали началото на зададения String съдържа criteria

            } else {
                predicate = x -> x.endsWith(criteria);                      //задава се УСЛОВИЕТО -> проверява дали края на зададения String съдържа criteria
            }

            //след зададеното УСЛОВИЕ поверка какво трябва да се направи спрямо него
            if (inputData.contains("Remove")) {                             //премахване на елементи спрямо УСЛОВИЕТО
                ArrayList<String> toRemoveList = new ArrayList<>();         //създава се лист с елементи за премахване

                for (String guest : guestsList) {                           //обхожда questLis и при отговаряне на зададеното УСЛОВИЕ добавя елемента към toRemoveList
                    if (predicate.test(guest)) {
                        toRemoveList.add(guest);
                    }
                }
                guestsList.removeAll(toRemoveList);

            } else {                                                          //добавяне на елементи спрямо УСЛОВИЕТО
                ArrayList<String> toAddList = new ArrayList<>();              //създава се лист с елементи за добавяне

                for (String guest : guestsList) {                             //обхожда questLis и при отговаряне на зададеното УСЛОВИЕ добавя елемента към toAddList
                    if (predicate.test(guest)) {
                        toAddList.add(guest);
                    }
                }
                guestsList.addAll(toAddList);
            }

            inputData = scanner.nextLine();
        }

        if (guestsList.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.println(guestsList.stream().sorted().collect(Collectors.toCollection(ArrayList::new)).toString().replaceAll("([\\[\\]])", "") + " are going to the party!");
        }
    }
}