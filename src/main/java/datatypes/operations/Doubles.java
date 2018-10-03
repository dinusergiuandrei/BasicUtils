package datatypes.operations;

import java.util.List;

public class Doubles {
    public static Double getMin(List<Double> ints){
        Double minNumber = ints.get(0);
        for (int i = 1; i < ints.size(); i++) {
            if(ints.get(i)<minNumber)
                minNumber=ints.get(i);
        }
        return minNumber;
    }

    public static Double getMax(List<Double> ints){
        Double maxNumber = ints.get(0);
        for (int i = 1; i < ints.size(); i++) {
            if(ints.get(i)>maxNumber)
                maxNumber=ints.get(i);
        }
        return maxNumber;
    }

    public static Double getAverage(List<Double> ints){
        Double avg;
        Double sum = 0D;
        for (Double integer : ints) {
            sum += integer;
        }
        avg = sum * 1.0 / ints.size();
        return avg;
    }
}
