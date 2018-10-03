package genericgeneticalgorithm.geneticalgorithm.genetic_algoritm_metadata.statistics;

public class GaResultWithStatistics extends GaResult {

    private GaStatistics statistics;

    public GaResultWithStatistics(GaStatistics statistics) {
        this.statistics = statistics;
    }

    public GaStatistics getStatistics() {
        return statistics;
    }

    @Override
    public String toString() {
        return this.statistics.toString();
    }
}
