package vehicles;

import java.text.DecimalFormat;

public abstract class VehicleImp implements Vehicle{
    private double fuelQuantity;
    private double fuelConsumption;

    public VehicleImp (double fuelQuantity ,double fuelConsumption) {
        setFuelQuantity(fuelQuantity);
        setFuelConsumption(fuelConsumption);
    }

    public double getFuelQuantity() {
        return this.fuelQuantity;
    }

    public double getFuelConsumption() {
        return this.fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    @Override
    public String drive(double distance) {
        double fuelNeeded = distance * this.getFuelConsumption();

        if (fuelNeeded > this.fuelQuantity) {
            return this.getClass().getSimpleName() + " needs refueling";
        }

        this.setFuelQuantity(this.getFuelQuantity() - fuelNeeded);

        DecimalFormat formatter = new DecimalFormat("##.##");
        return String.format("%s travelled %s km", this.getClass().getSimpleName(), formatter.format(distance));
    }

    @Override
    public void refuel(double liters) {
        this.fuelQuantity += liters;
    }

    @Override
    public String toString(){
        return String.format("%s: %.2f", this.getClass().getSimpleName(), getFuelQuantity());
    }
}
