package kata.kyu6;

public class FindTheMissingLetter {
    public static char findMissingLetter(char[] array) {
        int code1stChar = array[0];
        int code2ndChar = array[1];

        if (array.length < 3) {
            return (char) ((int) array[0] + 1);
        }

        if (code2ndChar - code1stChar != 1) {
            int code3rdChar = array[2];

            if (code3rdChar - code2ndChar == 1) {
                return (char) (code2ndChar - 1);
            } else {
                return (char) (code1stChar + 1);
            }
        }

        for (int i = 0; i < array.length; i++) {
            if ((int) array[i] + 1 != (int) array[i + 1]) {
                return (char) ((int) array[i] + 1);
            }
        }

        return ' ';
    }
}
