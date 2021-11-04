package pizzaCalories;

public enum ToppingModifiers {
    MEAT(1.2),
    VEGGIES(0.8),
    CHEESE(1.1),
    SAUCE(0.9);


    private final double value;

    ToppingModifiers(double value){
        this.value = value;
    }

    public double getValue() {
        return this.value;
    }
}
