package Demo_06_PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int numberOfBadges;

    private List<Pokemon> pokemonsList;

    public Trainer(String name) {
        this.name = name;
        this.numberOfBadges = 0;
        this.pokemonsList = new ArrayList<>();
    }

    public List<Pokemon> getPokemonsList() {
        return pokemonsList;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    //проверка дали някой покемон от конкретния списък съдържа  конкретната команда и добавяне на 1 badge
    public boolean isExist(Trainer trainer, String command) {
        boolean isExist = false;
        for (Pokemon pokemon1 : pokemonsList) {
            if (pokemon1.getElement().equals(command)) {
                this.numberOfBadges++;
                isExist = true;
            }
        }
        return isExist;
    }

    //премахва на всеки покемон от списъка на дадения треньор по 10 здраве
    public void removeHealth(Trainer trainer){
        for (Pokemon pokemon1 : pokemonsList) {
            int currentHealth = pokemon1.getHealth() - 10;
            pokemon1.setHealth(currentHealth);
        }
    }

    //премахва покемони от списъка със здраве < 1
    public void removePokemon(Trainer trainer){
        for (Pokemon pokemon1 : new ArrayList<Pokemon>(pokemonsList) ) {
            if (pokemon1.getHealth() < 1){
                this.pokemonsList.remove(pokemon1);
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%s %d %d%n", this.name, this.numberOfBadges, this.pokemonsList.size());
    }
}
