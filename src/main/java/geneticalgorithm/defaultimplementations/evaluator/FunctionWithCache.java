package geneticalgorithm.defaultimplementations.evaluator;

import geneticalgorithm.geneticalgorithm.data_model.IndividualModel;
import geneticalgorithm.geneticalgorithm.data_structure.Individual;
import geneticalgorithm.geneticalgorithm.evaluator.Function;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class FunctionWithCache implements Function {
    protected IndividualModel individualModel = null;

    private Map<Individual, Double> cache = new LinkedHashMap<>();

    public Double evaluate(Individual individual){
        if(cache.containsKey(individual))
            return cache.get(individual);
        Double value = doEvaluate(individual);
        cache.put(individual, value);
        return value;
    }

    abstract protected Double doEvaluate(Individual individual);

    abstract public IndividualModel buildIndividualModel();

    public IndividualModel getIndividualModel() {
        if (this.individualModel == null) {
            return buildIndividualModel();
        }
        else return this.individualModel;
    }
}
