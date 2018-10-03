package genericgeneticalgorithm.defaultimplementations.initialization_methods;


import genericgeneticalgorithm.defaultimplementations.datamodel.DoubleAttributeModel;
import genericgeneticalgorithm.defaultimplementations.datastructure.DefaultGeneration;
import genericgeneticalgorithm.defaultimplementations.datastructure.DefaultIndividual;
import genericgeneticalgorithm.defaultimplementations.datastructure.DoubleAttribute;
import genericgeneticalgorithm.geneticalgorithm.data_model.AttributeModel;
import genericgeneticalgorithm.geneticalgorithm.data_model.IndividualModel;
import genericgeneticalgorithm.geneticalgorithm.data_structure.Attribute;
import genericgeneticalgorithm.geneticalgorithm.data_structure.Generation;
import genericgeneticalgorithm.geneticalgorithm.data_structure.Individual;
import genericgeneticalgorithm.geneticalgorithm.genetic_process_executor.InitializationMethod;

import java.util.Random;

public class GaussianDistributionInitialization implements InitializationMethod {
    @Override
    public Generation initializeGeneration(Integer populationSize, IndividualModel individualModel) {
        Generation generation = new DefaultGeneration(individualModel);
        Random random = new Random();
        for (Integer index = 0; index < populationSize; index++) {
            Individual individual = new DefaultIndividual();
            for (AttributeModel attributeModel : individualModel.getAttributeModels()) {
                DoubleAttributeModel model = (DoubleAttributeModel) attributeModel;
                Double minValue = model.getMinValue();
                Double maxValue = model.getMaxValue();
                Double value = random.nextGaussian() * (maxValue - minValue) + minValue;
                Attribute attribute = new DoubleAttribute(model, value);
                individual.addAttribute(attribute);
            }
            generation.addIndividual(individual);
        }
        return generation;
    }
}
