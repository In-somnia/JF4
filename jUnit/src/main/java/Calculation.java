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
}
