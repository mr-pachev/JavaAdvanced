package Exams_Parrots_03;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private List<Parrot> data;
    private String name;
    private int capacity;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot) {
        if (capacity > data.size()) {
            this.data.add(parrot);
        }
    }

    public boolean remove(String name) {
        boolean isRemoved = false;

        for (Parrot parrot : data) {
            if (parrot.getName().equals(name)) {
                isRemoved = true;
                this.data.remove(parrot);
                break;
            }
        }
        return isRemoved;
    }

    public Parrot sellParrot(String name) {
        for (Parrot parrot : this.data) {
            if (parrot.getName().equals(name)) {
                parrot.setAvailable(false);
                return parrot;
            }
        }
        return null;
    }

    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> sellParrotBySpeciesList = new ArrayList<>();
        for (Parrot parrot : new ArrayList<>(data)) {
            if (parrot.getSpecies().equals(species)) {
                sellParrotBySpeciesList.add(parrot);
                data.remove(parrot);
            }
        }
        return sellParrotBySpeciesList;
    }

    public int count() {
        return data.size();
    }

    public String report() {
        StringBuilder builder = new StringBuilder();
        builder.append("Parrots available at ").append(getName()).append(":");

        for (Parrot parrot : data) {
            if (parrot.isAvailable()) {
                builder.append(System.lineSeparator());
                builder.append(parrot);
            }
        }
        return builder.toString();
    }

}
