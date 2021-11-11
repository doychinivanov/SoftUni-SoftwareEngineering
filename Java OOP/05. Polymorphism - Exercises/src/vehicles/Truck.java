package vehicles;

public class Truck extends VehicleImp{
    private final static double ADDITIONAL_CONSUMPTION_WITH_AC = 1.6;
    private final static double MAX_FUEL_CAPACITY = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    public void setFuelConsumption(double fuelConsumption){
        super.setFuelConsumption(fuelConsumption + ADDITIONAL_CONSUMPTION_WITH_AC);
    }

    @Override
    public void refuel(double liters){
        super.refuel(liters * MAX_FUEL_CAPACITY);
    }
}
