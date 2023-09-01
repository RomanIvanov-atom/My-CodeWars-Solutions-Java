package kata.kyu7;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class YouAreASquareTest {
    @Test
    public void shouldWorkForSomeExamples() {
        assertFalse("negative numbers aren't square numbers", YouAreASquare.isSquare(-1));
        assertTrue("0 is a square number (0 * 0)", YouAreASquare.isSquare(0));
        assertFalse("3 isn't a square number", YouAreASquare.isSquare(3));
        assertTrue("4 is a square number (2 * 2)", YouAreASquare.isSquare(4));
        assertTrue("25 is a square number (5 * 5)", YouAreASquare.isSquare(25));
        assertFalse("26 isn't a square number", YouAreASquare.isSquare(26));
    }
}

