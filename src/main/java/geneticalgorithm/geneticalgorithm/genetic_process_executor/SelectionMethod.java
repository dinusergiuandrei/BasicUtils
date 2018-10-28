package geneticalgorithm.geneticalgorithm.genetic_process_executor;

import geneticalgorithm.geneticalgorithm.data_structure.Generation;
import geneticalgorithm.geneticalgorithm.evaluator.Function;

/**
 * Selects the next generation in a genetic algorithm.
 */
public interface SelectionMethod {
    Generation selectNextGeneration(Generation generation, Function function);
}
