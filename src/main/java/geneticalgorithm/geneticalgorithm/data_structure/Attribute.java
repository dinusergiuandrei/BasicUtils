package geneticalgorithm.geneticalgorithm.data_structure;


import geneticalgorithm.geneticalgorithm.data_model.AttributeModel;

/**
 * Will contain data of a value, part of an individual's set of attributes.
 */
public interface Attribute {
    /**
     * @return the intrinsic state.
     */
    Object getValue();

    /**
     * @return an array of bits representing the transformed intrinsic state.
     */
    boolean[] toBits();

    /**
     * Will alter the attribute's state such as the  {@link #toBits()} method will the return the given bits.
     * @param bits
     */
    void setFromBits(boolean[] bits);

    /**
     * @return the model of this attribute.
     */
    AttributeModel getModel();

    /**
     * @return true, if the model constraints are respected. <br>
     *         false, otherwise.
     */
    Boolean isValid();
}
