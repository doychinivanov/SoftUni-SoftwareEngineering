package CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine){
        this.model = model;
        this.engine = engine;
        this.weight = -1;
        this.color = "n/a";
    }

    public Car(String model, Engine engine, int weight){
        this(model, engine);
        this.weight = weight;
    }

    public Car(String model, Engine engine, String color){
        this(model, engine);
        this.color = color;
    }

    public Car(String model, Engine engine, int weight, String color){
        this(model, engine);
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();

        result.append(this.model).append(":").append(System.lineSeparator());
        result.append(this.engine.toString());
        result.append("Weight: ");

        if(this.weight == -1){
            result.append("n/a").append(System.lineSeparator());
        } else {
            result.append(this.weight).append(System.lineSeparator());
        }

        result.append("Color: ").append(this.color);

        return result.toString();
    }
}
