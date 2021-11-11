package vehicles;

public class Car extends VehicleImp {
    private final static double ADDITIONAL_CONSUMPTION_WITH_AC = 0.9;

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    public void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + ADDITIONAL_CONSUMPTION_WITH_AC);
    }
}
