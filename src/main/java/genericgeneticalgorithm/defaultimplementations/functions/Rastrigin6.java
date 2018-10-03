package genericgeneticalgorithm.defaultimplementations.functions;

import genericgeneticalgorithm.defaultimplementations.datamodel.DefaultIndividualModel;
import genericgeneticalgorithm.defaultimplementations.datamodel.DoubleAttributeModel;
import genericgeneticalgorithm.defaultimplementations.datastructure.DoubleAttribute;
import genericgeneticalgorithm.defaultimplementations.evaluator.FunctionWithCache;
import genericgeneticalgorithm.geneticalgorithm.data_model.IndividualModel;
import genericgeneticalgorithm.geneticalgorithm.data_structure.Attribute;
import genericgeneticalgorithm.geneticalgorithm.data_structure.Individual;

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
