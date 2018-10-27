package datatypes.operations;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class NumbersExpert<T extends Number & Comparable> {
    public T getMin(List<T> numbers) {
        T minNumber = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i).compareTo(minNumber)>0)
                minNumber = numbers.get(i);
        }
        return minNumber;
    }

    public T getMax(List<T> numbers) {
        T maxNumber = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i).compareTo(maxNumber)<0)
                maxNumber = numbers.get(i);
        }
        return maxNumber;
    }

    public Double getAverage(List<T> numbers) {
        BigDecimal sum = new BigDecimal(0.0);
        for (T number : numbers) {
            sum = sum.add(new BigDecimal(number.toString()));
        }
        return (sum.doubleValue() / numbers.size());
    }

    public Double getVariance(List<T> numbers){
        NumbersExpert<T> expert = new NumbersExpert<>();
        Double avg = expert.getAverage(numbers);
        List<Double> ints2 = numbers.stream().mapToDouble((number -> new BigDecimal(number.toString()).floatValue() )).boxed().collect(Collectors.toList());
        Double avg2 = Doubles.getAverage(ints2);
        return avg2-avg*avg;
    }
}
