package Demo_06_Exercise_Google;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();
        Map<String, Person> personMap = new LinkedHashMap<>();              //съдържа хора с тяхната информация

        Person person = null;

        while (!input.equals("End")) {
            String[] inputData = input.split("\\s+");

            String personName = inputData[0];

            if (!personMap.containsKey(personName)) {
                Company company = null;
                Pokemon pokemon = null;
                Parents parents = null;
                Children children = null;
                Car car = null;

                switch (inputData[1]) {
                    case "company":
                        String companyName = inputData[2];
                        String department = inputData[3];
                        double salary = Double.parseDouble(inputData[4]);
                        company = new Company(companyName, department, salary);
                        break;
                    case "pokemon":
                        String pokemonName = inputData[2];
                        String pokemonType = inputData[3];
                        pokemon = new Pokemon(pokemonName, pokemonType);
                        person.addPokemon(pokemon);
                        break;
                    case "parents":
                        String parentName = inputData[2];
                        String parentBirthday = inputData[3];
                        parents = new Parents(parentName, parentBirthday);
                        person.addParents(parents);
                        break;
                    case "children":
                        String childName = inputData[2];
                        String childBirthday = inputData[3];
                        children = new Children(childName, childBirthday);
                        person.addChildren(children);
                        break;
                    case "car":
                        String carModel = inputData[2];
                        String carSpeed = inputData[3];
                        car = new Car(carModel, carSpeed);
                        break;
                }
                person = new Person(personName, company, car);
                personMap.put(personName, person);

            } else {
                person = personMap.get(personName);
                Pokemon pokemon = null;
                Parents parents = null;
                Children children = null;

                switch (inputData[1]) {
                    case "company":
                        String companyName = inputData[2];
                        String department = inputData[3];
                        double salary = Double.parseDouble(inputData[4]);
                        Company company = new Company(companyName, department, salary);
                        person.setCompany(company);
                        break;
                    case "pokemon":
                        String pokemonName = inputData[2];
                        String pokemonType = inputData[3];
                        pokemon = new Pokemon(pokemonName, pokemonType);
                        person.addPokemon(pokemon);
                        break;
                    case "parents":
                        String parentName = inputData[2];
                        String parentBirthday = inputData[3];
                        parents = new Parents(parentName, parentBirthday);
                        person.addParents(parents);
                        break;
                    case "children":
                        String childName = inputData[2];
                        String childBirthday = inputData[3];
                        children = new Children(childName, childBirthday);
                        person.addChildren(children);
                        break;
                }
                personMap.put(personName, person);
            }

            input = scanner.nextLine();
        }
        String name = scanner.nextLine();

        personMap.entrySet().stream()
                .filter(e -> e.getKey().equals(name))
                .forEach(entry -> {
                    System.out.println(entry.getKey());
                    if (entry.getValue().getCompany() != null) {
                        System.out.println("Company:");
                        System.out.println(entry.getValue().getCompany().toString());
                    } else {
                        System.out.println("Company:");
                    }

                    if (entry.getValue().getCar() != null) {
                        System.out.println("Car:");
                        System.out.println(entry.getValue().getCar().toString());
                    } else {
                        System.out.println("Car:");
                    }

                    if (!entry.getValue().getPokemonsList().isEmpty()) {
                        System.out.println("Pokemon:");
                        for (Pokemon pokemon : entry.getValue().getPokemonsList())
                            System.out.println(pokemon.toString());
                    } else {
                        System.out.println("Pokemon:");
                    }

                    if (!entry.getValue().getParentsList().isEmpty()) {
                        System.out.println("Parents:");
                        for (Parents parents : entry.getValue().getParentsList())
                            System.out.println(parents.toString());
                    } else {
                        System.out.println("Parents:");
                    }

                    if (!entry.getValue().getParentsList().isEmpty()) {
                        System.out.println("Children:");
                        for (Children children : entry.getValue().getChildrenList())
                            System.out.println(children.toString());
                    } else {
                        System.out.println("Children:");
                    }
                });

    }
}
