package kata.kyu6;

public class PlayingWithPassphrases {
    public static boolean isUppercaseLetter(char c) {
        return (int) c >= 65 & (int) c <= 90;
    }

    public static boolean isLowercaseLetter(char c) {
        return (int) c >= 97 & (int) c <= 122;
    }

    public static boolean isDigit(char c) {
        return (int) c >= 48 & (int) c <= 57;
    }

    public static boolean isCounterEven(int letterCounter) {
        return letterCounter % 2 == 0;
    }

    public static String playingWithPassphrases(String s, int n) {
        StringBuilder outString = new StringBuilder();
        int letterCounter = 0;

        // to not overjump throuh letters zone in ascii
        if (n > 26) {
            n = n % 26;
        }

        for (char c : s.toCharArray()) {
            int kInvertCaseForUpper;
            int kInvertCaseForLower;

            if (isCounterEven(letterCounter)) {
                kInvertCaseForUpper = 0;
                kInvertCaseForLower = -32;
            } else {
                kInvertCaseForUpper = 32;
                kInvertCaseForLower = 0;
            }

            if (isUppercaseLetter(c)) {
                if ((int) c + n <= 90) {
                    outString.append((char) ((int) c + n + kInvertCaseForUpper));
                } else {
                    outString.append((char) ((int) c + n - 26 + kInvertCaseForUpper));
                }
            } else if (isLowercaseLetter(c)) {
                if ((int) c + n <= 122) {
                    outString.append((char) ((int) c + n + kInvertCaseForLower));
                } else {
                    outString.append((char) ((int) c + n - 26 + kInvertCaseForLower));
                }
            } else if (isDigit(c)) {
                outString.append((char) (57 - (int) c + 48));   // 57 is DECcode of 9 | 48 is a start if digits, I mean 0
            } else {   // => it is nonAlpha & nonDigit char
                outString.append(c);
            }

            letterCounter++;
        }

        return outString.reverse().toString();
    }
}
