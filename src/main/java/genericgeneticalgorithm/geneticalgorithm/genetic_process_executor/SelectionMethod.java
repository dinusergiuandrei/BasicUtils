package genericgeneticalgorithm.geneticalgorithm.genetic_process_executor;

import genericgeneticalgorithm.geneticalgorithm.data_structure.Generation;
import genericgeneticalgorithm.geneticalgorithm.evaluator.Function;

/**
 * Selects the next generation in a genetic algorithm.
 */
public interface SelectionMethod {
    Generation selectNextGeneration(Generation generation, Function function);
}
