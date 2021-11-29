package p01_Database;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;


public class DatabaseTest {

    private static final Integer[] VALID_CONSTRUCTOR_ARGUMENT = new Integer[4];
    private static final Integer[] INVALID_EMPTY_CONSTRUCTOR_ARGUMENT = new Integer[0];
    private static final Integer[] INVALID_LARGE_CONSTRUCTOR_ARGUMENT = new Integer[17];


    private Database db;

    @Test
    public void testIfConstructorCreatesValidDB() throws OperationNotSupportedException {
        this.db = new Database(VALID_CONSTRUCTOR_ARGUMENT);

        Integer[] dbElements = this.db.getElements();

        Assert.assertArrayEquals(dbElements, VALID_CONSTRUCTOR_ARGUMENT);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testIfConstructorThrowsWhenArgumentIsEmptyArray() throws OperationNotSupportedException {
        this.db = new Database(INVALID_EMPTY_CONSTRUCTOR_ARGUMENT);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testIfConstructorThrowsWhenArgumentIsTooBigArray() throws OperationNotSupportedException {
        this.db = new Database(INVALID_LARGE_CONSTRUCTOR_ARGUMENT);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testShouldThrowExceptionWhenAddingNull() throws OperationNotSupportedException {
        this.db = new Database(VALID_CONSTRUCTOR_ARGUMENT);
        this.db.add(null);
    }

    @Test
    public void testAddingCorrectlyElement() throws OperationNotSupportedException {
        int newNumber = 4;
        Integer[] initialNumbers = {1, 2, 3};
        Integer[] numbersAfterAdding = {1, 2, 3, 4};

        this.db = new Database(initialNumbers);

        this.db.add(newNumber);

        Assert.assertArrayEquals(numbersAfterAdding, this.db.getElements());

    }

    @Test
    public void testRemovingElementCorrectly() throws OperationNotSupportedException {
        Integer[] numbersAfterRemoving = {1, 2, 3};
        Integer[] initialNumbers = {1, 2, 3, 4};

        this.db = new Database(initialNumbers);
        this.db.remove();

        Assert.assertArrayEquals(numbersAfterRemoving, this.db.getElements());
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testRemovingElementFromEmptyArray() throws OperationNotSupportedException {
        Integer[] initialNumbers = {1};

        this.db = new Database(initialNumbers);
        this.db.remove();
        this.db.remove();
    }

}