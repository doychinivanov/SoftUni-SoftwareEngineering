package farmville;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FarmTest {
    private static final String FARM_NAME = "TEST_NAME";
    private static final String ANIMAL_TYPE = "Cow";

    @Test
    public void constructorShouldCreateProperObject() {
        String farmName = FARM_NAME;
        int farmCapacity = 5;

        Farm farm = new Farm(farmName, farmCapacity);

        Assert.assertEquals(farm.getName(), farmName);
        Assert.assertEquals(farm.getCapacity(), farmCapacity);
        Assert.assertEquals(farm.getCount(), 0);
    }

    @Test (expected = NullPointerException.class)
    public void constructorWithBothWrongParamsShouldThrowForNameFirst() {
        new Farm(null, -1);
    }

    @Test (expected = NullPointerException.class)
    public void constructorWithBothWrongParamsShouldThrowForNameFirst2() {
        new Farm("", -1);
    }

    @Test (expected = NullPointerException.class)
    public void constructorShouldThrowErrorForNullName(){
        new Farm(null, 15);
    }

    @Test (expected = NullPointerException.class)
    public void constructorShouldThrowErrorForEmptyName(){
        new Farm("     ", 15);
    }


    @Test (expected = IllegalArgumentException.class)
    public void constructorShouldThrowErrorForNegativeCapacity() {
        new Farm(FARM_NAME, -1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void addMethodShouldThrowExceptionWhenNoRoom() {
        Farm currentFarm = new Farm(FARM_NAME, 0);

        Assert.assertEquals(currentFarm.getCapacity(), 0);
        Assert.assertEquals(currentFarm.getCount(), 0);

        currentFarm.add(new Animal(ANIMAL_TYPE, 1));
    }

    @Test (expected = IllegalArgumentException.class)
    public void addMethodShouldFailWhenAddingAnAnimalTwice() {
        Farm currentFarm = new Farm(FARM_NAME, 2);
        Animal someAnimal = new Animal(ANIMAL_TYPE, 5);
        Animal otherAnimal = new Animal(ANIMAL_TYPE, 1);

        currentFarm.add(someAnimal);
        currentFarm.add(otherAnimal);
    }

    @Test
    public void addMethodShouldBeExecutedCorrectly() {
        Farm currentFarm = new Farm(FARM_NAME, 2);
        Animal someAnimal = new Animal(ANIMAL_TYPE, 5);

        Assert.assertEquals(currentFarm.getCount(), 0);

        currentFarm.add(someAnimal);

        Assert.assertEquals(currentFarm.getCount(), 1);
    }

    @Test
    public void removeMethodShouldRemoveAnimal(){
        Farm farm = new Farm(FARM_NAME, 5);
        Assert.assertEquals(0, farm.getCount());

        farm.add(new Animal(ANIMAL_TYPE, 1));

        Assert.assertEquals(1, farm.getCount());
        Assert.assertTrue(farm.remove(ANIMAL_TYPE));
        Assert.assertEquals(0, farm.getCount());
    }

    @Test
    public void removeMethodShouldNotRemoveAnimal(){
        Farm farm = new Farm(FARM_NAME, 5);
        Assert.assertEquals(0, farm.getCount());

        farm.add(new Animal(ANIMAL_TYPE, 1));

        Assert.assertEquals(1, farm.getCount());
        Assert.assertFalse(farm.remove("Dog"));
        Assert.assertEquals(1, farm.getCount());
    }
}