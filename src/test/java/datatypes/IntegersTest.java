package datatypes;

import datatypes.operations.Doubles;
import datatypes.operations.Integers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class IntegersTest {
    private List<Integer> integers = new ArrayList<>();

    @Before
    public void setUp() {
        integers.add(1);
        integers.add(3);
        integers.add(18);
        integers.add(-1);
        integers.add(0);
        integers.add(-9);
        integers.add(-10);
        integers.add(2);
    }

    @Test
    public void getMinTest() {
        Assert.assertEquals(-10, (Object) Integers.getMin(integers));
    }

    @Test
    public void getMaxTest() {
        Assert.assertEquals(18, (Object) Integers.getMax(integers));
    }

    @Test
    public void getAverageTest() {
        Assert.assertEquals(0.5, (Object) Integers.getAverage(integers));
    }

    @Test
    public void getVarianceTest() {
        Double precision = Math.pow(10, -10);
        Double expected = 64.75;
        Double real = Integers.getVariance(integers);
        Double error = Math.abs(expected - real);
        Assert.assertTrue(error < precision);
    }

    @Test
    public void getRandomIntegerTest() {
        Integer lowerBound = -27;
        Integer upperBound = 3;
        Integer result = Integers.getRandomInteger(lowerBound, upperBound);

        Assert.assertTrue(result != null && result >= lowerBound && result <= upperBound);
        Assert.assertNull(Integers.getRandomInteger(upperBound, lowerBound));
    }

    @Test
    public void getRandomIntegersTest(){
        Integer lowerBound = -27;
        Integer upperBound = 3;
        Integer count = 5;
        List<Integer> integers = Integers.getRandomIntegers(count);
        List<Integer> integers2 = Integers.getRandomIntegers(count, lowerBound, upperBound);

        Assert.assertNotNull(integers);
        Assert.assertNotNull(integers2);
        for (Integer i : integers2) {
            Assert.assertTrue(i != null && i >= lowerBound && i <= upperBound);
        }
    }
}
