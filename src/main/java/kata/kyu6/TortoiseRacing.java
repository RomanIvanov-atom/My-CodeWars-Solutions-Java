package kata.kyu6;

public class TortoiseRacing {
    public static int[] race(int v1, int v2, int g) {
        if (v1 >= v2) {
            return null;
        }

        double timeInSeconds = ((double) g / (v2 - v1) * 3600);

        int hours = (int) timeInSeconds / 3600;

        int minutes = (int) (timeInSeconds % 3600) / 60;

        int seconds = (int) timeInSeconds % 60; 

        return new int[]{hours, minutes, seconds};
    }
}
