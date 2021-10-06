package PokemonTrainer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Trainer {
    private String name;
    private int badges;
    private List<Pokemon> collection;

    public Trainer(String name) {
        this.name = name;
        this.badges = 0;
        this.collection = new ArrayList<>();
    }

    public int getBadges() {
        return this.badges;
    }

    public String getName() {
        return this.name;
    }

    public List<Pokemon> getCollection() {
        return this.collection;
    }

    public int getCollectionAmount(){
        return this.collection.size();
    }

    public void increaseBadges() {
        this.badges++;
    }

    public void filterDeathPokemons(){
        this.collection = this.collection.stream().filter(pokemon -> pokemon.getHealth() > 0).collect(Collectors.toList());
    }

    public boolean hasAtLeastOneOfCertainType(String type){
        return this.collection
                .stream()
                .filter(pokemon -> pokemon.getElement().equals(type)).count() >= 1;
    }

    @Override
    public String toString(){
        return String.format("%s %d %d", this.name, this.badges, this.getCollectionAmount());
    }
}
