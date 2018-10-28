package geneticalgorithm.defaultimplementations.datastructure;


import geneticalgorithm.defaultimplementations.datamodel.DoubleAttributeModel;
import geneticalgorithm.geneticalgorithm.data_model.AttributeModel;
import geneticalgorithm.geneticalgorithm.data_structure.Attribute;
import datatypes.operations.BitManipulation;

public class DoubleAttribute implements Attribute {
    private DoubleAttributeModel model;

    private Double value;

    public DoubleAttribute(DoubleAttributeModel model) {
        this.model = model;
    }

    public DoubleAttribute(DoubleAttributeModel model, Double value) {
        this.model = model;
        this.value = value;
    }

    private void setValue(Double value) {
        if (value < model.getMinValue() || value > model.getMaxValue())
            throw new IllegalArgumentException("The new attribute value is out of the model's bounds.");
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    public boolean[] toBits() {
        Double minValue = model.getMinValue();
        Double maxValue = model.getMaxValue();

        Integer bitCount = model.getBitCount();
        Integer maxValueOnBits = BitManipulation.computeMaxValueOnBitsCount(bitCount);
        int scaledValue = new Double((value - minValue) * maxValueOnBits / (maxValue - minValue)).intValue();

        return BitManipulation.computeBitsFromIntegerOnFixedLength(scaledValue, bitCount);
    }

    public void setFromBits(boolean[] bits) {
        Double minValue = model.getMinValue();
        Double maxValue = model.getMaxValue();
        Double precision = model.getPrecision();

        Integer points = new Double((maxValue - minValue) / precision).intValue();
        Integer bitCount = BitManipulation.computeBitLength(points);
        Integer maxValueOnBits = BitManipulation.computeMaxValueOnBitsCount(bitCount);

        int newIntValue = BitManipulation.computeIntegerFromBits(bits);
        Double newDoubleValue = newIntValue * (maxValue - minValue) / maxValueOnBits + minValue;
        setValue(newDoubleValue);

    }

    @Override
    public AttributeModel getModel() {
        return this.model;
    }

    @Override
    public Boolean isValid() {
        if(value.isNaN())
            return false;
        if(value > model.getMaxValue())
            return false;
        if(value < model.getMinValue())
            return false;
        return true;
        //return !(value.isNaN() && value >= model.getMinValue() && value <= model.getMaxValue());
    }
}
