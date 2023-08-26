package kata.kyu6;

public class CalculateTheAreaOfARegularNSidesPolygonInsideACircle {
    public static double areaOfPolygonInsideCircle(double circleRadius, int numberOfSides) {
        // S = 1/2 * R^2 * n * sin(360/n)

        final int decimalPlaces = 3;
        double areaS;

        areaS = 0.5 * Math.pow(circleRadius, 2) * numberOfSides * Math.sin(Math.toRadians((double) 360 / numberOfSides));
        areaS = Math.round(areaS * Math.pow(10, decimalPlaces)) / Math.pow(10, decimalPlaces);

        return areaS;
    }
}
