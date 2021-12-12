package catHouse.core;

import catHouse.common.ConstantMessages;
import catHouse.common.ExceptionMessages;
import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller{
    private ToyRepository toys;
    private Collection<House> houses;

    public ControllerImpl() {
        this.toys = new ToyRepository();
        this.houses = new ArrayList<>();
    }

    @Override
    public String addHouse(String type, String name) {

        House newHouse = null;

        switch (type) {
            case "LongHouse" :
                newHouse = new LongHouse(name);
                break;
            case "ShortHouse":
                newHouse = new ShortHouse(name);
                break;
            default:
                throw new NullPointerException(ExceptionMessages.INVALID_HOUSE_TYPE);
        }

        this.houses.add(newHouse);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
    }

    @Override
    public String buyToy(String type) {
        Toy newToy = null;

        switch (type) {
            case "Ball" :
                newToy = new Ball();
                break;
            case "Mouse":
                newToy = new Mouse();
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_TOY_TYPE);
        }

        this.toys.buyToy(newToy);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        Toy requiredToy = this.toys.findFirst(toyType);

        if(requiredToy == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_TOY_FOUND, toyType));
        }

        House houseBuyer = this.houses.stream().filter(x -> x.getName().equals(houseName)).findFirst().orElse(null);

        houseBuyer.buyToy(requiredToy);
        this.toys.removeToy(requiredToy);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        Cat newCat = null;

        switch (catType) {
            case "LonghairCat" :
                newCat = new LonghairCat(catName, catBreed, price);
                break;
            case "ShorthairCat" :
                newCat = new ShorthairCat(catName, catBreed, price);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_CAT_TYPE);
        }

        House houseBuyer = this.houses.stream().filter(x -> x.getName().equals(houseName)).findFirst().orElse(null);
        String houseType = houseBuyer.getClass().getSimpleName();

        if(houseType.equals("LongHouse") && catType.equals("ShorthairCat") || houseType.equals("ShortHouse") && catType.equals("LonghairCat")) {
            return ConstantMessages.UNSUITABLE_HOUSE;
        } else {
            houseBuyer.addCat(newCat);

            return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
        }
    }

    @Override
    public String feedingCat(String houseName) {
        House targetHouse = this.houses.stream().filter(x -> x.getName().equals(houseName)).findFirst().orElse(null);

        targetHouse.feeding();

        return String.format(ConstantMessages.FEEDING_CAT, targetHouse.getCats().size());
    }

    @Override
    public String sumOfAll(String houseName) {
        House targetHouse = this.houses.stream().filter(x -> x.getName().equals(houseName)).findFirst().orElse(null);

        Collection<Cat> houseCats = targetHouse.getCats();
        Collection<Toy> houseToys = targetHouse.getToys();

        double totalCatPrice = houseCats.stream().mapToDouble(Cat::getPrice).sum();
        double totalToysPrice = houseToys.stream().mapToDouble(Toy::getPrice).sum();

        double totalHouseValue = totalCatPrice + totalToysPrice;

        return String.format(ConstantMessages.VALUE_HOUSE, houseName, totalHouseValue);
    }

    @Override
    public String getStatistics() {
        StringBuilder result = new StringBuilder();

        this.houses.forEach(house -> result.append(house.getStatistics()));

        return result.toString().trim();
    }
}
