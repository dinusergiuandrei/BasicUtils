package sqlite;

import java.util.List;

public class TableColumn {

    private String columnName;

    private Class columnType;

    private Boolean isPrimaryKey;

    public TableColumn(String columnName, Class columnType, Boolean isPrimaryKey) {
        this.columnName = columnName;
        this.columnType = columnType;
        this.isPrimaryKey = isPrimaryKey;
    }

    public String getColumnName() {
        return columnName;
    }

    public Class getColumnType() {
        return columnType;
    }

    public Boolean getPrimaryKey() {
        return isPrimaryKey;
    }
}
