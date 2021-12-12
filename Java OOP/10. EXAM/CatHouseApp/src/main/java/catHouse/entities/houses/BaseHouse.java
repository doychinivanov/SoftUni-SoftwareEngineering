package catHouse.entities.houses;

import catHouse.common.ConstantMessages;
import catHouse.common.ExceptionMessages;
import catHouse.entities.cat.Cat;
import catHouse.entities.toys.Toy;
import catHouse.utils.StringValidator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class BaseHouse implements House{
    private String name;
    private int capacity;
    private Collection<Toy> toys;
    private Collection<Cat> cats;

    protected BaseHouse (String name, int capacity) {
        setName(name);
        setCapacity(capacity);
        this.toys = new ArrayList<>();
        this.cats = new ArrayList<>();
    }

    private void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int sumSoftness() {
        return toys.stream()
                .mapToInt(Toy::getSoftness)
                .sum();
    }

    @Override
    public void addCat(Cat cat) {
        if (this.capacity == this.cats.size()) {
            throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_CAT);
        }

        this.cats.add(cat);
    }

    @Override
    public void removeCat(Cat cat) {
        this.cats.remove(cat);
    }

    @Override
    public void buyToy(Toy toy) {
        this.toys.add(toy);
    }

    @Override
    public void feeding() {
        this.cats.forEach(Cat::eating);
    }

    @Override
    public String getStatistics() {
        StringBuilder result = new StringBuilder();

        result.append(String.format("%s %s:", this.name, this.getClass().getSimpleName())).append(System.lineSeparator());
        result.append("Cats: ");

        if(this.cats.size() > 0) {
            List<String> catNames = new ArrayList<>();

            this.cats.forEach(cat -> catNames.add(cat.getName()));

            result.append(String.join(" ", catNames)).append(System.lineSeparator());
        } else {
            result.append("none").append(System.lineSeparator());
        }

        result.append(String.format("Toys: %d Softness: %d", this.toys.size(), this.sumSoftness())).append(System.lineSeparator());

        return result.toString();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (!StringValidator.isValidName(name)) {
            throw new NullPointerException(ExceptionMessages.HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    @Override
    public Collection<Cat> getCats() {
        return this.cats;
    }

    @Override
    public Collection<Toy> getToys() {
        return this.toys;
    }
}
