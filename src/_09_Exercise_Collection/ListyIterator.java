package _09_Exercise_Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListyIterator<T> implements Iterable<T> {
    private List<T> list;
    private int index;

    public ListyIterator() {
        this.list = new ArrayList<T>();
        this.index = 0;
    }

    public void addElement(T el) {
        this.list.add(el);
    }

    public boolean move() {
        if (hasNext()) {
            this.index++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        return this.index < this.list.size() - 1;
    }

    public void print() {
        if (this.list.isEmpty()) {
            System.out.println("Invalid Operation!");
        } else {
            System.out.println(list.get(this.index));
        }
    }

    public void printAll() {
        for (T el : list) {
            System.out.print(el + " ");
        }
        System.out.println();
    }

    @Override
    public Iterator<T> iterator() {
        return new CustomIterator();
    }

    private class CustomIterator implements Iterator<T> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < list.size() - 1;
        }

        @Override
        public T next() {
            return list.get(index++);
        }
    }
}

