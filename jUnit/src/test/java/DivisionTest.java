
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class DivisionTest {

    private static Calculation calculation;
    private  int firstParam;
    private int secondParam;

    public DivisionTest (int fParam, int sParam) {
        firstParam = fParam;
        secondParam = sParam;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> divisionParams() {
        Object[][] dParams = new Object[][] {{4, 5}, {3, 4}, {6, 8}, {5, 8}};
        return Arrays.asList(dParams);
    }

    @BeforeClass
    public static void initCalculation() {
        calculation = new Calculation();
    }

    @Test
    public void divisionResultsAreRounded() {
        int first = firstParam;
        int second = secondParam;
        int result = calculation.divideNumbers(first, second);
        assertEquals("Result wasn't rounded",0, result);
    }

    @Test
    @Ignore("These tests duplicate the previous four")
    public void divisionResultsAreCorrect() {
        int first = firstParam;
        int second = secondParam;
        int result = calculation.divideNumbers(first, second);
        assertTrue(result == 0);
    }
}
