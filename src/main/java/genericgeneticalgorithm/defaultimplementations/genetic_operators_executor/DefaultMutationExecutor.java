package genericgeneticalgorithm.defaultimplementations.genetic_operators_executor;


import genericgeneticalgorithm.geneticalgorithm.data_structure.Attribute;
import genericgeneticalgorithm.geneticalgorithm.data_structure.Generation;
import genericgeneticalgorithm.geneticalgorithm.data_structure.Individual;
import genericgeneticalgorithm.geneticalgorithm.genetic_operators_executor.MutationExecutor;

import java.util.Random;

public class DefaultMutationExecutor implements MutationExecutor {
    public void apply(Generation generation, Double mutationRate) {
        for (Individual individual : generation.getIndividualsAsList()) {
            mutateIndividual(individual, mutationRate);
        }
    }

    public void mutateIndividual(Individual individual, Double mutationRate) {
        for (Attribute attribute : individual.getAttributes()) {
            mutateAttribute(attribute, mutationRate);
        }
    }

    public void mutateAttribute(Attribute attribute, Double mutationRate) {
        boolean[] bits = attribute.toBits();

        Random random = new Random();
        for (int index = 0; index < bits.length - 1; index++) {
            if (random.nextDouble() <= mutationRate) {
                bits[index] = !bits[index];
            }
        }

        attribute.setFromBits(bits);
    }
}
