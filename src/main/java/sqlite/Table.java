package sqlite;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private TableModel tableModel;

    private List<Entry> entries;

    public Table(TableModel tableModel) {
        this.tableModel = tableModel;
        entries = new ArrayList<>();
    }

    public void addEntry(Entry newEntry){
        this.entries.add(newEntry);
    }

    public TableModel getTableModel() {
        return tableModel;
    }
}
