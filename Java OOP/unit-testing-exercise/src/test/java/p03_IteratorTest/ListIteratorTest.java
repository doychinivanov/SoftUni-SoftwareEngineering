package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ListIteratorTest {

    private ListIterator listIterator;

    private static final String[] VALID_CONSTRUCTOR_ARGUMENT = {"Pesho", "Gosho", "Sasho"};

    @Before
    public void setUp() throws OperationNotSupportedException {
        this.listIterator = new ListIterator(VALID_CONSTRUCTOR_ARGUMENT);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testConstructorShouldThrowWhenArgumentIsNull() throws OperationNotSupportedException {
        this.listIterator = new ListIterator(null);
    }

    @Test
    public void textConstructorShouldCreateProperly() throws OperationNotSupportedException {
        this.listIterator = new ListIterator(VALID_CONSTRUCTOR_ARGUMENT);
    }

    @Test
    public void testIfIteratorHasNext() throws OperationNotSupportedException {

        assertTrue(this.listIterator.hasNext());
        assertTrue(this.listIterator.move());
        assertTrue(this.listIterator.hasNext());

        this.listIterator.move();
    }

    @Test
    public void testIfIteratorMoveReturnFalseWhenNoMoreElements() throws OperationNotSupportedException {

        assertTrue(this.listIterator.move());
        assertTrue(this.listIterator.move());
        assertFalse(this.listIterator.move());
    }

    @Test (expected = IllegalStateException.class)
    public void testPrintShouldThrowErrorWhenListIsEmpty() throws OperationNotSupportedException {
        this.listIterator = new ListIterator();
        this.listIterator.print();
    }

    @Test
    public void testIfPrintReturnProperElement() {

        assertEquals(VALID_CONSTRUCTOR_ARGUMENT[0], this.listIterator.print());
        this.listIterator.move();

        assertEquals(VALID_CONSTRUCTOR_ARGUMENT[1], this.listIterator.print());
        this.listIterator.move();

        assertEquals(VALID_CONSTRUCTOR_ARGUMENT[2], this.listIterator.print());

    }

}