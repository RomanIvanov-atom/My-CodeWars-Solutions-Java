package kata.kyu6;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ChangeCase {
    public static String toSentenceCase(String string) {
        StringBuilder outString = new StringBuilder();
        boolean isNextUpperCase = true;

        if (string.isEmpty()) {
            return string;
        }

        for (char c : string.toCharArray()) {
            if (Character.isLetter(c)) {
                if (isNextUpperCase) {
                    outString.append(Character.isDigit(c) ? c : Character.toUpperCase(c));
                    isNextUpperCase = false;
                } else {
                    outString.append(Character.toLowerCase(c));
                }
            } else {    // it is symbol/whitespace, not letter
                if (c == '!' || c == '?' || c == '.') {
                    isNextUpperCase = true;
                }

                if (!Character.isLetter(c) & c != ' ' & c != '!' & c != '?' & c != '.') {
                    isNextUpperCase = false;
                }
                outString.append(c);
            }
        }

        return outString.toString();
    }

    public static String toLowerCase(String string) {
        return string.toLowerCase();
    }

    public static String toUpperCase(String string) {
        return string.toUpperCase();
    }

    public static String capitalizeEachWord(String string) {
        String[] splitedString = string.split(" ");

        if (string.isEmpty()) {
            return string;
        }

        String outString = Arrays.stream(splitedString)
                .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));

        return outString;
    }

    public static String toToggleCase(String string) {
        StringBuilder outString = new StringBuilder();

        for (char c : string.toCharArray()) {
            if (Character.isLowerCase(c)) {
                outString.append(Character.toUpperCase(c));
            } else if (Character.isUpperCase(c)) {
                outString.append(Character.toLowerCase(c));
            } else {
                outString.append(c);
            }
        }

        return outString.toString();
    }
}
