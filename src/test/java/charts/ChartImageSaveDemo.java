package charts;

import charts.pie.PieChart;
import charts.pie.PieChartEntry;
import charts.pie.PieChartParams;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChartImageSaveDemo {
    private static List<Entry> createDataset() {
        List<Entry> entries = new ArrayList<>();
        entries.add(new PieChartEntry("Apple", 20d));
        entries.add(new PieChartEntry("Samsung", 20d));
        entries.add(new PieChartEntry("Huawei", 40d));
        entries.add(new PieChartEntry("Other", 10d));
        return entries;
    }

    public static void main(String[] args) throws IOException {
        PieChart chart = new PieChart();
        chart.createChart(createDataset(), new PieChartParams());
        chart.save("testdata/charts/demo.jpeg");
    }
}
