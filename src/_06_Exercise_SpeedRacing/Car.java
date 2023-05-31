package _06_Exercise_SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;              //количество гориво->в парична равностойност
    private double fuelCostPerKm;          //колко стрява за изминат километър
    private int distanceTravel;

    public Car(String model, double fuelAmount, double fuelCostPerKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPerKm = fuelCostPerKm;
        this.distanceTravel = 0;
    }

    public boolean isTravel(int kmForTravel) {
        double needSumForKm = this.fuelCostPerKm * kmForTravel;     //парична равностойност на км за пътуването
        if (needSumForKm <= this.fuelAmount){
            this.fuelAmount -= needSumForKm;                        //паричната стойност на километрите, които може да измине колата намаляват
            this.distanceTravel += kmForTravel;                     //изминатите километри се увеличават
            return true;
        }else {
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distanceTravel);
    }
}
