package charts;

import charts.Entry;
import charts.line.LineChart;
import charts.line.LineChartEntry;
import charts.line.LineChartParams;

import java.util.ArrayList;
import java.util.List;


public class LineChartDemo {

    private static List<Entry> createDataSet( ) {
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
        simpleParams();
        complexParams();
    }

    private static void simpleParams(){
        LineChart chart = new LineChart();
        chart.createChart(createDataSet(), new LineChartParams());
        chart.display();
    }

    private static void complexParams(){
        LineChart chart = new LineChart();
        chart.createChart(createDataSet(), new LineChartParams("line chart", "schools", "years"));
        chart.display();
    }
}
