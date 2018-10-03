package genericgeneticalgorithm.geneticalgorithm.data_structure;


import genericgeneticalgorithm.geneticalgorithm.data_model.IndividualModel;

import java.util.Collection;
import java.util.List;

/**
 * Will contain a collection of individuals.
 */
public interface Generation {
    /**
     * @return the model which all individuals of this generation will follow.
     */
    IndividualModel getIndividualModel();

    /**
     * @param newIndividual which will be added to the generation collection.
     */
    void addIndividual(Individual newIndividual);

    /**
     * Will return the individuals as list.<br>
     * This is useful for the cases when the generation stores the individuals in a data structure which has multiple
     * ways of being iterated through. (e.g. tree).
     * @return a complete list of the individuals in this generation.
     */
    List<Individual> getIndividualsAsList();

    /**
     * @return the individuals contained in the collection which is used by the generation to store them.
     */
    Collection<Individual> getIndividuals();

    /**
     * @return true, if all the individuals respect the individual model<br>
     *         false, otherwise.
     */
    Boolean isValid();
}
