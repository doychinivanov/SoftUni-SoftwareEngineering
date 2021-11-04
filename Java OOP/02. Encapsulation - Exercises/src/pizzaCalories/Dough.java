package pizzaCalories;

import java.util.Locale;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough (String flourType, String bakingTechnique, double weight){
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if(flourType != null && !flourType.trim().isEmpty() && isValidTypeOfFlour(flourType.trim())){
            this.flourType = flourType;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }

    }

    private void setBakingTechnique(String bakingTechnique) {
        if (bakingTechnique != null && !bakingTechnique.trim().isEmpty() && isValidTypeTechnique(bakingTechnique.trim())) {
            this.bakingTechnique = bakingTechnique;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setWeight(double weight) {
        if (weight >= 1 && weight <= 200) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
    }

    public double calculateCalories() {
        return (2 * this.weight) * DoughType.valueOf(this.flourType.toUpperCase(Locale.ROOT)).getValue() * BakingTechniques.valueOf(this.bakingTechnique.toUpperCase(Locale.ROOT)).getValue();
    }

    private boolean isValidTypeOfFlour(String test){
        for(DoughType topping : DoughType.values()){
            if(topping.name().equals(test.toUpperCase(Locale.ROOT))){
                return true;
            }
        }

        return false;
    }

    private boolean isValidTypeTechnique(String test){
        for(BakingTechniques topping : BakingTechniques.values()){
            if(topping.name().equals(test.toUpperCase(Locale.ROOT))){
                return true;
            }
        }

        return false;
    }
}
