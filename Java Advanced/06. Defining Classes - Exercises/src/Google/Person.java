package Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name = null;
    private Company company = null;
    private Car car  = null;

    private final List<Pokemon> pokemons;
    private final List<Parent> parents;
    private final List<Child> children;

    public Person(String name){
        this.name = name;
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public Company getCompany() {
        return this.company;
    }

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public List<Parent> getParents() {
        return this.parents;
    }

    public List<Child> getChildren() {
        return this.children;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();

        result.append(this.name).append(System.lineSeparator());
        result.append("Company:").append(System.lineSeparator());

        if (this.company != null) {
            result.append(this.company.toString()).append(System.lineSeparator());
        }

        result.append("Car:").append(System.lineSeparator());
        if (this.car != null) {
            result.append(this.car).append(System.lineSeparator());
        }

        result.append("Pokemon:").append(System.lineSeparator());
        if(this.pokemons.size() > 0){
            this.pokemons.forEach(pokemon -> result.append(pokemon.toString()).append(System.lineSeparator()));
        }

        result.append("Parents:").append(System.lineSeparator());
        if(this.parents.size() > 0){
            this.parents.forEach(parent -> result.append(parent.toString()).append(System.lineSeparator()));
        }

        result.append("Children:").append(System.lineSeparator());
        if(this.children.size() > 0){
            this.children.forEach(child -> result.append(child.toString()).append(System.lineSeparator()));
        }

        return result.toString();
    }
}
