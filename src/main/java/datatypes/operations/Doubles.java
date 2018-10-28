package datatypes.operations;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Doubles {
    private static NumbersExpert<Double> expert;

    private static Random random;

    static {
        expert = new NumbersExpert<>();
    }

    public static Double getMin(List<Double> doubles) {
        return expert.getMin(doubles);
    }

    public static Double getMax(List<Double> doubles) {
        return expert.getMax(doubles);
    }

    public static Double getAverage(List<Double> doubles) {
        return expert.getAverage(doubles);
    }

    public static Double getVariance(List<Double> doubles) {
        return expert.getVariance(doubles);
    }

    public static Double getRandomDouble(Double lowerBound, Double upperBound) {
        if(!validBounds(lowerBound, upperBound))
            return null;
        return getRandom().nextDouble() * (upperBound - lowerBound) + lowerBound;
    }

    public static Double getRandomDouble() {
        return getRandom().nextDouble();
    }

    public static List<Double> getRandomDoubles(Integer count, Double lowerBound, Double upperBound) {
        if(!validBounds(lowerBound, upperBound))
            return null;
        return getRandom().doubles(count).boxed()
                .mapToDouble(d -> d * (upperBound - lowerBound) + lowerBound).boxed()
                .collect(Collectors.toList());
    }

    public static List<Double> getRandomDoubles(Integer count){
        return getRandom().doubles(count).boxed().collect(Collectors.toList());
    }

    private static Boolean validBounds(Double lowerBound, Double upperBound) {
        return lowerBound <= upperBound;
    }

    private static Random getRandom() {
        if (random == null)
            random = new Random();
        return random;
    }
}
