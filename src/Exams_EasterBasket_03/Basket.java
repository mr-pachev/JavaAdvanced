package Exams_EasterBasket_03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Basket {
    private List<Egg> data;
    private String material;
    private int capacity;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addEgg(Egg egg) {
        if (capacity > data.size()) {
            this.data.add(egg);
        }
    }

    public boolean removeEgg(String color) {
        boolean isRemoved = false;

        for (Egg egg : data) {
            if (egg.getColor().equals(color)) {
                this.data.remove(egg);
                isRemoved = true;
                break;
            }
        }
        return isRemoved;
    }

    public Egg getStrongestEgg() {
        return this.data.stream().max(Comparator.comparingInt(Egg::getStrength)).get();
    }

    public Egg getEgg(String color) {
        for (Egg egg : data) {
            if (egg.getColor().equals(color)) {
                return egg;
            }
        }
        return null;
    }

    public int getCount() {
        return this.data.size();
    }

    public String report() {
        StringBuilder builder = new StringBuilder();

        builder.append(material).append(" basket contains:");

        for (Egg egg : data) {
            builder.append(System.lineSeparator());
            builder.append(egg);
        }
        return builder.toString();
    }
}
