import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class RangeTests {

    private static Range range;
    private long startBound;
    private long endBound;

    public RangeTests(long startBound, long endBound) {
        this.startBound = startBound;
        this.endBound = endBound;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> rangeParams() {
        Object[][] params = new Object[][] {{5, 9}, {5, 7}, {-5, 2}, {4, 9}};
        return Arrays.asList(params);
    }

    @Before
    public void initRange() {
        range = new Range(startBound, endBound);
    }


    @Test
    public void isBeforeWorks() {
        Range otherRange = new Range(10, 12);
        assertTrue(range.isBefore(otherRange));
    }

    @Test
    public void isAfterWorks() {
        Range otherRange = new Range(-6, -7);
        assertTrue(range.isAfter(otherRange));
    }

}
