package cats;

import org.junit.Assert;
import org.junit.Test;

public class HouseTests {
    private static final String PROPER_HOUSE_NAME = "test_house";
    private static final int PROPER_CAPACITY_VALUE = 2;
    private static final int EMPTY_CAPACITY = 0;
    private static final int WRONG_CAPACITY = -1;
    private static final String CAT_NAME_VAR1 = "cat_name1";
    private static final String CAT_NAME_VAR2 = "cat_name2";
    private static final String NAME_FOR_NON_EXISTING_CAT = "i_do_not_exist";


    @Test (expected = NullPointerException.class)
    public void constructorShouldFailForNullName() {
        new House(null, PROPER_CAPACITY_VALUE);
    }

    @Test (expected = NullPointerException.class)
    public void constructorShouldFailForEmptyName() {
        new House("   ", PROPER_CAPACITY_VALUE);
    }

    @Test (expected = IllegalArgumentException.class)
    public void constructorShouldFailForNegativeCapacity() {
        new House(PROPER_HOUSE_NAME, WRONG_CAPACITY);
    }

    @Test (expected = IllegalArgumentException.class)
    public void constructorWithBothInvalidParamsShouldFailForCapacity() {
        new House("   ", WRONG_CAPACITY);
    }

    @Test
    public void constructorShouldCreateObject() {
        String houseName = PROPER_HOUSE_NAME;

        House test_house = new House(houseName, PROPER_CAPACITY_VALUE);

        Assert.assertEquals(PROPER_CAPACITY_VALUE, test_house.getCapacity());
        Assert.assertEquals(houseName, test_house.getName());
        Assert.assertEquals(0, test_house.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void addCatMethodShouldFailForNoCapacity() {

        House test_house = new House(PROPER_HOUSE_NAME, EMPTY_CAPACITY);

        test_house.addCat(new Cat(CAT_NAME_VAR1));
    }

    @Test
    public void addMethodShouldWorkCorrectly(){
        House test_house = new House(PROPER_HOUSE_NAME, PROPER_CAPACITY_VALUE);

        test_house.addCat(new Cat(CAT_NAME_VAR1));

        Assert.assertEquals(test_house.getCount(), 1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void removeShouldFailForNonExistingCat() {

        House test_house = new House(PROPER_HOUSE_NAME, PROPER_CAPACITY_VALUE);

        test_house.removeCat(NAME_FOR_NON_EXISTING_CAT);
    }

    @Test
    public void removeShouldRemoveCatProperly() {
        House test_house = new House(PROPER_HOUSE_NAME, PROPER_CAPACITY_VALUE);
        Cat someCat = new Cat(CAT_NAME_VAR1);

        test_house.addCat(someCat);

        Assert.assertEquals(test_house.getCount(), 1);

        test_house.removeCat(CAT_NAME_VAR1);

        Assert.assertEquals(test_house.getCount(), 0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void saleMethodShouldFailForNonExistingCat() {

        House test_house = new House(PROPER_HOUSE_NAME, PROPER_CAPACITY_VALUE);

        test_house.catForSale(NAME_FOR_NON_EXISTING_CAT);
    }

    @Test
    public void saleMethodShouldWorkProperly(){
        House test_house = new House(PROPER_HOUSE_NAME, PROPER_CAPACITY_VALUE);
        Cat initialCat = new Cat(CAT_NAME_VAR1);

        test_house.addCat(initialCat);

        Cat returnCat = test_house.catForSale(CAT_NAME_VAR1);

        Assert.assertFalse(initialCat.isHungry());
        Assert.assertEquals(initialCat, returnCat);
    }

    @Test
    public void getStatisticsForOneCat() {
        House test_house = new House(PROPER_HOUSE_NAME, PROPER_CAPACITY_VALUE);
        Cat initialCat = new Cat(CAT_NAME_VAR1);

        test_house.addCat(initialCat);

        String expectedOutput = String.format("The cat %s is in the house %s!", CAT_NAME_VAR1, PROPER_HOUSE_NAME);
        String actualOutput = test_house.statistics();

        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void getStatisticsForSeveralCats() {
        House test_house = new House(PROPER_HOUSE_NAME, PROPER_CAPACITY_VALUE);
        Cat firstCat = new Cat(CAT_NAME_VAR1);
        Cat secondCat = new Cat(CAT_NAME_VAR2);

        test_house.addCat(firstCat);
        test_house.addCat(secondCat);

        String expectedOutput = String.format("The cat %s, %s is in the house %s!", CAT_NAME_VAR1, CAT_NAME_VAR2, PROPER_HOUSE_NAME);
        String actualOutput = test_house.statistics();

        Assert.assertEquals(expectedOutput, actualOutput);
    }
}
