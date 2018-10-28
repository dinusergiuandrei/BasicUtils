package datatypes;

import datatypes.operations.Doubles;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DoublesTest {
    private List<Double> doubles = new ArrayList<>();

    @Before
    public void setUp() {
        doubles.add(0.1);
        doubles.add(0.3);
        doubles.add(1.8);
        doubles.add(-0.1);
        doubles.add(0.0);
        doubles.add(-0.9);
        doubles.add(-1.0);
        doubles.add(0.2);
    }

    @Test
    public void getMinTest() {
        Assert.assertEquals(-1.0, (Object) Doubles.getMin(doubles));
    }

    @Test
    public void getMaxTest() {
        Assert.assertEquals(1.8, (Object) Doubles.getMax(doubles));
    }

    @Test
    public void getAverageTest() {
        Assert.assertEquals(0.05, (Object) Doubles.getAverage(doubles));
    }

    @Test
    public void getVarianceTest() {
        Double precision = Math.pow(10, -10);
        Double expected = 0.6475;
        Double real = Doubles.getVariance(doubles);
        Double error = Math.abs(expected - real);
        Assert.assertTrue(error < precision);
    }

    @Test
    public void getRandomDoubleTest() {
        Double lowerBound = -2.7;
        Double upperBound = 0.3;
        Double result1 = Doubles.getRandomDouble();
        Double result2 = Doubles.getRandomDouble(lowerBound, upperBound);

        Assert.assertTrue(result1 >= 0.0 && result1 <= 1.0);
        Assert.assertTrue(result2 != null && result2 >= lowerBound && result2 <= upperBound);
        Assert.assertNull(Doubles.getRandomDouble(upperBound, lowerBound));
    }

    @Test
    public void getRandomDoublesTest(){
        Double lowerBound = -2.7;
        Double upperBound = 0.3;
        Integer count = 5;
        List<Double> doubles = Doubles.getRandomDoubles(count);
        List<Double> doubles2 = Doubles.getRandomDoubles(count, lowerBound, upperBound);

        Assert.assertNotNull(doubles);
        for (Double d : doubles) {
            Assert.assertTrue(d >= 0.0 && d <= 1.0);
        }
        Assert.assertNotNull(doubles2);
        for (Double d : doubles2) {
            Assert.assertTrue(d != null && d >= lowerBound && d <= upperBound);
        }
    }
}
