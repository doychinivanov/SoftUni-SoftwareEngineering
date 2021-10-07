package CarSalesman;

public class Engine {
    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    public Engine(String model, int power){
        this.model = model;
        this.power = power;
        this.displacement = -1;
        this.efficiency = "n/a";
    }

    public Engine(String model, int power, int displacement){
        this(model, power);
        this.displacement = displacement;
    }

    public Engine(String model, int power, String efficiency){
        this(model, power);
        this.efficiency = efficiency;
    }

    public Engine(String model, int power, int displacement, String efficiency){
        this(model, power);
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();

        result.append(this.model).append(":").append(System.lineSeparator());
        result.append("Power: ").append(this.power).append(System.lineSeparator());

        result.append("Displacement: ");
        if(this.displacement == -1){
            result.append("n/a").append(System.lineSeparator());
        } else {
            result.append(this.displacement).append(System.lineSeparator());
        }

        result.append("Efficiency: ").append(this.efficiency).append(System.lineSeparator());

        return result.toString();
    }
}
