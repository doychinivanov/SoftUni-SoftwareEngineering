package shoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if(name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }

        this.name = name;
    }

    private void setMoney(double money) {
        if(money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }

        this.money = money;
    }

    public void buyProduct (Product product) throws Exception {
        if (this.money >= product.getCost()) {
            this.products.add(product);
            this.money -= product.getCost();

            System.out.println(String.format("%s bought %s", getName(), product.getName()));
        } else {
            throw new Exception(String.format("%s can't afford %s", getName(), product.getName()));
        }

    }

    @Override
    public String toString () {
        List<String> boughtProducts = new ArrayList<>();

        if(this.products.isEmpty()){
            return String.format("%s – Nothing bought", getName());
        }

        this.products.forEach(product -> {
            boughtProducts.add(product.getName());
        });

        return String.format("%s - %s", getName(), String.join(", ", boughtProducts));


    }
}
