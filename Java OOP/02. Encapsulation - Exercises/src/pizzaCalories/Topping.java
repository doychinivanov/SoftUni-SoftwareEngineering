package pizzaCalories;

import java.util.Locale;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping (String toppingType, double weight){
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if(toppingType != null && !toppingType.trim().isEmpty() && enumContains(toppingType)){
            this.toppingType = toppingType;
        } else {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }

    }

    private void setWeight(double weight) {
        if(weight >= 1 && weight <= 50){
            this.weight = weight;
        } else {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", this.toppingType));
        }
    }

    public double calculateCalories () {
        return (2 * this.weight) * ToppingModifiers.valueOf(this.toppingType.toUpperCase(Locale.ROOT)).getValue();
    }

    private boolean enumContains(String test){
        for(ToppingModifiers topping : ToppingModifiers.values()){
            if(topping.name().equals(test.toUpperCase(Locale.ROOT))){
                return true;
            }
        }

        return false;
    }

}
