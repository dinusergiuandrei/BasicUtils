package geneticalgorithm.geneticalgorithm.genetic_operators_executor;

import geneticalgorithm.geneticalgorithm.data_structure.Attribute;
import geneticalgorithm.geneticalgorithm.data_structure.Generation;
import geneticalgorithm.geneticalgorithm.data_structure.Individual;

/**
 * Will execute the cross-over operation over a generation, with a given cross-over rate.
 */
public interface MutationExecutor {
    void apply(Generation generation, Double mutationRate);

    void mutateIndividual(Individual individual, Double mutationRate);

    void mutateAttribute(Attribute attribute, Double mutationRate);
}
