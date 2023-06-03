package _Exams_Kindergarden_03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Kindergarten {
    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();
    }

    public boolean addChild(Child child) {
        boolean isAdded = false;
        if (capacity > registry.size()) {
            registry.add(child);
            isAdded = true;
        }
        return isAdded;
    }

    public boolean removeChild(String firstName) {
        boolean isRemoved = false;
        for (Child child : new ArrayList<Child>(registry)) {
            if (child.getFirstName().equals(firstName)) {
                registry.remove(child);
                isRemoved = true;
            }
        }
        return isRemoved;
    }

    public int getChildrenCount() {
        return registry.size();
    }

    public Child getChild(String firstName) {
        Child child = null;
        for (Child currentChild : registry) {
            if (currentChild.getFirstName().equals(firstName)) {
                child = currentChild;
                break;
            }
        }
        return child;
    }

    public String registryReport() {
        this.registry = this.registry.stream()
                .sorted(Comparator.comparing(Child::getAge).thenComparing(Child::getFirstName).thenComparing(Child::getLastName))
                .collect(Collectors.toList());


        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Registered children in %s:", name));

        registry.forEach(currentChild -> {
            builder.append(System.lineSeparator());
            builder.append("--");
            builder.append(System.lineSeparator());
            builder.append(currentChild.toString());
        });
        return builder.toString().trim();
    }
}
