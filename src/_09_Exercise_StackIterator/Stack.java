package _09_Exercise_StackIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Stack<T> implements Iterator<T> {

    private List<T> elementsList;
    private int currentIndex;

    public Stack() {
        this.currentIndex = -1;
        this.elementsList = new ArrayList<>();
    }

    public void puch(T element) {
        this.elementsList.add(element);
        currentIndex = currentIndex + 1;
    }

    public void pop() {
        if (this.elementsList.isEmpty()) {
            System.out.println("No elements");
        } else {
            this.elementsList.remove(currentIndex);
            currentIndex--;
        }
    }

    @Override
    public boolean hasNext() {
        return this.currentIndex < elementsList.size() - 1;
    }

    @Override
    public T next() {
        return this.elementsList.get(currentIndex++);
    }

    public void printStack(){
        for (int i = this.elementsList.size() - 1; i >= 0; i--) {
            System.out.println(elementsList.get(i));
        }
        for (int i = this.elementsList.size() - 1; i >= 0; i--) {
            System.out.println(elementsList.get(i));
        }
    }
}
