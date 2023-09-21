package kata.kyu6;

public class ConvertStringToCamelCase {
    static String toCamelCase(String s) {
        if (s.isEmpty()) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder(s.length());
        stringBuilder.append(s.charAt(0));
        boolean isDashOrScore = false;

        for (int i = 1; i < s.length(); i++) {

            if (isDashOrScore) {
                stringBuilder.append(String.valueOf(s.charAt(i)).toUpperCase());
                isDashOrScore = false;
                continue;
            }

            if (s.charAt(i) == '_' || s.charAt(i) == '-') {
                isDashOrScore = true;
                continue;
            }

            stringBuilder.append(s.charAt(i));
        }

        return stringBuilder.toString();
    }
}
