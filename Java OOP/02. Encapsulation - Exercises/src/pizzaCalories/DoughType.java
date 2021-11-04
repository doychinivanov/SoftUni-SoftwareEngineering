package pizzaCalories;

public enum DoughType {
    WHITE(1.5),
    WHOLEGRAIN(1.0);

    private final double value;

    DoughType(double value){
        this.value = value;
    }

    public double getValue() {
        return this.value;
    }
}
