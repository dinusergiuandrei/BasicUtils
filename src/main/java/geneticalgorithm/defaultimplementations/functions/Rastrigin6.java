package geneticalgorithm.defaultimplementations.functions;

import geneticalgorithm.defaultimplementations.datamodel.DefaultIndividualModel;
import geneticalgorithm.defaultimplementations.datamodel.DoubleAttributeModel;
import geneticalgorithm.defaultimplementations.datastructure.DoubleAttribute;
import geneticalgorithm.defaultimplementations.evaluator.FunctionWithCache;
import geneticalgorithm.geneticalgorithm.data_model.IndividualModel;
import geneticalgorithm.geneticalgorithm.data_structure.Attribute;
import geneticalgorithm.geneticalgorithm.data_structure.Individual;

public class Rastrigin6 extends FunctionWithCache {
    private Integer argumentCount;

    public Rastrigin6(Integer argumentCount) {
        this.argumentCount = argumentCount;
    }

    @Override
    public Double doEvaluate(Individual individual) {
        double result = 10.0 * individual.getAttributes().size();
        for (Attribute attribute : individual.getAttributes()) {
            DoubleAttribute doubleAttribute = (DoubleAttribute) attribute;
            double value = doubleAttribute.getValue();
            result += Math.pow(value, 2) - 10 * Math.cos(2 * Math.PI * value);
        }
        return -result;
    }

    @Override
    public IndividualModel buildIndividualModel() {
        IndividualModel individualModel = new DefaultIndividualModel();
        for (int i = 0; i < argumentCount; ++i)
            individualModel.addAttributeModel(new DoubleAttributeModel("x" + i, -5.12, 5.12, 0.01));
        return individualModel;
    }

    @Override
    public String getName() {
        return "Rastrigin 6";
    }
}
