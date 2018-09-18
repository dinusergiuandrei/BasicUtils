package charts.line;

import charts.Entry;

import java.util.ArrayList;
import java.util.List;


public class LineChartTest{

    private static List<Entry> createDataset( ) {
        List<Entry> entries = new ArrayList<>();

        entries.add(new LineChartEntry( 15 , "schools" , "1970" ));
        entries.add(new LineChartEntry( 30 , "schools" , "1980" ));
        entries.add(new LineChartEntry( 60 , "schools" ,  "1990" ));
        entries.add(new LineChartEntry( 120 , "schools" , "2000" ));
        entries.add(new LineChartEntry( 240 , "schools" , "2010" ));
        entries.add(new LineChartEntry( 300 , "schools" , "2014" ));
        return entries;
    }

    public static void main( String[ ] args ) {
        LineChart chart = new LineChart();
        chart.createChart(createDataset(), new LineChartParams("Numer of Schools vs years", "categories", "values"));
        chart.display();
    }
}
