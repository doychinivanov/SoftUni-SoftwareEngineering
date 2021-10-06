package RawData;

public class Tires {
    private double pressure;
    private int age;

    public Tires(double pressure, int age){
        this.pressure = pressure;
        this.age = age;
    }

    public double getPressure() {
        return this.pressure;
    }

    public int getAge() {
        return this.age;
    }

    public boolean pressureIsUnderOne(){
        return this.pressure < 1;
    }
}
