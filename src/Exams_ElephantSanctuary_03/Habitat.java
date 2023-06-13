import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Habitat {
    private List<Elephant> data;
    private int capacity;

    public Habitat(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Elephant elephant) {
        if (capacity > data.size()) {
            this.data.add(elephant);
        }
    }

    public boolean remove(String name) {
        boolean isRemoved = false;
        for (Elephant elephant : data) {
            if (elephant.getName().equals(name)) {
                this.data.remove(elephant);
                isRemoved = true;
                break;
            }
        }
        return isRemoved;
    }

    public Elephant getElephant(String retiredFrom) {
        for (Elephant elephant : data) {
            if (elephant.getRetiredFrom().equals(retiredFrom)) {
                return elephant;
            }
        }
        return null;
    }

    public Elephant getOldestElephant() {
        return this.data.stream().max(Comparator.comparingInt(Elephant::getAge)).get();
    }

    public int getAllElephants(){
        return  this.data.size();
    }

    public String getReport(){
        StringBuilder builder = new StringBuilder();
        builder.append("Saved elephants in the park:" + System.lineSeparator());

        for (Elephant elephant : data){
            builder.append(elephant.getName() + " came from: " + elephant.getRetiredFrom() + System.lineSeparator());
        }
        return builder.toString();
    }
}
