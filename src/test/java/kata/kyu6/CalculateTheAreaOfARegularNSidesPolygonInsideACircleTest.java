package kata.kyu6;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculateTheAreaOfARegularNSidesPolygonInsideACircleTest {
    @Test
    public void test1() {
        assertEquals(11.691, CalculateTheAreaOfARegularNSidesPolygonInsideACircle.areaOfPolygonInsideCircle(3, 3), 1e-4);
    }

    @Test
    public void test2() {
        assertEquals(8, CalculateTheAreaOfARegularNSidesPolygonInsideACircle.areaOfPolygonInsideCircle(2, 4), 1e-4);
    }

    @Test
    public void test3() {
        assertEquals(14.86, CalculateTheAreaOfARegularNSidesPolygonInsideACircle.areaOfPolygonInsideCircle(2.5, 5), 1e-4);
    }
}
