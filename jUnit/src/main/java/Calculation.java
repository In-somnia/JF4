import static java.lang.Math.round;

public class Calculation {

    public int countFactorial(int a) throws ArithmeticException {
        int fact = 1;
        if (a == 0) {
            return 1;
        } else if (a < 0) {
            throw new ArithmeticException();
        } else {
            for (int i = 1; i <= a; i++) {
                fact *= i;
            }
        }
        return fact;
    }

    public int multiplyNumbers(int a, int b) {
        int result = a * b;
        return result;
    }

    public int divideNumbers(int a, int b) throws ArithmeticException {
        int result = 0;

        try {
        result = round(a / b);
        } catch (ArithmeticException e) {
            e.getMessage();
        }
       return result;
    }
}
