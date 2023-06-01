package Demo_06_PokemonTrainer;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Trainer trainer = null;
        Pokemon pokemon = null;

        Map<String, Trainer> trainersMap = new LinkedHashMap<>();    //съдържа име на треньор и характеристиките му

        while (!input.equals("Tournament")) {
            String[] dataInput = input.split(" ");

            String trainerName = dataInput[0];
            String pokemonName = dataInput[1];
            String pokemonElement = dataInput[2];
            int pokemonHealth = Integer.parseInt(dataInput[3]);

            pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            if (trainersMap.containsKey(trainerName)) {
                trainer = trainersMap.get(trainerName);
            } else {
                trainer = new Trainer(trainerName);
            }
            trainer.getPokemonsList().add(pokemon);
            trainersMap.put(trainerName, trainer);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!input.equals("End")) {
            String command = input;

            for (Map.Entry<String, Trainer> entry : trainersMap.entrySet()) {
                trainer = entry.getValue();                             //конкретен списък с покемони на конкретен треньор

                if (!trainer.isExist(trainer, command)) {
                    trainer.removeHealth(trainer);
                }

                trainer.removePokemon(trainer);
            }

            input = scanner.nextLine();
        }

        //сортиране на мапа само по стойност на value в низходящ ред впротивен случай важи подредбата на LinkedTreeMap-а
      trainersMap.values().stream()
              .sorted((n1, n2) -> Integer.compare(n2.getNumberOfBadges(), n1.getNumberOfBadges()))
              .forEach(System.out::print);


    }
}
