import org.junit.Test;

import static org.junit.Assert.*;

public class MeasurementTest {
    @Test
    public void test1() {
        // TODO: stub for first test
        Measurement m1 = new Measurement();
        assertEquals("0\'0\"", m1.toString());

    }

    // TODO: Add additional JUnit tests for Measurement.java here.
    @Test
    public void plusTest() {
        Measurement m1 = new Measurement(2, 7);
        Measurement m2 = new Measurement(3, 5);
        assertEquals(new Measurement(6, 0), m1.plus(m2));
    }
    @Test
    public void minusTest() {
        Measurement m1 = new Measurement(3, 5);
        Measurement m2 = new Measurement(2, 7);
        assertEquals(new Measurement(0, 10), m1.minus(m2));
    }
    @Test
    public void multipleTest() {
        Measurement m = new Measurement(0, 7);
        assertEquals(new Measurement(1, 9), m.multiple(3));
    }

}