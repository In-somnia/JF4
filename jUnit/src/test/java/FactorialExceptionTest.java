import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FactorialExceptionTest {

    private static Calculation calculation;
    private int factorialNumber;
    private int factorialResult;

    @BeforeClass
    public static void initCalculation() {
        calculation = new Calculation();
    }

    public FactorialExceptionTest (int fNumber, int fResult) {
        factorialNumber = fNumber;
        factorialResult = fResult;
    }

     @Parameterized.Parameters
    public static Collection<Object[]> factorialNegativeValues() {
        Object[][] fNegativeValues = new Object[][] {{-3, 6}, {-4, 24}, {-5, 120}};
        return Arrays.asList(fNegativeValues);
    }

    @Test(expected = ArithmeticException.class)
    public void factorialExceptionTest() throws ArithmeticException {
        int expected = factorialResult;
        int actual = calculation.countFactorial(factorialNumber);
        assertEquals("Exception wasn't thrown",actual, expected);
    }
}