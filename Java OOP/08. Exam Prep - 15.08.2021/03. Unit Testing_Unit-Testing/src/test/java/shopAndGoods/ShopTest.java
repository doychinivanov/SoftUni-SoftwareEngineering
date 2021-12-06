package shopAndGoods;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ShopTest {

    private Shop shop;

    @Before
    public void setUp() {
        this.shop = new Shop();
    }

    @Test (expected = UnsupportedOperationException.class)
    public void testIfGetShelvesReturnsUnmodifiableCollection() {
        shop.getShelves().clear();
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddingGoodsOnNonExistingShelfShouldFail() throws OperationNotSupportedException {
        shop.addGoods("non_existing_shelf", null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddingGoodsOnNonEmptyShelfShouldFail() throws OperationNotSupportedException {
        Goods someGood = new Goods("test_good", "123");
        shop.addGoods("Shelves1", someGood);
        shop.addGoods("Shelves1", someGood);
    }

    @Test
    public void testProperAddingGoodOnShelf() throws OperationNotSupportedException {
        Goods someGood = new Goods("test_good", "123");
        String expected = "Goods: 123 is placed successfully!";
        String actual = shop.addGoods("Shelves1", someGood);

        Assert.assertEquals(expected, actual);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemovingGoodsOnNonExistingShelfShouldFail() throws OperationNotSupportedException {
        shop.removeGoods("non_existing_shelf", null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemovingGoodsShouldFailIfCurrentGoodIsNotOnShelf() throws OperationNotSupportedException {
        Goods someGood = new Goods("test_good", "123");
        Goods otherGood = new Goods("test_good2", "000");

        shop.addGoods( "Shelves1", someGood);
        shop.removeGoods("Shelves1", otherGood);
    }

    @Test
    public void testIfRemoveMethodReturnsProperMessage() throws OperationNotSupportedException {
        Goods someGood = new Goods("test_good", "123");
        shop.addGoods( "Shelves1", someGood);

        String actualMessage = shop.removeGoods("Shelves1", someGood);
        String expectedMessage = "Goods: 123 is removed successfully!";

        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testIfValueAfterRemoveIsNull() throws OperationNotSupportedException {
        Goods someGood = new Goods("test_good", "123");
        shop.addGoods( "Shelves1", someGood);
        shop.removeGoods("Shelves1", someGood);

        Goods emptyShelf = shop.getShelves().get("Shelves1");

        Assert.assertNull(emptyShelf);
    }

}