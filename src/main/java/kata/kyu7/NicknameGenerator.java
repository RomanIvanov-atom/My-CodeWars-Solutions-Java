package kata.kyu7;

public class NicknameGenerator {
    public static String nickname(String name) {
        if (name.length() < 4) {
            return "Error: Name too short";
        }

        // It's important to declare char3rd AFTER checking name's length
        char char3rd = name.charAt(2);
        boolean is3rdVowel;
        String outString;


        is3rdVowel = char3rd == 'a' || char3rd == 'e' || char3rd == 'i' || char3rd == 'o' || char3rd == 'u';

        if (is3rdVowel) {
            outString = name.substring(0, 4);
        } else {
            outString = name.substring(0, 3);
        }

        return outString;
    }
}
