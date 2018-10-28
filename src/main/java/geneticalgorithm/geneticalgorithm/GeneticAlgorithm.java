package geneticalgorithm.geneticalgorithm;

import geneticalgorithm.geneticalgorithm.data_structure.Generation;
import geneticalgorithm.geneticalgorithm.data_structure.Individual;
import geneticalgorithm.geneticalgorithm.genetic_algoritm_metadata.parameters.GaParameters;
import geneticalgorithm.geneticalgorithm.genetic_algoritm_metadata.statistics.GaResult;


public class GeneticAlgorithm {

    protected Generation currentGeneration;
    protected Integer iterationCount;

    protected GaParameters parameters;

    protected GaResult result;

    public GeneticAlgorithm(GaParameters parameters) {
        this.parameters = parameters;
    }

    public final GaResult run() {
        initializeGeneticAlgorithm();
        for (Integer runCount = 0; runCount < parameters.getRunsCount(); runCount++) {
            initializeRun();
            while (!isOver()) {
                applyGeneticOperations();
                selectNextGeneration();
                iterate();
            }
            finalizeRun();
        }
        finalizeGeneticAlgorithm();
        return this.result;
    }

    void initializeGeneticAlgorithm(){
        this.result = new GaResult();
        this.result.setBestScore(-Double.MAX_VALUE);
    }

    void initializeRun() {
        Generation firstGeneration = parameters
                .getInitializationMethod()
                .initializeGeneration(
                        parameters.getPopulationSize(),
                        parameters.getFunction().getIndividualModel()
                );
        this.setCurrentGeneration(firstGeneration);
        this.iterationCount = 0;
    }

    void finalizeGeneticAlgorithm() {
    }

    void finalizeRun() {
        for (Individual individual : this.currentGeneration.getIndividualsAsList()) {
            Double result = this.parameters.getFunction().evaluate(individual);
            if (result > this.result.getBestScore()) {
                this.result.setBestScore(result);
            }
        }
    }

    private void applyGeneticOperations() {
        applyMutations();
        applyCrossOver();
    }

    void selectNextGeneration() {
        Generation newGeneration = parameters.getSelectionMethod().selectNextGeneration(currentGeneration, parameters.getFunction());
        this.setCurrentGeneration(newGeneration);
    }

    void iterate() {
        ++iterationCount;
    }

    void applyMutations() {
        parameters.getMutationExecutor().apply(currentGeneration, parameters.getMutationRate());
    }

    void applyCrossOver() {
        parameters.getCrossOverExecutor().apply(currentGeneration, parameters.getCrossOverRate());
    }

    public void setCurrentGeneration(Generation newGeneration) {
        this.currentGeneration = newGeneration;
    }

    private Boolean isOver() {
        return parameters.getEndCondition().isOver(this);
    }

    public GaParameters getParameters() {
        return parameters;
    }

    public Generation getCurrentGeneration() {
        return currentGeneration;
    }

    public Integer getIterationCount() {
        return iterationCount;
    }

    public GaResult getResult() {
        return result;
    }
}
