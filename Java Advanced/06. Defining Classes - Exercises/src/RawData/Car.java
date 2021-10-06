package RawData;

import java.util.List;

public class Car {
    private String model;
    private Engine engine = null;
    private Cargo cargo = null;
    private List<Tires> tires;

    public Car(String model, int engineSpeed, int enginePower, int cargoWeight, String cargoType, List<Tires> tires){
        this.model = model;
        this.engine = new Engine(engineSpeed, enginePower);
        this.cargo = new Cargo(cargoWeight, cargoType);
        this.tires = tires;
    }

    public boolean oneTirePressureIsLessThanOne(){
        boolean exists = false;

        for (int i = 0; i < this.tires.size(); i++) {
            if(this.tires.get(i).pressureIsUnderOne()){
                exists = true;
                break;
            }
        }

        return exists;
    }

    public boolean enginePowerIsBiggerThan250(){
        return this.engine.getPower() > 250;
    }

    public String getModel() {
        return this.model;
    }

    public Cargo getCargo() {
        return this.cargo;
    }

    public List<Tires> getTires() {
        return this.tires;
    }
}
