package charts.bubble;

import charts.Entry;

import java.util.ArrayList;
import java.util.List;

public class BubbleChartTest {
    public static List<Entry> createEntries( ) {
        List<Entry> entries = new ArrayList<>();

        double radius = 5D;
        String series1 = "series 1";
        String series2 = "series 2";
        entries.add(new BubbleChartEntry(10, 20, radius, series1));
        entries.add(new BubbleChartEntry(10, 40, radius, series1));
        entries.add(new BubbleChartEntry(10, 30, radius, series1));
        entries.add(new BubbleChartEntry(20, 20, radius, series2));
        entries.add(new BubbleChartEntry(25, 20, radius, series2));
        entries.add(new BubbleChartEntry(31, 20, radius, series2));

        return entries;
    }

    public static void main( String args[ ] ) {
        BubbleChart bubbleChart = new BubbleChart();
        bubbleChart.createChart(createEntries(), new BubbleChartParams());
        bubbleChart.display();
    }
}