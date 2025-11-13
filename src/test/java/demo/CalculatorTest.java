package demo;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void sumValues() {
        Assert.assertEquals(16, Calculator.sumValues(12, 4), 0.01);
    }

    @Test
    public void subtractValue() {
        Assert.assertEquals(-8, Calculator.subtractValue(-12, -4), 0.01);
    }

    @Test
    public void multiplyValues() {
        Assert.assertEquals(24, Calculator.multiplyValues(12, 2), 0.01);
    }

    @Test
    public void divideValues() {
        Assert.assertEquals(6,  Calculator.divideValue(12, 2), 0.01);
    }
}