package geneticalgorithm.geneticalgorithm.genetic_process_executor;

import geneticalgorithm.geneticalgorithm.data_model.IndividualModel;
import geneticalgorithm.geneticalgorithm.data_structure.Generation;

/**
 * Instantiates in first generation of the genetic algorithm.
 */
public interface InitializationMethod {
    Generation initializeGeneration(Integer populationSize, IndividualModel parameters);
}
