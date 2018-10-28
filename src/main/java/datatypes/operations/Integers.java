package datatypes.operations;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Integers {
    private static NumbersExpert<Integer> expert;

    private static Random random;

    static {
        expert = new NumbersExpert<>();
    }

    public static Integer getMin(List<Integer> integers) {
        return expert.getMin(integers);
    }

    public static Integer getMax(List<Integer> integers) {
        return expert.getMax(integers);
    }

    public static Double getAverage(List<Integer> integers) {
        return expert.getAverage(integers);
    }

    public static Double getVariance(List<Integer> integers) {
        return expert.getVariance(integers);
    }

    public static Integer getRandomInteger() {
        return getRandom().nextInt();
    }

    public static Integer getRandomInteger(Integer lowerBound, Integer upperBound) {
        if(!validBounds(lowerBound, upperBound))
            return null;
        return getRandom().nextInt(upperBound - lowerBound) + lowerBound;
    }

    public static List<Integer> getRandomIntegers(Integer count){
        return getRandom().ints(count).boxed().collect(Collectors.toList());
    }

    public static List<Integer> getRandomIntegers(Integer count, Integer lowerBound, Integer upperBound) {
        if(!validBounds(lowerBound, upperBound))
            return null;
        return getRandom().ints(count).boxed()
                .mapToInt(d -> modulo(d, upperBound - lowerBound) + lowerBound).boxed()
                .collect(Collectors.toList());
    }

    private static Integer modulo(Integer n1, Integer n2){
        Integer result = n1 % n2;
        if(result<0)
            result += n2;
        return result;
    }

    private static Boolean validBounds(Integer lowerBound, Integer upperBound) {
        return lowerBound <= upperBound;
    }

    private static Random getRandom() {
        if (random == null)
            random = new Random();
        return random;
    }
}
