package genericgeneticalgorithm.geneticalgorithm.genetic_operators_executor;

import genericgeneticalgorithm.geneticalgorithm.data_structure.Attribute;
import genericgeneticalgorithm.geneticalgorithm.data_structure.Generation;
import genericgeneticalgorithm.geneticalgorithm.data_structure.Individual;

/**
 * Will execute the cross-over operation over a generation, with a given cross-over rate.
 */
public interface MutationExecutor {
    void apply(Generation generation, Double mutationRate);

    void mutateIndividual(Individual individual, Double mutationRate);

    void mutateAttribute(Attribute attribute, Double mutationRate);
}
