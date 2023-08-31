package kata.kyu5;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class RgbToHexConversionTest {

    private static String toHex(int c) {
        if (c < 0) c = 0;
        if (c > 255) c = 255;

        String cHex = Integer.toHexString(c);
        if (cHex.length() == 1) {
            cHex = "0" + cHex;
        }

        return cHex.toUpperCase();
    }

    @Test
    public void basicTests() {
        assertEquals("For input: (0, 0, 0)", "000000", RgbToHexConversion.rgb(0, 0, 0));
        assertEquals("For input: (1, 2, 3)", "010203", RgbToHexConversion.rgb(1, 2, 3));
        assertEquals("For input: (255, 255, 255)", "FFFFFF", RgbToHexConversion.rgb(255, 255, 255));
        assertEquals("For input: (254, 253, 252)", "FEFDFC", RgbToHexConversion.rgb(254, 253, 252));
        assertEquals("For input: (-20, 275, 125)", "00FF7D", RgbToHexConversion.rgb(-20, 275, 125));
    }

    @Test
    public void randomTests() {
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            int randomR = random.nextInt(455) - 100;
            int randomG = random.nextInt(455) - 100;
            int randomB = random.nextInt(455) - 100;

            String toHexRandomR = toHex(randomR);
            String toHexRandomG = toHex(randomG);
            String toHexRandomB = toHex(randomB);

            assertEquals(String.format("For input: (%d, %d, %d)", randomR, randomG, randomB), toHexRandomR + toHexRandomG + toHexRandomB, RgbToHexConversion.rgb(randomR, randomG, randomB));
        }
    }
}