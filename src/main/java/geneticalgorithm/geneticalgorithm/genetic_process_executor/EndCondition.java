package geneticalgorithm.geneticalgorithm.genetic_process_executor;


import geneticalgorithm.geneticalgorithm.GeneticAlgorithm;

/**
 * Checks whether the genetic algorithm has to stop or not.
 */
public interface EndCondition {
    Boolean isOver(GeneticAlgorithm geneticAlgorithm);
}
