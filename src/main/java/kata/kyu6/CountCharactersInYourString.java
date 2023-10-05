package kata.kyu6;

import java.util.HashMap;
import java.util.Map;

public class CountCharactersInYourString {
    public static Map<Character, Integer> count(String str) {
        Map<Character, Integer> charCountMap = new HashMap<>();

        for (char c : str.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        return charCountMap;
    }
}
