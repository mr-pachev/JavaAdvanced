import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> questsList = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Party!")){
            String[] inputData = input.split("\\s+");

            String command = inputData[0];
            String type = inputData[1];
            String criteria = inputData[2];

            Predicate<String> currentPredicate = null;

            //задаване на условие
            if (type.equals("StartsWith")){
                currentPredicate = s -> s.startsWith(criteria);
            }else if (type.equals("EndsWith")){
                currentPredicate = s -> s.endsWith(criteria);
            }else if (type.equals("Length")){
                currentPredicate = s -> s.length() == Integer.parseInt(criteria);
            }

            if (command.equals("Double")){
                List<String> addList = new ArrayList<>();

                for (String s : questsList){
                    if (currentPredicate.test(s)){
                        addList.add(s);
                    }
                }
                questsList.addAll(addList);
            }else if (command.equals("Remove")){
                List<String> removeList = new ArrayList<>();

                for (String s : questsList){
                    if (currentPredicate.test(s)){
                        removeList.add(s);
                    }
                }
                questsList.removeAll(removeList);
            }

            input = scanner.nextLine();
        }
        Collections.sort(questsList);
        if (questsList.isEmpty()){
            System.out.println("Nobody is going to the party!");
        }else {
            System.out.print(questsList.toString().replaceAll("[\\[\\],]", "")
                    .replaceAll(" ", ", "));
            System.out.println(" are going to the party!");
        }
    }
}
