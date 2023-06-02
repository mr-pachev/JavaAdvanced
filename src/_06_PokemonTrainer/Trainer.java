package _06_PokemonTrainer;

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

    //проверка дали някой покемон от конкретния списък съдържа  конкретната команда
    public boolean isExist(String command) {
        for (Pokemon pokemon1 : this.pokemonsList) {
            if (pokemon1.getElement().equals(command)) {
                return true;
            }
        }
        return false;
    }

    //добавя един бадж на треньора->
    public void addBudge() {
        this.numberOfBadges++;
    }

    //премахва на всеки покемон от списъка на дадения треньор по 10 здраве
    public void removeHealth() {
        this.pokemonsList.forEach(p -> p.setHealth(p.getHealth() - 10));
    }

    //премахва покемони от списъка със здраве < 1
    public void removePokemon() {
        this.pokemonsList.removeIf(pokemon1 -> pokemon1.getHealth() < 1);
    }


    @Override
    public String toString() {
        return String.format("%s %d %d%n", this.name, this.numberOfBadges, this.pokemonsList.size());
    }
}
