package geneticalgorithm.geneticalgorithm;


import geneticalgorithm.geneticalgorithm.genetic_algoritm_metadata.parameters.GaParameters;
import geneticalgorithm.geneticalgorithm.genetic_algoritm_metadata.statistics.GaResultWithStatistics;
import geneticalgorithm.geneticalgorithm.genetic_algoritm_metadata.statistics.GaStatistics;
import progress.TimeKeeper;

public class GeneticAlgorithmWithStatistics extends GeneticAlgorithm {

    private GaStatistics statistics;

    public GeneticAlgorithmWithStatistics(GaParameters parameters) {
        super(parameters);
        this.statistics = new GaStatistics();
    }

    void initializeRun() {
        TimeKeeper timeKeeper = new TimeKeeper();
        super.initializeRun();
        this.statistics.initializeRun(this);
        statistics.getCurrentRunStatistics().addInitializationTime(timeKeeper.toc());
    }

    @Override
    void initializeGeneticAlgorithm() {
        this.statistics = new GaStatistics();
        this.result = new GaResultWithStatistics(this.statistics);
        this.result.setBestScore(-Double.MAX_VALUE);
    }

    @Override
    void finalizeGeneticAlgorithm() {
        statistics.computeFinalStatistics();
    }

    void selectNextGeneration() {
        TimeKeeper timeKeeper = new TimeKeeper();
        super.selectNextGeneration();
        statistics.getCurrentRunStatistics().addSelectionTime(timeKeeper.toc());
    }

    void iterate(){
        this.statistics.updateAfterIteration(this);
        super.iterate();
    }

    void applyMutations() {
        TimeKeeper timeKeeper = new TimeKeeper();
        super.applyMutations();
        statistics.getCurrentRunStatistics().addMutationTime(timeKeeper.toc());
    }
    void applyCrossOver() {
        TimeKeeper timeKeeper = new TimeKeeper();
        super.applyCrossOver();
        statistics.getCurrentRunStatistics().addCrossOverTime(timeKeeper.toc());
    }

}
