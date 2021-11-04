package pizzaCalories;

public enum BakingTechniques {
    CRISPY(0.9),
    CHEWY(1.1),
    HOMEMADE(1.0);

    private final double value;

    BakingTechniques(double value){
        this.value = value;
    }

    public double getValue() {
        return this.value;
    }
}
