package geneticalgorithm.geneticalgorithm.genetic_algoritm_metadata.parameters;

import cfg.parser.CfgParser;
import geneticalgorithm.defaultimplementations.endingconditions.Convergence;
import geneticalgorithm.defaultimplementations.endingconditions.ConvergenceOrIterations;
import geneticalgorithm.defaultimplementations.endingconditions.FixedIterationsCount;
import geneticalgorithm.defaultimplementations.geneticoperatorsexecutor.DefaultCrossOverExecutor;
import geneticalgorithm.defaultimplementations.geneticoperatorsexecutor.DefaultMutationExecutor;
import geneticalgorithm.defaultimplementations.initializationmethods.GaussianDistributionInitialization;
import geneticalgorithm.defaultimplementations.initializationmethods.UniformDistributionInitialization;
import geneticalgorithm.defaultimplementations.selection_methods.FitnessProportionateSelection;
import geneticalgorithm.defaultimplementations.selection_methods.RewardBasedSelection;
import geneticalgorithm.defaultimplementations.selection_methods.StochasticUniversalSampling;
import geneticalgorithm.defaultimplementations.selection_methods.TournamentSelection;
import geneticalgorithm.geneticalgorithm.evaluator.Function;
import geneticalgorithm.geneticalgorithm.genetic_operators_executor.CrossOverExecutor;
import geneticalgorithm.geneticalgorithm.genetic_operators_executor.MutationExecutor;
import geneticalgorithm.geneticalgorithm.genetic_process_executor.EndCondition;
import geneticalgorithm.geneticalgorithm.genetic_process_executor.InitializationMethod;
import geneticalgorithm.geneticalgorithm.genetic_process_executor.SelectionMethod;

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
