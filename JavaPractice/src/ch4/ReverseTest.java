package ch4;

import static junit.framework.Assert.assertTrue;

import org.junit.Test;

public class ReverseTest {

    private final ReverseNumericalOrder comparator = new ReverseNumericalOrder();

    @Test
    public void testNeg() {
        assertTrue(comparator.compare(10, 4) < 0);
    }

    @Test
    public void testEq() {
        assertTrue(comparator.compare(2, 2) == 0);
    }

    @Test
    public void testPos() {
        assertTrue(comparator.compare(4, 10) > 0);
    }
}
