package geneticalgorithm.defaultimplementations.selection_methods;


import geneticalgorithm.defaultimplementations.datastructure.DefaultGeneration;
import geneticalgorithm.geneticalgorithm.data_structure.Generation;
import geneticalgorithm.geneticalgorithm.data_structure.Individual;
import geneticalgorithm.geneticalgorithm.evaluator.Function;
import geneticalgorithm.geneticalgorithm.genetic_process_executor.SelectionMethod;

import java.util.*;

/**
 * https://en.wikipedia.org/wiki/Tournament_selection
  */
public class TournamentSelection implements SelectionMethod {
    @Override
    public Generation selectNextGeneration(Generation generation, Function function) {
        List<Individual> individuals = generation.getIndividualsAsList();
        Map<Individual, Double> results = new LinkedHashMap<>();

        individuals.forEach(individual -> results.put(individual, function.evaluate(individual)));

        Integer tournamentSize = individuals.size()/5;

        Generation newGeneration = new DefaultGeneration(generation.getIndividualModel());

        for (int index = 0; index < individuals.size(); index++) {
            newGeneration.addIndividual(computeWinner(selectKIndividuals(individuals, tournamentSize), results));
        }

        return newGeneration;
    }

    private List<Individual> selectKIndividuals(List<Individual> individuals, Integer k){
        List<Individual> selected = new ArrayList<>();

        Random random = new Random();
        while(selected.size()<k){
            Individual individual = individuals.get(random.nextInt(individuals.size()));
            if(!selected.contains(individual))
                selected.add(individual);
        }
        return selected;
    }

    private Individual computeWinner(List<Individual> individuals, Map<Individual, Double> results){
        Individual winner = individuals.get(0);
        Double bestScore = results.get(winner);

        for (Individual individual : individuals) {
            Double result = results.get(individual);
            if(result>bestScore){
                winner = individual;
                bestScore = result;
            }
        }
        return winner;
    }

}
