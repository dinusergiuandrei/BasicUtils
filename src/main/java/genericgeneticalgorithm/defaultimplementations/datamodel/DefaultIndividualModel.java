package genericgeneticalgorithm.defaultimplementations.datamodel;


import genericgeneticalgorithm.geneticalgorithm.data_model.AttributeModel;
import genericgeneticalgorithm.geneticalgorithm.data_model.IndividualModel;

import java.util.ArrayList;
import java.util.List;

public class DefaultIndividualModel implements IndividualModel {
    private List<AttributeModel> attributeModelList = new ArrayList<>();

    public void addAttributeModel(AttributeModel attributeModel){
        attributeModelList.add(attributeModel);
    }

    public List<AttributeModel> getAttributeModels() {
        return attributeModelList;
    }
}
