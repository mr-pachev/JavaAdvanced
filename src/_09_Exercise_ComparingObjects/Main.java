package _09_Exercise_ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Person> personsList = new ArrayList<>();

        while (!input.equals("END")){
            String[] inputData = input.split(" ");

            String name = inputData[0];
            int age = Integer.parseInt(inputData[1]);
            String town = inputData[2];

            Person person = new Person(name, age, town);

            personsList.add(person);

            input = scanner.nextLine();
        }

        int personNum = Integer.parseInt(scanner.nextLine());

        Person personToCompare = personsList.get(personNum - 1);    //човека от списъка, с който ще сравняваме

        int equalCount = 1;
        int notEqualCount = 0;

        for (Person current : personsList){

            if (!personToCompare.equals(current)){
                int res = personToCompare.compareTo(current);

                if (res == 0){
                    equalCount++;
                }else {
                    notEqualCount++;
                }
            }

        }
        if (equalCount == 1){
            System.out.println("No matches");
        }else {
            System.out.printf("%d %d %d", equalCount, notEqualCount, personsList.size());
        }
    }
}
