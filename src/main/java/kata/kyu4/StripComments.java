package kata.kyu4;

public class StripComments {
    public static String removeTrailingSpaces(String input) {
        int endIndex = input.length() - 1;

        while (endIndex >= 0 && input.charAt(endIndex) == ' ') {
            endIndex--;
        }

        return input.substring(0, endIndex + 1);
    }

    public static String stripComments(String text, String[] commentSymbols) {
        String[] lines = text.split("\n");
        StringBuilder result = new StringBuilder();

        for (String line : lines) {
            String trimmedLine = removeTrailingSpaces(line);

            for (String symbol : commentSymbols) {
                int commentIndex = line.indexOf(symbol);

                if (commentIndex != -1) {
                    trimmedLine = trimmedLine.substring(0, commentIndex);
                }
            }

            // Удаление пробелов и символов переноса строки в конце
            trimmedLine = trimmedLine.replaceAll("\\s+$", "");
            result.append(trimmedLine).append("\n");
        }

        result.setLength(result.length() - 1);
        return result.toString();
    }
}