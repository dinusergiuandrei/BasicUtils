package geneticalgorithm.geneticalgorithm.genetic_algoritm_metadata.statistics;

public class GaResult {
    private Double bestScore;

    public Double getBestScore() {
        return bestScore;
    }

    public void setBestScore(Double bestScore) {
        this.bestScore = bestScore;
    }

    @Override
    public String toString() {
        return "Best score : " + bestScore;
    }
}
