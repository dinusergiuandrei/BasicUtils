package genericgeneticalgorithm.geneticalgorithm.genetic_process_executor;

import genericgeneticalgorithm.geneticalgorithm.data_model.IndividualModel;
import genericgeneticalgorithm.geneticalgorithm.data_structure.Generation;

/**
 * Instantiates in first generation of the genetic algorithm.
 */
public interface InitializationMethod {
    Generation initializeGeneration(Integer populationSize, IndividualModel parameters);
}
