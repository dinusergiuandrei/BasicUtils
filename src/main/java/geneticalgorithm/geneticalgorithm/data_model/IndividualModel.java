package geneticalgorithm.geneticalgorithm.data_model;

import java.util.Collection;

/**
 * Will provide a structure which all individuals from a population will follow.
 */
public interface IndividualModel {
    /**
     * Modify the individual model to accommodate another attribute.
     * @param attributeModel the model of the new attribute.
     */
    void addAttributeModel(AttributeModel attributeModel);

    /**
     * @return all the attribute models contained by the individual model.
     */
    Collection<AttributeModel> getAttributeModels();
}
