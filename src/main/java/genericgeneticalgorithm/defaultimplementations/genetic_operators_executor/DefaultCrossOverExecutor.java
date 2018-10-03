package genericgeneticalgorithm.defaultimplementations.genetic_operators_executor;


import genericgeneticalgorithm.defaultimplementations.datastructure.DefaultIndividual;
import genericgeneticalgorithm.geneticalgorithm.data_structure.Generation;
import genericgeneticalgorithm.geneticalgorithm.data_structure.Individual;
import genericgeneticalgorithm.geneticalgorithm.genetic_operators_executor.CrossOverExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DefaultCrossOverExecutor implements CrossOverExecutor {

     public void apply(Generation generation, Double crossOverRate) {
        List<Individual> individuals = generation.getIndividualsAsList();
        List<Individual> markedForCrossOver = computeIndividualsMarkedForCrossOver(individuals, crossOverRate);

        for (int index = 0; index < markedForCrossOver.size(); index += 2) {
            Individual parent1 = markedForCrossOver.get(index);
            Individual parent2 = markedForCrossOver.get(index + 1);

            boolean[] bitsFromParent1 = parent1.toBits();
            boolean[] bitsFromParent2 = parent2.toBits();

            int bitsCount = bitsFromParent1.length;

            int cuttingPoint = new Random().nextInt(bitsCount);

            boolean[] bitsForChild1 = new boolean[bitsCount];
            boolean[] bitsForChild2 = new boolean[bitsCount];

            for (int position = 0; position <= cuttingPoint; ++position) {
                bitsForChild1[position] = bitsFromParent1[position];
                bitsForChild2[position] = bitsFromParent2[position];
            }

            for (int position = cuttingPoint + 1; position < bitsCount; ++position) {
                bitsForChild1[position] = bitsFromParent2[position];
                bitsForChild2[position] = bitsFromParent1[position];
            }

            DefaultIndividual child1 = new DefaultIndividual();
            DefaultIndividual child2 = new DefaultIndividual();
            child1.setFromBits(generation.getIndividualModel(), bitsForChild1);
            child2.setFromBits(generation.getIndividualModel(), bitsForChild2);

            individuals.remove(parent1);
            individuals.remove(parent2);

            individuals.add(child1);
            individuals.add(child2);
        }
    }

     private List<Individual> computeIndividualsMarkedForCrossOver(List<Individual> individuals, Double crossOverRate) {
        List<Individual> markedForCrossOver = new ArrayList<>();

        Individual unfortunateIndividual = null;
        double maxScore = 0.0;

        Random random = new Random();
        for (Individual individual : individuals) {
            double score = random.nextDouble();
            if (score <= crossOverRate) {
                markedForCrossOver.add(individual);

                if (score > maxScore) {
                    maxScore = score;
                    unfortunateIndividual = individual;
                }
            }
        }
        if (markedForCrossOver.size() % 2 == 1) {
            markedForCrossOver.remove(unfortunateIndividual);
        }
        return markedForCrossOver;
    }
}
