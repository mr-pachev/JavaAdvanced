package _06_PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Trainer> trainersMap = new LinkedHashMap<>();    //съдържа име на треньор и характеристиките му

        while (!input.equals("Tournament")) {
            String[] dataInput = input.split(" ");

            String trainerName = dataInput[0];
            String pokemonName = dataInput[1];
            String pokemonElement = dataInput[2];
            int pokemonHealth = Integer.parseInt(dataInput[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            Trainer trainer = null;

            if (trainersMap.containsKey(trainerName)) {
                trainer = trainersMap.get(trainerName);
            } else {
                trainer = new Trainer(trainerName);
            }
            trainer.getPokemonsList().add(pokemon);
            trainersMap.putIfAbsent(trainerName, trainer);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!input.equals("End")) {
            String command = input;

            for (Map.Entry<String, Trainer> entry : trainersMap.entrySet()) {
                Trainer trainer = entry.getValue();                             //конкретен обект треньор

                if (!trainer.isExist(command)) {                              //проверка дали треньора ими ПОНЕ един покемон, за да получи САМО един бадж
                    trainer.removeHealth();
                } else {
                    trainer.addBudge();
                }
                trainer.removePokemon();
            }

            input = scanner.nextLine();
        }

        //сортиране на мапа само по стойност на value в низходящ ред впротивен случай важи подредбата на LinkedTreeMap-а
        trainersMap.values().stream()
                .sorted((n1, n2) -> Integer.compare(n2.getNumberOfBadges(), n1.getNumberOfBadges()))
                .forEach(System.out::print);


    }
}
