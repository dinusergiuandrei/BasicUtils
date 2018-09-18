package charts.pie;

import charts.Entry;

import java.util.ArrayList;
import java.util.List;

public class PieChartTest {

    private static List<Entry> createDataset( ) {
        List<Entry> entries = new ArrayList<>();
        entries.add(new PieChartEntry( "IPhone 5s" , 20d));
        entries.add(new PieChartEntry( "SamSung Grand" , 20d) );
        entries.add(new PieChartEntry( "MotoG" , 40d));
        entries.add(new PieChartEntry( "Nokia Lumia" , 10d));
        return entries;
    }

    public static void main( String[ ] args ) {
        PieChart chart = new PieChart();
        chart.createChart(createDataset(), new PieChartParams());
        chart.display();
    }
}