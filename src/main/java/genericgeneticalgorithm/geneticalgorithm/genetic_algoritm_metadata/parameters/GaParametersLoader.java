package genericgeneticalgorithm.geneticalgorithm.genetic_algoritm_metadata.parameters;

import cfg.parser.CfgParser;
import genericgeneticalgorithm.defaultimplementations.ending_conditions.Convergence;
import genericgeneticalgorithm.defaultimplementations.ending_conditions.ConvergenceOrIterations;
import genericgeneticalgorithm.defaultimplementations.ending_conditions.FixedIterationsCount;
import genericgeneticalgorithm.defaultimplementations.genetic_operators_executor.DefaultCrossOverExecutor;
import genericgeneticalgorithm.defaultimplementations.genetic_operators_executor.DefaultMutationExecutor;
import genericgeneticalgorithm.defaultimplementations.initialization_methods.GaussianDistributionInitialization;
import genericgeneticalgorithm.defaultimplementations.initialization_methods.UniformDistributionInitialization;
import genericgeneticalgorithm.defaultimplementations.selection_methods.FitnessProportionateSelection;
import genericgeneticalgorithm.defaultimplementations.selection_methods.RewardBasedSelection;
import genericgeneticalgorithm.defaultimplementations.selection_methods.StochasticUniversalSampling;
import genericgeneticalgorithm.defaultimplementations.selection_methods.TournamentSelection;
import genericgeneticalgorithm.geneticalgorithm.evaluator.Function;
import genericgeneticalgorithm.geneticalgorithm.genetic_operators_executor.CrossOverExecutor;
import genericgeneticalgorithm.geneticalgorithm.genetic_operators_executor.MutationExecutor;
import genericgeneticalgorithm.geneticalgorithm.genetic_process_executor.EndCondition;
import genericgeneticalgorithm.geneticalgorithm.genetic_process_executor.InitializationMethod;
import genericgeneticalgorithm.geneticalgorithm.genetic_process_executor.SelectionMethod;

import java.util.Map;

public class GaParametersLoader {
    public GaParameters loadFromFile(
            String path, Function function,
            MutationExecutor mutationExecutor, CrossOverExecutor crossOverExecutor) throws Exception {
        CfgParser parser = new CfgParser();
        Map<String, String> map = parser.parseFile(path);

        Integer runsCount = Integer.parseInt(map.get("runsCount"));
        Integer iterationsCount = Integer.parseInt(map.get("iterationsCount"));
        Integer populationSize = Integer.parseInt(map.get("populationSize"));
        Double mutationRate = Double.parseDouble(map.get("mutationRate"));
        Double crossOverRate = Double.parseDouble(map.get("crossOverRate"));

        InitializationMethod initializationMethod;
        switch (map.get("initializationMethod")) {
            case "UniformDistribution":
                initializationMethod = new UniformDistributionInitialization();
                break;
            case "GaussianDistribution":
                initializationMethod = new GaussianDistributionInitialization();
                break;
            default:
                throw new IllegalArgumentException(
                        "Could not determine a initialization method. " +
                                "Please use one of the following: " +
                                "UniformDistribution|GaussianDistribution");
        }

        SelectionMethod selectionMethod;
        switch (map.get("selectionMethod")) {
            case "FitnessProportionate":
                selectionMethod = new FitnessProportionateSelection();
                break;
            case "RewardBased":
                selectionMethod = new RewardBasedSelection();
                break;
            case "StochasticUniversalSampling":
                selectionMethod = new StochasticUniversalSampling();
                break;
            case "Tournament":
                selectionMethod = new TournamentSelection();
                break;
            default:
                throw new IllegalArgumentException(
                        "Could not determine a selection method. " +
                                "Please use one of the following: " +
                                "FitnessProportionate|RewardBased|StochasticUniversalSampling|Tournament");
        }

        EndCondition endCondition;
        switch (map.get("endCondition")) {
            case "Convergence":
                endCondition = new Convergence();
                break;
            case "FixedIterations":
                endCondition = new FixedIterationsCount();
                break;
            case "ConvergenceOrIterations":
                endCondition = new ConvergenceOrIterations();
                break;
            default:
                throw new IllegalArgumentException(
                        "Could not determine a ending condition. " +
                                "Please use one of the following: " +
                                "Convergence|FixedIterations|ConvergenceOrIterations");
        }

        return new GaParameters(mutationRate, crossOverRate, selectionMethod,
                endCondition, populationSize, iterationsCount, runsCount,
                function, initializationMethod, mutationExecutor, crossOverExecutor);
    }

    public GaParameters loadFromFile(String path, Function function) throws Exception {
        return loadFromFile(path, function, new DefaultMutationExecutor(), new DefaultCrossOverExecutor());
    }
}
