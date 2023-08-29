package kata.kyu7;

import org.junit.Test;

import static kata.kyu7.ValidParentheses.validParentheses;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidParenthesesTest {
    @Test
    public void validCases() {
        assertTrue(validParentheses("()"));
        assertTrue(validParentheses("((()))"));
        assertTrue(validParentheses("()()()"));
        assertTrue(validParentheses("(()())()"));
        assertTrue(validParentheses("()(())((()))(())()"));
    }

    @Test
    public void invalidCases() {
        assertFalse(validParentheses(")("));
        assertFalse(validParentheses("()()("));
        assertFalse(validParentheses("((())"));
        assertFalse(validParentheses("())(()"));
        assertFalse(validParentheses(")()"));
        assertFalse(validParentheses(")"));
    }

    @Test
    public void emptyString() {
        assertTrue(validParentheses(""));
    }
}