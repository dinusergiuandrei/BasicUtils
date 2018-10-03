package genericgeneticalgorithm.geneticalgorithm.genetic_process_executor;


import genericgeneticalgorithm.geneticalgorithm.GeneticAlgorithm;

/**
 * Checks whether the genetic algorithm has to stop or not.
 */
public interface EndCondition {
    Boolean isOver(GeneticAlgorithm geneticAlgorithm);
}
