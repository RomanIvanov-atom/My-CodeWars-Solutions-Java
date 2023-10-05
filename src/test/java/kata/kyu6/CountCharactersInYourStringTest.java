package kata.kyu6;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CountCharactersInYourStringTest {

    @Test(priority = 1)
    public void testEmptyString() {
        Map<Character, Integer> d = new HashMap<>();
        assertEquals(d, CountCharactersInYourString.count(""));
    }

    @Test(priority = 2)
    public void testSingleCharacter() {
        Map<Character, Integer> d = new HashMap<>();
        d.put('a', 1);
        assertEquals(d, CountCharactersInYourString.count("a"));
    }

    @Test(priority = 3)
    public void testMultipleCharacters() {
        Map<Character, Integer> d = new HashMap<>();
        d.put('a', 3);
        d.put('b', 3);
        d.put('c', 1);
        assertEquals(d, CountCharactersInYourString.count("aabbbac"));
    }

    @Test(priority = 4)
    public void testAllCharactersUnique() {
        Map<Character, Integer> d = new HashMap<>();
        d.put('a', 1);
        d.put('b', 1);
        d.put('c', 1);
        assertEquals(d, CountCharactersInYourString.count("abc"));
    }

    @Test(priority = 5)
    public void testAllCharactersSame() {
        Map<Character, Integer> d = new HashMap<>();
        d.put('a', 5);
        assertEquals(d, CountCharactersInYourString.count("aaaaa"));
    }

    @Test(priority = 6)
    public void testDifferentCharacters() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 2);
        expected.put('b', 2);
        Map<Character, Integer> actual = CountCharactersInYourString.count("aabb");
        assertEquals(expected, actual);
    }
}
