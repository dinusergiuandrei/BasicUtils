package genericgeneticalgorithm.defaultimplementations.functions;

import genericgeneticalgorithm.defaultimplementations.datamodel.DefaultIndividualModel;
import genericgeneticalgorithm.defaultimplementations.datamodel.DoubleAttributeModel;
import genericgeneticalgorithm.defaultimplementations.datastructure.DoubleAttribute;
import genericgeneticalgorithm.defaultimplementations.evaluator.FunctionWithCache;
import genericgeneticalgorithm.geneticalgorithm.data_model.IndividualModel;
import genericgeneticalgorithm.geneticalgorithm.data_structure.Attribute;
import genericgeneticalgorithm.geneticalgorithm.data_structure.Individual;

public class Schwefel7 extends FunctionWithCache {
    private Integer argumentCount;

    public Schwefel7(Integer argumentCount) {
        this.argumentCount = argumentCount;
    }

    @Override
    public Double doEvaluate(Individual individual) {
        double result = 0.0;
        for (Attribute attribute : individual.getAttributes()) {
            DoubleAttribute doubleAttribute = (DoubleAttribute) attribute;
            Double value = doubleAttribute.getValue();
            result += -value * Math.sin(Math.sqrt(Math.abs(value)));
        }
        return -result;
    }

    @Override
    public IndividualModel buildIndividualModel() {
        IndividualModel individualModel = new DefaultIndividualModel();
        for (int i = 0; i < argumentCount; ++i)
            individualModel.addAttributeModel(new DoubleAttributeModel("x" + i, -500.0, 500.0, 0.0001));
        return individualModel;
    }

    @Override
    public String getName() {
        return "Schwefel 7";
    }
}
