package geneticalgorithm.defaultimplementations.endingconditions;


import geneticalgorithm.geneticalgorithm.GeneticAlgorithm;
import geneticalgorithm.geneticalgorithm.genetic_process_executor.EndCondition;

public class FixedIterationsCount implements EndCondition {
    @Override
    public Boolean isOver(GeneticAlgorithm geneticAlgorithm) {
        Integer maxCount = geneticAlgorithm.getParameters().getIterationsCount();
        Integer currentCount = geneticAlgorithm.getIterationCount();
        return currentCount >= maxCount;
    }
}
