package vehiclesExtension;

public class Car extends VehicleImp {
    private final static double ADDITIONAL_CONSUMPTION_WITH_AC = 0.9;

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + ADDITIONAL_CONSUMPTION_WITH_AC);
    }
}
