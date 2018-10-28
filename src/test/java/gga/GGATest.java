package gga;

import geneticalgorithm.defaultimplementations.functions.TestFunction;
import geneticalgorithm.geneticalgorithm.GeneticAlgorithm;
import geneticalgorithm.geneticalgorithm.GeneticAlgorithmWithStatistics;
import geneticalgorithm.geneticalgorithm.evaluator.Function;
import geneticalgorithm.geneticalgorithm.genetic_algoritm_metadata.parameters.GaParameters;
import geneticalgorithm.geneticalgorithm.genetic_algoritm_metadata.parameters.GaParametersLoader;

public class GGATest {
    public static void main(String args[]) throws Exception {
        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithmWithStatistics(buildParams(args, new TestFunction(5)));
        geneticAlgorithm.run();
        displayResults(geneticAlgorithm);
    }

    private static GaParameters buildParams(String args[], Function function) throws Exception {
        return new GaParametersLoader().loadFromFile(args[0], function);
    }

    private static void displayResults(GeneticAlgorithm geneticAlgorithm){
//        GaStatisticsPrinter printer = new GaStatisticsPrinter();
//        printer.displayResults(geneticAlgorithm.getResult().toString());
        System.out.println(geneticAlgorithm.getResult().toString());
    }
}
