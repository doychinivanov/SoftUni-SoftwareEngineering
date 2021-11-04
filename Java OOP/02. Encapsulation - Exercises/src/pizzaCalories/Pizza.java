package pizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private final int numberOfToppings;

    public Pizza (String name, int numberOfToppings) {
        setName(name);
        setToppings(numberOfToppings);
        this.numberOfToppings = numberOfToppings;
    }

    private void setName(String name) {
        if (name == null || name.isEmpty() || name.trim().isEmpty() || name.trim().length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        } else {
            this.name = name;
        }
    }

    public void setDough (Dough dough){
        this.dough = dough;
    }

    private void setToppings (int numberOfToppings) {
        if (numberOfToppings < 0 || numberOfToppings > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        } else {
            this.toppings = new ArrayList<>();
        }
    }

    public String getName() {
        return this.name;
    }

    public void addTopping (Topping topping) {
        if (this.toppings.size() < this.numberOfToppings) {
            this.toppings.add(topping);
        }
    }

    public double getOverallCalories () {
        double toppingCalories = this.toppings.stream().mapToDouble(Topping::calculateCalories).sum();

        return toppingCalories + dough.calculateCalories();
    }

    @Override
    public String toString () {
        return String.format("%s - %.2f", getName(), getOverallCalories());
    }
}

