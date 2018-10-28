package geneticalgorithm.geneticalgorithm.genetic_algoritm_metadata.statistics;


import geneticalgorithm.geneticalgorithm.GeneticAlgorithmWithStatistics;
import geneticalgorithm.geneticalgorithm.data_structure.Individual;

import java.util.ArrayList;
import java.util.List;

public class GaStatistics {
    private Double bestGlobalScore = -Double.MAX_VALUE;
    private Individual bestGlobalIndividual = null;
    private List<GaRunStatistics> runStatistics = new ArrayList<>();
    private List<Double> bestScores = new ArrayList<>();
    private List<Individual> bestIndividuals = new ArrayList<>();

    public void initializeRun(GeneticAlgorithmWithStatistics geneticAlgorithm) {
        runStatistics.add(new GaRunStatistics(geneticAlgorithm));
    }

    public void updateAfterIteration(GeneticAlgorithmWithStatistics geneticAlgorithm) {
        this.getCurrentRunStatistics().computeScoreStatistics(geneticAlgorithm.getCurrentGeneration());
    }

    public Double getBestGlobalScore() {
        return bestGlobalScore;
    }

    public Individual getBestGlobalIndividual() {
        return bestGlobalIndividual;
    }

    public void computeFinalStatistics() {
        for (GaRunStatistics statistic : this.runStatistics) {
            statistic.computeTimeStatistics();

            Double runScore = statistic.getBestRunScore();
            Individual bestIndividual = statistic.getBestRunIndividual();

            bestScores.add(runScore);
            bestIndividuals.add(bestIndividual);

            if (runScore > bestGlobalScore) {
                bestGlobalScore = runScore;
                bestGlobalIndividual = bestIndividual;
            }
        }
    }

    public GaRunStatistics getCurrentRunStatistics() {
        return this.runStatistics.get(this.runStatistics.size() - 1);
    }

    /*
    public String toStringSimple(String separator){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(initializationTime).append(separator)
                .append(bestRunScore).append(separator)
                .append(bestRunIndividual).append(separator)
                .append(totalMutationTime).append(separator)
                .append(totalCrossOverTime).append(separator)
                .append(totalSelectionTime).append(separator)
                .append(averageMutationTime).append(separator)
                .append(averageCrossOverTime).append(separator)
                .append(averageSelectionTime).append(separator)
                .append(minMutationTime).append(separator)
                .append(minCrossOverTime).append(separator)
                .append(minSelectionTime).append(separator)
                .append(maxMutationTime).append(separator)
                .append(maxCrossOverTime).append(separator)
                .append(maxSelectionTime);
        return stringBuilder.toString();
    }
     */

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder
                .append("bestGlobalScore = ").append(bestGlobalScore).append("\n")
                .append("bestGlobalIndividual = ").append(bestGlobalIndividual.toString("; ")).append("\n");

        String separator = " | ";
        stringBuilder
                .append("initializationTime").append(separator)
                .append("bestRunScore").append(separator)
                .append("totalMutationTime").append(separator)
                .append("totalCrossOverTime").append(separator)
                .append("totalSelectionTime").append(separator)
                .append("averageMutationTime").append(separator)
                .append("averageCrossOverTime").append(separator)
                .append("averageSelectionTime").append(separator)
                .append("minMutationTime").append(separator)
                .append("minCrossOverTime").append(separator)
                .append("minSelectionTime").append(separator)
                .append("maxMutationTime").append(separator)
                .append("maxCrossOverTime").append(separator)
                .append("maxSelectionTime").append(separator)
                .append("bestRunIndividual").append("\n");
        for (int index = 0; index < this.runStatistics.size(); index++) {
            stringBuilder.append("Run count = ").append(index).append(" { ").append(this.runStatistics.get(index).toStringSimple(separator)).append(" }\n");
        }
        return stringBuilder.toString();
    }
}
