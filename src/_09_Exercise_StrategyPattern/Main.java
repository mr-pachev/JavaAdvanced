package _09_Exercise_StrategyPattern;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Set<Person> namePersonSet = new TreeSet<>(new ComparingByName());
        Set<Person> agePersonSet = new TreeSet<>(new ComparingByAge());

        for (int i = 1; i <= n; i++) {
            String[] inputData = scanner.nextLine().split("\\s+");

            String name = inputData[0];
            int age = Integer.parseInt(inputData[1]);

            Person person = new Person(name, age);

            namePersonSet.add(person);
            agePersonSet.add(person);
        }

        for (Person person : namePersonSet){
            System.out.println(person.toString());
        }

        for (Person person : agePersonSet){
            System.out.println(person.toString());
        }

    }
}
