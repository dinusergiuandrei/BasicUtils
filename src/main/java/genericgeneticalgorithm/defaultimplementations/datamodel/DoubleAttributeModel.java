package genericgeneticalgorithm.defaultimplementations.datamodel;

import genericgeneticalgorithm.geneticalgorithm.data_model.AttributeModel;
import datatypes.BitManipulation;

public class DoubleAttributeModel implements AttributeModel {
    private String name;

    private Double minValue;

    private Double maxValue;

    private Double precision;

    private Integer bitCount;

    public DoubleAttributeModel(String name, Double minValue, Double maxValue, Double precision) {
        this.name = name;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.precision = precision;
        computeBitCount();
    }

    public Double getMinValue() {
        return minValue;
    }

    public Double getMaxValue() {
        return maxValue;
    }

    public Double getPrecision() {
        return precision;
    }

    public String getName() {
        return name;
    }

    public Integer getBitCount() {
        return bitCount;
    }

    private void computeBitCount(){
        this.bitCount = BitManipulation.computeBitLength(new Double((maxValue-minValue) / precision).intValue());
    }
}
