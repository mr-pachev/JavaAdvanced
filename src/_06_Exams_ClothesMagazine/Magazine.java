package _06_Exams_ClothesMagazine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Magazine {
    private List<Cloth> data;
    private String type;
    private int capacity;

    public Magazine(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }


    public void addCloth(Cloth cloth) {
        if (capacity > data.size()) {
            this.data.add(cloth);
        }
    }

    public boolean removeCloth(String color) {

        boolean isRemoved = false;
        for (Cloth cloth : new ArrayList<Cloth>(data)) {
            if (cloth.getColor().equals(color)) {
                data.remove(cloth);
                isRemoved = true;
            }
        }
        return isRemoved;
    }

    public Cloth getSmallestCloth() {
        int small = 100;
        Cloth cloth = null;
        for (Cloth currentCloth : data) {
            if (currentCloth.getSize() <= small) {
                small = currentCloth.getSize();
                cloth = currentCloth;
            }
        }
        return cloth;
    }


    public Cloth getCloth(String color) {
        Cloth cloth = null;
        for (Cloth currentcloth : data) {
            if (currentcloth.getColor().equals(color)) {
                cloth = currentcloth;
            }
        }
        return cloth;
    }


    public int getCount() {
        return data.size();
    }


    public String report() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("%s magazine contains:", type)).trimToSize();
        result.append(System.lineSeparator());
        data.stream()
                .forEach(cloth -> {
                    result.append(cloth.toString());
                    result.append(System.lineSeparator());
                });
        return result.toString().trim();
    }
//    public String report() {
//
//        StringBuilder sb = new StringBuilder();
//        sb.append(String.format("%s magazine contains:%n", type)).trimToSize();
//
//        data.forEach(egg -> sb.append(egg.toString()).append(String.format("%n")));
//
//        return sb.toString().trim();
//    }
}
