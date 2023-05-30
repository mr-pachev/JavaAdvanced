package _06_Exercise_OpinionPoll;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Person> personsList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String[] inputData = scanner.nextLine().split(" ");

            String name = inputData[0];
            int age = Integer.parseInt(inputData[1]);

            Person person = new Person(name, age);

            personsList.add(person);
        }

      personsList = personsList.stream()
                .filter(e -> e.getAge() > 30)
                .collect(Collectors.toList());

        personsList.sort(Comparator.comparing(person -> person.getName()));

        for (Person person : personsList){
            System.out.println(person.toString());
        }

    }
}