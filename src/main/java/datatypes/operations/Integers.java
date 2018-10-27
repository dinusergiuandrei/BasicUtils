package datatypes.operations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Integers {
    private static NumbersExpert<Integer> expert;

    static {
        expert = new NumbersExpert<>();
    }

    public static Integer getMin(List<Integer> integers){
        return expert.getMin(integers);
    }

    public static Integer getMax(List<Integer> integers){
        return expert.getMax(integers);
    }

    public static Double getAverage(List<Integer> integers){
        return expert.getAverage(integers);
    }

    public static Double getVariance(List<Integer> integers){
        return expert.getVariance(integers);
    }
}
