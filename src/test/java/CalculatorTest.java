import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public void sumValues() {
        assertEquals(16, Calculator.sumValues(12, 4), 0.01);
    }

    @Test
    public void subtractValue() {
        assertEquals(-8, Calculator.subtractValue(-12, -4), 0.01);
    }

    @Test
    public void multiplyValues() {
        assertEquals(24, Calculator.multiplyValues(12, 2), 0.01);
    }

    @Test
    public void divideValues() {
        assertEquals(6,  Calculator.divideValue(12, 2), 0.01);
    }
}