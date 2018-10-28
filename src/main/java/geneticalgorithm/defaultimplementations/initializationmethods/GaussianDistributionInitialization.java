package geneticalgorithm.defaultimplementations.initializationmethods;


import geneticalgorithm.defaultimplementations.datamodel.DoubleAttributeModel;
import geneticalgorithm.defaultimplementations.datastructure.DefaultGeneration;
import geneticalgorithm.defaultimplementations.datastructure.DefaultIndividual;
import geneticalgorithm.defaultimplementations.datastructure.DoubleAttribute;
import geneticalgorithm.geneticalgorithm.data_model.AttributeModel;
import geneticalgorithm.geneticalgorithm.data_model.IndividualModel;
import geneticalgorithm.geneticalgorithm.data_structure.Attribute;
import geneticalgorithm.geneticalgorithm.data_structure.Generation;
import geneticalgorithm.geneticalgorithm.data_structure.Individual;
import geneticalgorithm.geneticalgorithm.genetic_process_executor.InitializationMethod;

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
