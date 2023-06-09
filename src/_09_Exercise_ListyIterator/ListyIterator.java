package _09_Exercise_ListyIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListyIterator {
    private List<String> list;
    private int index;

    public ListyIterator() {
        this.list = new ArrayList<>();
        this.index = 0;
    }

    public void addElement (String el){
        this.list.add(el);
    }

    public boolean move (){
        if (hasNext()){
           this.index++;
           return true;
        }
        return false;
    }

    public boolean hasNext(){
        return this.index < this.list.size() - 1;
    }

    public void print (){
        if (this.list.isEmpty()){
            System.out.println("Invalid Operation!");
        }else {
            System.out.println(list.get(this.index));
        }
    }
}
