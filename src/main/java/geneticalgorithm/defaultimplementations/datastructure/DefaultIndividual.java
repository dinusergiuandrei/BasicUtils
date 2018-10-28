package geneticalgorithm.defaultimplementations.datastructure;


import geneticalgorithm.defaultimplementations.datamodel.DoubleAttributeModel;
import geneticalgorithm.geneticalgorithm.data_model.AttributeModel;
import geneticalgorithm.geneticalgorithm.data_model.IndividualModel;
import geneticalgorithm.geneticalgorithm.data_structure.Attribute;
import geneticalgorithm.geneticalgorithm.data_structure.Individual;
import datatypes.operations.BitManipulation;

import java.util.ArrayList;
import java.util.List;

import static datatypes.operations.BitManipulation.extractNBitsStartingFrom;


public class DefaultIndividual implements Individual {

    private List<Attribute> attributes = new ArrayList<>();

    public void addAttribute(Attribute newAttribute){
        attributes.add(newAttribute);
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public boolean[] toBits(){
        List<Integer> individualBits = new ArrayList<>();
        for (int index = 0; index < attributes.size(); index++) {
            boolean[] attributeBits = attributes.get(index).toBits();
            for (int i = 0; i < attributeBits.length; ++i) {
                individualBits.add(BitManipulation.getIntFromBit(attributeBits[i]));
            }
        }
        boolean[] bits = new boolean[individualBits.size()];
        for (int index = 0; index < individualBits.size(); index++) {
            bits[index] = BitManipulation.getBitFromInt(individualBits.get(index));
        }
        return bits;
    }

    public void setFromBits(IndividualModel model, boolean[] bits){
        this.attributes.clear();
        int startingPoint = 0;
        for (AttributeModel attributeModel : model.getAttributeModels()) {
            DoubleAttributeModel doubleAttributeModel = (DoubleAttributeModel) attributeModel;
            Integer bitsCount = attributeModel.getBitCount();
            boolean[] attributeBits = extractNBitsStartingFrom(bits, startingPoint, bitsCount);
            startingPoint += bitsCount;
            DoubleAttribute attribute = new DoubleAttribute(doubleAttributeModel);
            attribute.setFromBits(attributeBits);
            this.attributes.add(attribute);
        }
    }

    @Override
    public String toString(String attributeSeparator) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Attribute attribute : attributes) {
            stringBuilder.append(attribute.getModel().getName()).append(" = ").append(attribute.getValue()).append(attributeSeparator);
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return this.toString("\n");
    }

    @Override
    public Boolean isValid() {
        for (Attribute attribute : this.attributes) {
            if(!attribute.isValid())
                return false;
        }
        return true;
    }


}
