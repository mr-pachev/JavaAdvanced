package _06_Exercise_CarSalesman;

public class Engine {

    private String model;
    private int power;
    private String displacement;
    private int separator;
    private String efficiency;

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
        this.displacement = "n/a";
        this.efficiency = "n/a";
    }

    public Engine(String model, int power, String displacement, int separator) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.separator = separator;
        this.efficiency = "n/a";
    }

    public Engine(String model, int power, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = "n/a";
        this.efficiency = efficiency;
    }

    public Engine(String model, int power, String displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public String getModel() {
        return model;
    }

    public String getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public int getPower() {
        return power;
    }
}
