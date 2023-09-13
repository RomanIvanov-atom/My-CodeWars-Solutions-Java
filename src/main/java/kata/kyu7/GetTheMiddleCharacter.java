package kata.kyu7;

public class GetTheMiddleCharacter {
    public static String getMiddle(String word) {
        int indexCenter = word.length() / 2;

        if (word.length() % 2 == 0) {
            return word.substring(indexCenter - 1, indexCenter + 1);
        } else {
            return String.valueOf(word.charAt(indexCenter));
        }
    }
}
