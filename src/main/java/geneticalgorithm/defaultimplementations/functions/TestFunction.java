package geneticalgorithm.defaultimplementations.functions;


import geneticalgorithm.defaultimplementations.datamodel.DefaultIndividualModel;
import geneticalgorithm.defaultimplementations.datamodel.DoubleAttributeModel;
import geneticalgorithm.defaultimplementations.datastructure.DoubleAttribute;
import geneticalgorithm.defaultimplementations.evaluator.FunctionWithCache;
import geneticalgorithm.geneticalgorithm.data_model.IndividualModel;
import geneticalgorithm.geneticalgorithm.data_structure.Attribute;
import geneticalgorithm.geneticalgorithm.data_structure.Individual;

public class TestFunction extends FunctionWithCache {
    private Integer argumentCount;

    public TestFunction(Integer argumentCount) {
        this.argumentCount = argumentCount;
    }

    @Override
    public Double doEvaluate(Individual individual) {
        double result = 0.0;
        for (Attribute attribute : individual.getAttributes()) {
            DoubleAttribute doubleAttribute = (DoubleAttribute) attribute;
            double value = doubleAttribute.getValue();
            result += value * value;
        }
        return result;
    }

    @Override
    public IndividualModel buildIndividualModel() {
        this.individualModel = new DefaultIndividualModel();
        for (int i = 0; i < argumentCount; ++i)
            individualModel.addAttributeModel(new DoubleAttributeModel("x" + i, 0.0, 5.0, 0.1));
        return individualModel;
    }

    @Override
    public String getName() {
        return "sum(x^2)";
    }
}

