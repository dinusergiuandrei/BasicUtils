package charts;

import charts.Entry;
import charts.time.TimeSeries;
import charts.time.TimeSeriesEntry;
import charts.time.TimeSeriesParams;
import org.jfree.data.time.Second;

import java.util.ArrayList;
import java.util.List;

public class TimeSeriesDemo {

    private static List<Entry> createSource() {
        List<Entry> entries = new ArrayList<>();
        Second current = new Second();
        double value1 = 100.0;
        double value2 = 100.0;
        String series1 = "Series 1";
        String series2 = "Series 2";

        for (int i = 0; i < 4000; i++) {
            value1 = value1 + Math.random() - 0.5;
            value2 = value2 + Math.random() - 0.5;
            entries.add(new TimeSeriesEntry(current, value1, series1));
            entries.add(new TimeSeriesEntry(current, value2, series2));
            current = (Second) current.next();
        }
        return entries;
    }

    public static void main(final String[] args) {
        TimeSeries chart = new TimeSeries();
        chart.createChart(createSource(), new TimeSeriesParams());
        chart.display();
    }
}
