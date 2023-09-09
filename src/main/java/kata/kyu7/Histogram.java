package kata.kyu7;

import java.util.Arrays;

public class Histogram {
    public static double kMultiplier = 1;

    public static String histoPrinter(int percents, int[] results) {
        StringBuilder histogram = new StringBuilder();

        if (Arrays.stream(results).sum() != 0) {
            kMultiplier = kCalculating(results);
        }

        for (int i = 0; i < Math.floor((double) percents / 2 * kMultiplier); i++) {
            histogram.append('\u2588');
        }

        return histogram.toString();
    }

    public static double kCalculating(int[] intArray) {
        int sumArray = Arrays.stream(intArray).sum();
        kMultiplier = (double) 100 / sumArray;

        return kMultiplier;
    }

    public static String histogram(final int[] results) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = results.length; i > 0; i--) {
            if (results[i - 1] == 0) {
                stringBuilder.append(i).append('|').append("\n");
            } else {
                stringBuilder.append(i).append('|').append(histoPrinter(results[i - 1], results)).append(" ")
                        .append(Math.round(Math.floor(results[i - 1] * kMultiplier))).append('%').append('\n');
            }
        }

        return stringBuilder.toString();
    }
}
