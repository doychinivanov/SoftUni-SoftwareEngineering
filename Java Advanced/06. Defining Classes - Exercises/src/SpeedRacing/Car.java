package SpeedRacing;

public class Car {
    private String model;
    private double fuel;
    private double perOneKm;
    private double passedDistance;

    public Car(String model, double fuel, double perOneKm){
        this.model = model;
        this.fuel = fuel;
        this.perOneKm = perOneKm;
        this.passedDistance = 0.0;
    }

    public void travel(Double distanceToPass){
        if(distanceToPass * this.perOneKm <= this.fuel){
            this.fuel -= distanceToPass * this.perOneKm;
            this.passedDistance += distanceToPass;
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }

    @Override
    public String toString(){
        return String.format("%s %.2f %.0f", this.model, this.fuel, this.passedDistance);
    }
}
