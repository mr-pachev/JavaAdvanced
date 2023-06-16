package Exams_Hotel_03;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Person> roster;
    private String name;
    private int capacity;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person) {
        if (capacity > roster.size()) {
            roster.add(person);
        }
    }

    public boolean remove(String name) {
        boolean isRemoved = false;
        for (Person person : roster) {
            if (person.getName().equals(name)) {
                isRemoved = true;
                roster.remove(person);
                break;
            }
        }
        return isRemoved;
    }

    public Person getPerson(String name, String hometown) {
        for (Person person : roster) {
            if (person.getName().equals(name) && person.getHometown().equals(hometown)) {
                return person;
            }
        }
        return null;
    }

    public int getCount(){
        return roster.size();
    }

    public String getStatistics(){
        StringBuilder builder = new StringBuilder();

        builder.append("The people in the hotel ").append(name).append(" are:");
        for (Person person : roster){
            builder.append(System.lineSeparator()).append(person);
        }
        return builder.toString();
    }
}
