package kata.kyu7;

public class BasicCalculator {
    public static Double calculate(final double numberOne, final String operation, final double numberTwo)
    {
        switch (operation){
            case "+":
                return numberOne + numberTwo;
            case "-":
                return numberOne - numberTwo;
            case "*":
                double result = numberOne * numberTwo;
                if (result == -0.0) {
                    return 0.0;
                }
                else {
                    return result;
                }
            case "/":
                if (numberTwo == 0) {
                    return null;
                } else {
                    return numberOne / numberTwo;
                }
            default:
                return null;
        }
    }
}