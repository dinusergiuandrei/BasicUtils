package genericgeneticalgorithm.geneticalgorithm.genetic_algoritm_metadata.statistics;


public class GaStatisticsPrinter {
    public void displayResults(GaStatistics statistics){
        System.out.println("Best GA score: " + statistics.getBestGlobalScore());
        System.out.println("Best individual:\n" + statistics.getBestGlobalIndividual().toString());
    }

    public void saveResults(GaStatistics statistics, String filePath){

    }

}
