package Exams_AutomotiveRepairShop_03_Final.Exams_AutomotiveRepairShop_03_Final;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RepairShop {
    private List<Vehicle> vehicles;
    private int capacity;

    public RepairShop(int capacity) {
        this.capacity = capacity;
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle){
        if (capacity > vehicles.size()){
            vehicles.add(vehicle);
        }
    }

    public boolean removeVehicle(String vin){
        boolean isRemoved = false;
        for (Vehicle vehicle : vehicles){
            if (vehicle.getVIN().equals(vin)){
                vehicles.remove(vehicle);
                isRemoved = true;
                return isRemoved;
            }
        }
        return isRemoved;
    }

    public int getCount(){
        return vehicles.size();
    }

    public Vehicle getLowestMileage(){
        return this.vehicles.stream().min(Comparator.comparingInt(Vehicle::getMileage)).get();
    }

    public String report(){
        StringBuilder builder = new StringBuilder();
        builder.append("Vehicles in the preparatory:");

        for (Vehicle vehicle : vehicles){
            builder.append(System.lineSeparator()).append(vehicle);
        }
        return builder.toString();
    }
}
