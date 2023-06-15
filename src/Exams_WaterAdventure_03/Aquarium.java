package Exams_WaterAdventure_03;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private List<Fish> fishInPool;
    private String name;
    private int capacity;
    private int size;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public int getFishInPool() {
        return fishInPool.size();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public void add(Fish fish) {
        if (!fishInPool.contains(fish) && capacity > fishInPool.size()) {
            fishInPool.add(fish);
        }
    }

    public boolean remove(String name) {
        boolean isRemoved = false;

        for (Fish fish : fishInPool) {
            if (fish.getName().equals(name)) {
                fishInPool.remove(fish);
                isRemoved = true;
                break;
            }
        }
        return isRemoved;
    }

    public Fish findFish(String name) {
        for (Fish fish : fishInPool) {
            if (fish.getName().equals(name)) {
                return fish;
            }
        }
        return null;
    }

    public String report() {
        StringBuilder builder = new StringBuilder();
        builder.append("Aquarium: ").append(name).append(" ^ Size: ").append(getSize());
        for (Fish fish : fishInPool) {
            builder.append(System.lineSeparator());
            builder.append(fish);
        }
        return builder.toString();
    }
}
