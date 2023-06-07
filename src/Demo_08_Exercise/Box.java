package Demo_08_Exercise;

import java.util.ArrayList;
import java.util.List;

public class Box <T>{
    private T inputData;
    private List<T> dataList;

    public Box(T inputData) {
        this.inputData = inputData;
        this.dataList = new ArrayList<>();
    }

    //добавя елемнет към списъка
    public void addElement (T element){
        this.dataList.add(element);
    }

    //разменя елементитет на подадените индекси
    public void swap(int firstIndex, int secondIndex){
        T firtsElement = this.dataList.get(firstIndex);
        T secondElement = this.dataList.get(secondIndex);

        this.dataList.set(firstIndex, secondElement);
        this.dataList.set(secondIndex, firtsElement);
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < dataList.size(); i++) {
            builder.append(String.format("%s: %s", inputData.getClass().getName(), dataList.get(i)));
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }
}
