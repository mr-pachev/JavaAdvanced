package Demo_06_Exercise_Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;

    private Company company;
    private List<Pokemon> pokemonsList;
    private List<Parents> parentsList;
    private List<Children> childrenList;
    private Car car;

    public Person(String name, Company company, Car car) {
        this.name = name;
        this.company = company;
        this.pokemonsList = new ArrayList<>();
        this.parentsList = new ArrayList<>();
        this.childrenList = new ArrayList<>();
        this.car = car;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemonsList.add(pokemon);
    }

    public void addParents(Parents parents){
        this.parentsList.add(parents);
    }

    public void addChildren(Children children){
        this.childrenList.add(children);
    }

    public Person(List<Pokemon> pokemonsList, List<Parents> parentsList, List<Children> childrenList) {
        this.pokemonsList = pokemonsList;
        this.parentsList = parentsList;
        this.childrenList = childrenList;
    }

    public String getName() {
        return name;
    }

    public Company getCompany() {
        return company;
    }

    public List<Pokemon> getPokemonsList() {
        return pokemonsList;
    }

    public List<Parents> getParentsList() {
        return parentsList;
    }

    public List<Children> getChildrenList() {
        return childrenList;
    }

    public Car getCar() {
        return car;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
