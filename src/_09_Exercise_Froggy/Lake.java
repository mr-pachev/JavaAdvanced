package _09_Exercise_Froggy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer> {

    private List<Integer> lakeList;
    private int index;


    public Lake() {
        this.lakeList = new ArrayList<>();
        this.index = 0;
    }

    public void addElement(int element) {
        this.lakeList.add(element);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }


    private class Frog implements Iterator<Integer> {


        @Override
        public boolean hasNext() {
            return index < lakeList.size()-1;
        }

        @Override
        public Integer next() {
            return lakeList.get(index++);
        }
    }

    public void printLake() {
        for (int i = 0; i < lakeList.size(); i++) {
            if (i % 2 == 0) {
                System.out.printf("%d, ", lakeList.get(i));
                index++;
            }
        }

        for (int j = 0; j < lakeList.size(); j++) {
            if (j % 2 != 0 && iterator().hasNext()) {
                System.out.printf("%d, ", lakeList.get(j));
                index++;
            }else if(!iterator().hasNext() && j % 2 != 0){
                System.out.println(lakeList.get(j));
            }
        }

    }
}

