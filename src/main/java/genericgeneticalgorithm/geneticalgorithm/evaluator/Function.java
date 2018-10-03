package genericgeneticalgorithm.geneticalgorithm.evaluator;


import genericgeneticalgorithm.geneticalgorithm.data_model.IndividualModel;
import genericgeneticalgorithm.geneticalgorithm.data_structure.Individual;

/**
 * Will evaluate the individuals in the genetic algorithm.
 */
public interface Function {
    /**
     * @param individual to be evaluated
     * @return a double value.
     */
    Double evaluate(Individual individual);

    /**
     * @return the model which the individuals will have to respect in order to be correctly evaluated.
     */
    IndividualModel getIndividualModel();

    /**
     * For the nice statistics and graphics.
     * @return the name of the function.
     */
    String getName();
}
