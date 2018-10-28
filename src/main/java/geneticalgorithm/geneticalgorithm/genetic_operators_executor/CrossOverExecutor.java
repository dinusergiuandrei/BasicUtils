package geneticalgorithm.geneticalgorithm.genetic_operators_executor;

import geneticalgorithm.geneticalgorithm.data_structure.Generation;

/**
 * Will execute the cross-over operation over a generation, with a given cross-over rate.
 */
public interface CrossOverExecutor {
    void apply(Generation generation, Double crossOverRate);
}
