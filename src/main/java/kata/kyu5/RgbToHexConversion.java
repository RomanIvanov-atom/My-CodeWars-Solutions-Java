package kata.kyu5;

public class RgbToHexConversion {
    public static String rgb(int r, int g, int b) {

        r = Math.max(0, Math.min(255, r));
        g = Math.max(0, Math.min(255, g));
        b = Math.max(0, Math.min(255, b));

        String hexR = Integer.toHexString(r).toUpperCase();
        String hexG = Integer.toHexString(g).toUpperCase();
        String hexB = Integer.toHexString(b).toUpperCase();

        if (hexR.length() < 2) {
            hexR = "0" + hexR;
        }
        if (hexG.length() < 2) {
            hexG = "0" + hexG;
        }
        if (hexB.length() < 2) {
            hexB = "0" + hexB;
        }

        return hexR + hexG + hexB;
    }
}
