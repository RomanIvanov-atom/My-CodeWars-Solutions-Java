package kata.kyu7;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BasicCalculatorTest {
    @Test
    public void BasicTest() {
        assertEquals(new Double(11.2),BasicCalculator.calculate(3.2,"+", 8));
        assertEquals(new Double(-4.8),BasicCalculator.calculate(3.2,"-", 8));
        assertEquals(new Double(0.4),BasicCalculator.calculate(3.2,"/", 8));
        assertEquals(new Double(25.6),BasicCalculator.calculate(3.2,"*", 8));
        assertEquals(new Double(-3),BasicCalculator.calculate(-3,"+", 0));
        assertEquals(new Double(-3),BasicCalculator.calculate(-3,"-", 0));
        assertEquals(null,BasicCalculator.calculate(-3,"/", 0));
        assertEquals(new Double(1),BasicCalculator.calculate(-2, "/", -2));
        assertEquals(new Double(0),BasicCalculator.calculate(-3,"*", 0));
        assertEquals(null,BasicCalculator.calculate(-3,"w", 0));
    }
}
