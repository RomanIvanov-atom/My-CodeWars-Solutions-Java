package kata.kyu7;

public class YouAreASquare {
    public static boolean isSquare(int n) {
        double squareRoot = Math.pow(n, (double) 1/2);
        double decimalPart = squareRoot - Math.floor(squareRoot);
        
        return decimalPart == 0;
    }
}
