package kata.kyu7;

import java.util.Stack;

public class ValidParentheses {
    public static boolean validParentheses(String parenStr) {
        Stack<Character> stack = new Stack<>();

        for (char c : parenStr.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
