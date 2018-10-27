package datatypes.operations;

import java.util.List;

public class Doubles {
    private static NumbersExpert<Double> expert;

    static {
        expert = new NumbersExpert<>();
    }

    public static Double getMin(List<Double> doubles){
        return expert.getMin(doubles);
    }

    public static Double getMax(List<Double> doubles){
        return expert.getMax(doubles);
    }

    public static Double getAverage(List<Double> doubles){
        return expert.getAverage(doubles);
    }

    public static Double getVariance(List<Double> doubles){
        return expert.getVariance(doubles);
    }
}
