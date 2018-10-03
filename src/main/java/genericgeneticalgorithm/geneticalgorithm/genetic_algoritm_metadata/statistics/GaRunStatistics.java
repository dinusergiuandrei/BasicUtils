package genericgeneticalgorithm.geneticalgorithm.genetic_algoritm_metadata.statistics;

import genericgeneticalgorithm.geneticalgorithm.GeneticAlgorithmWithStatistics;
import genericgeneticalgorithm.geneticalgorithm.data_structure.Generation;
import genericgeneticalgorithm.geneticalgorithm.data_structure.Individual;

import java.util.ArrayList;
import java.util.List;

public class GaRunStatistics {
    private Long initializationTime;
    private List<Long> mutationTimes = new ArrayList<>();
    private List<Long> crossOverTimes = new ArrayList<>();
    private List<Long> selectionTimes = new ArrayList<>();
    private List<Double> bestScores = new ArrayList<>();
    private List<Double> averageScores = new ArrayList<>();

    private GeneticAlgorithmWithStatistics geneticAlgorithm;

    private Double bestRunScore = -Double.MAX_VALUE;
    private Individual bestRunIndividual = null;

    private Long totalMutationTime = 0L;
    private Long totalCrossOverTime = 0L;
    private Long totalSelectionTime = 0L;

    private double averageMutationTime;
    private double averageCrossOverTime;
    private double averageSelectionTime;

    private Long minMutationTime = Long.MAX_VALUE;
    private Long minCrossOverTime = Long.MAX_VALUE;
    private Long minSelectionTime = Long.MAX_VALUE;

    private Long maxMutationTime = -Long.MAX_VALUE;
    private Long maxCrossOverTime = -Long.MAX_VALUE;
    private Long maxSelectionTime = -Long.MAX_VALUE;

    public GaRunStatistics(GeneticAlgorithmWithStatistics geneticAlgorithm) {
        this.geneticAlgorithm = geneticAlgorithm;
    }

    public void computeScoreStatistics(Generation generation) {
        List<Individual> individuals = generation.getIndividualsAsList();
        Double bestIterationScore = -Double.MAX_VALUE;
        Individual bestIterationIndividual = null;
        Double sum = 0.0;
        for (Individual individual : individuals) {
            Double result = geneticAlgorithm.getParameters().getFunction().evaluate(individual);
            if(result > bestIterationScore){
                bestIterationScore = result;
                bestIterationIndividual = individual;
            }
            sum+=result;
        }

        this.bestScores.add(bestIterationScore);
        this.averageScores.add(sum/individuals.size());

        if (bestIterationScore > bestRunScore) {
            bestRunScore = bestIterationScore;
            bestRunIndividual = bestIterationIndividual;
        }
    }

    public void computeTimeStatistics() {
        Integer iterationCount = selectionTimes.size();

        for (Integer iteration = 0; iteration < iterationCount; iteration++) {
            Long mutationTime = mutationTimes.get(iteration);
            Long crossOverTime = crossOverTimes.get(iteration);
            Long selectionTime = selectionTimes.get(iteration);

            this.totalMutationTime += mutationTime;
            this.totalCrossOverTime += crossOverTime;
            this.totalSelectionTime += selectionTime;

            minMutationTime = Math.min(minMutationTime, mutationTime);
            minCrossOverTime = Math.min(minCrossOverTime, crossOverTime);
            minSelectionTime = Math.min(minSelectionTime, selectionTime);

            maxMutationTime = Math.max(maxMutationTime, mutationTime);
            maxCrossOverTime = Math.max(maxCrossOverTime, crossOverTime);
            maxSelectionTime = Math.max(maxSelectionTime, selectionTime);
        }

        this.averageMutationTime = this.totalMutationTime * 1.0 / iterationCount;
        this.averageCrossOverTime = this.totalCrossOverTime * 1.0 / iterationCount;
        this.averageSelectionTime = this.totalSelectionTime * 1.0 / iterationCount;
    }

    public Double getBestRunScore() {
        return bestRunScore;
    }

    public Individual getBestRunIndividual() {
        return bestRunIndividual;
    }

    public void addInitializationTime(Long initializationTime) {
        this.initializationTime = initializationTime;
    }

    public void addMutationTime(Long mutationTime) {
        this.mutationTimes.add(mutationTime);
    }

    public void addCrossOverTime(Long crossOverTime) {
        this.crossOverTimes.add(crossOverTime);
    }

    public void addSelectionTime(Long selectionTime) {
        this.selectionTimes.add(selectionTime);
    }


    public Long getInitializationTime() {
        return initializationTime;
    }

    public List<Long> getMutationTimes() {
        return mutationTimes;
    }

    public List<Long> getCrossOverTimes() {
        return crossOverTimes;
    }

    public List<Long> getSelectionTimes() {
        return selectionTimes;
    }

    public GeneticAlgorithmWithStatistics getGeneticAlgorithm() {
        return geneticAlgorithm;
    }

    public Long getTotalMutationTime() {
        return totalMutationTime;
    }

    public Long getTotalCrossOverTime() {
        return totalCrossOverTime;
    }

    public Long getTotalSelectionTime() {
        return totalSelectionTime;
    }

    public double getAverageMutationTime() {
        return averageMutationTime;
    }

    public double getAverageCrossOverTime() {
        return averageCrossOverTime;
    }

    public double getAverageSelectionTime() {
        return averageSelectionTime;
    }

    public Long getMinMutationTime() {
        return minMutationTime;
    }

    public Long getMinCrossOverTime() {
        return minCrossOverTime;
    }

    public Long getMinSelectionTime() {
        return minSelectionTime;
    }

    public Long getMaxMutationTime() {
        return maxMutationTime;
    }

    public Long getMaxCrossOverTime() {
        return maxCrossOverTime;
    }

    public Long getMaxSelectionTime() {
        return maxSelectionTime;
    }

    public String toStringSimple(String separator){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(initializationTime).append(separator)
                .append(bestRunScore).append(separator)
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
                .append(maxSelectionTime).append(separator)
                .append(bestRunIndividual.toString("; "));
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "GaRunStatistics{" +
                "initializationTime=" + initializationTime +
                ", bestScores=" + bestScores +
                ", averageScores=" + averageScores +
                ", bestRunScore=" + bestRunScore +
                ", bestRunIndividual=" + bestRunIndividual +
                ", totalMutationTime=" + totalMutationTime +
                ", totalCrossOverTime=" + totalCrossOverTime +
                ", totalSelectionTime=" + totalSelectionTime +
                ", averageMutationTime=" + averageMutationTime +
                ", averageCrossOverTime=" + averageCrossOverTime +
                ", averageSelectionTime=" + averageSelectionTime +
                ", minMutationTime=" + minMutationTime +
                ", minCrossOverTime=" + minCrossOverTime +
                ", minSelectionTime=" + minSelectionTime +
                ", maxMutationTime=" + maxMutationTime +
                ", maxCrossOverTime=" + maxCrossOverTime +
                ", maxSelectionTime=" + maxSelectionTime +
                '}';
    }
}
