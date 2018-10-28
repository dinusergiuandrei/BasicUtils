package geneticalgorithm.geneticalgorithm.genetic_algoritm_metadata.parameters;


import geneticalgorithm.geneticalgorithm.evaluator.Function;
import geneticalgorithm.geneticalgorithm.genetic_operators_executor.CrossOverExecutor;
import geneticalgorithm.geneticalgorithm.genetic_operators_executor.MutationExecutor;
import geneticalgorithm.geneticalgorithm.genetic_process_executor.EndCondition;
import geneticalgorithm.geneticalgorithm.genetic_process_executor.InitializationMethod;
import geneticalgorithm.geneticalgorithm.genetic_process_executor.SelectionMethod;

public class GaParameters {
    private Double mutationRate;
    private Double crossOverRate;
    private SelectionMethod selectionMethod;
    private EndCondition endCondition;
    private Integer populationSize;
    private Integer iterationsCount;
    private Integer runsCount;
    private Function function;
    private MutationExecutor mutationExecutor;
    private CrossOverExecutor crossOverExecutor;
    private InitializationMethod initializationMethod;

    public GaParameters(Double mutationRate, Double crossOverRate, SelectionMethod selectionMethod,
                        EndCondition endCondition, Integer populationSize, Integer iterationsCount,
                        Integer runsCount, Function function, InitializationMethod initializationMethod,
                        MutationExecutor mutationExecutor, CrossOverExecutor crossOverExecutor) {
        this.mutationRate = mutationRate;
        this.crossOverRate = crossOverRate;
        this.selectionMethod = selectionMethod;
        this.endCondition = endCondition;
        this.populationSize = populationSize;
        this.iterationsCount = iterationsCount;
        this.runsCount = runsCount;
        this.function = function;
        this.initializationMethod = initializationMethod;
        this.mutationExecutor = mutationExecutor;
        this.crossOverExecutor = crossOverExecutor;
    }

    public Double getMutationRate() {
        return mutationRate;
    }
    public Double getCrossOverRate() {
        return crossOverRate;
    }
    public SelectionMethod getSelectionMethod() {
        return selectionMethod;
    }
    public EndCondition getEndCondition() {
        return endCondition;
    }
    public Integer getPopulationSize() {
        return populationSize;
    }
    public Integer getIterationsCount() {
        return iterationsCount;
    }
    public Integer getRunsCount() {
        return runsCount;
    }
    public Function getFunction() {
        return function;
    }
    public InitializationMethod getInitializationMethod() {
        return initializationMethod;
    }
    public MutationExecutor getMutationExecutor() {
        return mutationExecutor;
    }
    public CrossOverExecutor getCrossOverExecutor() {
        return crossOverExecutor;
    }
}
