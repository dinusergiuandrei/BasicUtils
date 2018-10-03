package genericgeneticalgorithm.geneticalgorithm.data_model;

/**
 * Will contain data regarding the constraints of each attribute contained by the IndividualModel
 */
public interface AttributeModel {
    /**
     * @return the name of the respective attribute.
     */
    String getName();

    /**
     * @return the maximum number of bits the given attribute requires for a correct representation.
     */
    Integer getBitCount();
}
