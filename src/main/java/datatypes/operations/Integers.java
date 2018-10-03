package datatypes.operations;

import java.util.List;

public class Integers {
    public static Integer getMin(List<Integer> ints){
        Integer minNumber = ints.get(0);
        for (int i = 1; i < ints.size(); i++) {
            if(ints.get(i)<minNumber)
                minNumber=ints.get(i);
        }
        return minNumber;
    }

    public static Integer getMax(List<Integer> ints){
        Integer maxNumber = ints.get(0);
        for (int i = 1; i < ints.size(); i++) {
            if(ints.get(i)>maxNumber)
                maxNumber=ints.get(i);
        }
        return maxNumber;
    }

    public static Double getAverage(List<Integer> ints){
        Double avg;
        Integer sum = 0;
        for (Integer integer : ints) {
            sum += integer;
        }
        avg = sum * 1.0 / ints.size();
        return avg;
    }
}
