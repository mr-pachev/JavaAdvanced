package _06_Exercise_RawData;

public class Car {
    private String model;
    private Engine engine;
    private  Cargo cargo;
    private  Tire tire;

    public Car(String model, Engine engine, Cargo cargo, Tire tire) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tire = tire;
    }

    public String getModel() {
        return model;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public boolean isFragile (String condition){
        return condition.equals("fragile") && this.tire.getTire1Pressure() < 1 && this.tire.getTire2Pressure() < 1
                && this.tire.getTire3Pressure() < 1 && (this.tire.getTire1Pressure() < 1 || this.tire.getTire2Pressure() < 1
                                                     || this.tire.getTire3Pressure() < 1 || this.tire.getTire4Pressure() < 1);
    }

    public boolean isFlamable(String condition) {
        int power = this.engine.getEnginePower();
        return condition.equals("flamable") && this.engine.getEnginePower() > 250;
    }

    @Override
    public String toString() {
        return String.format(this.model);
    }
}
