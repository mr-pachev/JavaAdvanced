package Exams_AnimalShelter_03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Shelter {
    private List<Animal> data;
    private int capacity;

    public Shelter(int capacity) {
        this.data = new ArrayList<>();
        this.capacity = capacity;
    }

    public void add(Animal animal) {
        if (capacity > data.size()) {
            this.data.add(animal);
        }
    }

    public boolean remove(String name) {
        boolean isRemoved = false;

        for (Animal animal : data) {
            if (animal.getName().equals(name)) {
                data.remove(animal);
                isRemoved = true;
                break;
            }
        }
        return isRemoved;
    }

    public Animal getAnimal(String name, String caretaker){
        for (Animal animal : data) {
            if (animal.getName().equals(name) && animal.getCaretaker().equals(caretaker)) {
                return animal;
            }
        }
        return null;
    }

    public Animal getOldestAnimal() {
        Animal oldestAnimal = new Animal("", 0, "");
        for (Animal animal : this.data) {
            if (animal.getAge() > oldestAnimal.getAge()) {
                oldestAnimal = animal;
            }
        }
        return oldestAnimal;
    }

    public int getCount(){
        return this.data.size();
    }

    public String getStatistics(){
        StringBuilder builder = new StringBuilder();

        builder.append("The shelter has the following animals:" + System.lineSeparator());

        for (Animal animal : data){
            builder.append(animal.getName() + " " + animal.getCaretaker() + System.lineSeparator());
        }
        return builder.toString();
    }
}
