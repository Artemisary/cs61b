import org.junit.Test;

import static org.junit.Assert.*;

public class TestSort {
    /**
     * Test the Sort.sort method
     */
    @org.junit.Test
    public void testSort() {
        String[] input = {"i", "have", "an", "egg"};
        String[] expect = {"an", "egg", "have", "i"};
        Sort.sort(input);
        assertArrayEquals(expect, input);
    }

    /**
     * Test the Sort.findSmallest method
     */
    @org.junit.Test
    public void testFindSmallest() {
        String[] input = {"i", "have", "an", "egg"};
        int expect = 2;
        int actual = Sort.findSmallest(input, 0);
        assertEquals(expect, actual);
    }

    /**
     * Test the Sort.swap method
     */
    @org.junit.Test
    public void testSwap() {
        String[] input = {"i", "have", "an", "egg"};
        int a = 0;
        int b = 2;
        Sort.swap(input, a, b);
        String[] expect = {"an", "have", "i", "egg"};
        assertArrayEquals(expect, input);
    }

}
