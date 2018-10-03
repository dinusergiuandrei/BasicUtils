package genericgeneticalgorithm.geneticalgorithm.data_structure;


import genericgeneticalgorithm.geneticalgorithm.data_model.IndividualModel;

import java.util.Collection;

/**
 * Contains data describing a complete set of arguments of the function to be optimized.
 * It can use any way of structuring the data.
 */
public interface Individual {
    /**
     * Will only be called at initialization. This method alters the individual's internal state.
     * @param newAttribute
     */
    void addAttribute(Attribute newAttribute);

    /**
     * @return a collection of all the attributes of this individual.
     */
    Collection<Attribute> getAttributes();

    /**
     * @return an array of bits containing this individual's bit representation.
     */
    boolean[] toBits();

    /**
     * Will change this individual's internal state such as the {@link #toBits()} method returns the given bits.
     * @param model which the individual will respect when being built from the bits.
     * @param bits which will give the data from which the individual will be built.
     */
    void setFromBits(IndividualModel model, boolean[] bits);

    /**
     * @return true, if the individual respects the individual model <br>
     *         false, otherwise.
     */
    Boolean isValid();

    String toString(String attributeSeparator);
}
