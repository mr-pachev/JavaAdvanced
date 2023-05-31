package Demo_06_Exercise_CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private String weight;
    private int separator;
    private String color;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = "n/a";
        this.color = "n/a";
    }

    public Car(String model, Engine engine, String weight) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = "n/a";
    }

    public Car(String model, Engine engine, int separator, String color) {
        this.model = model;
        this.engine = engine;
        this.separator = separator;
        this.weight = "n/a";
        this.color = color;
    }

    public Car(String model, Engine engine, String weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public Engine getEngine() {
        return engine;
    }
}
