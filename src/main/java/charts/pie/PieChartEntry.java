package charts.pie;

import charts.Entry;

public class PieChartEntry implements Entry {
    private Comparable key;

    private Number value;

    public PieChartEntry(Comparable key, Number value) {
        this.key = key;
        this.value = value;
    }

    public Comparable getKey() {
        return key;
    }

    public Number getValue() {
        return value;
    }
}
