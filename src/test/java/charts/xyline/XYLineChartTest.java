package charts.xyline;

import charts.Entry;

import java.util.ArrayList;
import java.util.List;

public class XYLineChartTest {

    private static List<Entry> createDataset() {
        List<Entry> entries = new ArrayList<>();

        String series1 = "FireFox Series";
        String series2 = "Chrome Series";
        String series3 = "Explorer Series";

        entries.add(new XYLineChartEntry(1, 1, series1));
        entries.add(new XYLineChartEntry(2, 4, series1));
        entries.add(new XYLineChartEntry(3, 3, series1));

        entries.add(new XYLineChartEntry(1, 4, series2));
        entries.add(new XYLineChartEntry(2, 5, series2));
        entries.add(new XYLineChartEntry(3, 6, series2));

        entries.add(new XYLineChartEntry(3, 4, series3));
        entries.add(new XYLineChartEntry(4, 5, series3));
        entries.add(new XYLineChartEntry(5, 4, series3));

        return entries;
    }

    public static void main(String[] args) {
        XYLineChart chart = new XYLineChart();
        chart.createChart(createDataset(), new XYLineChartParams());
        chart.display();
    }
}