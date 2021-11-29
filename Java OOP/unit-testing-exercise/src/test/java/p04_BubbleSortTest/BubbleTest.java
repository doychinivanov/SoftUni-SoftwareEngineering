package p04_BubbleSortTest;

import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleTest {

    private static final int[] unSortedArr = {-7, 2, 77, 31, -22};
    private static final int[] sortedArr = {-22, -7, 2, 31, 77};

    @Test
    public void testCorrectSorting() {
        Bubble.sort(unSortedArr);

        assertArrayEquals(sortedArr, unSortedArr);
    }

}