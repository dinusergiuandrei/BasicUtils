package sqlite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TableModel {
    private String tableName;

    private List<TableColumn> columns = new ArrayList<>();

    public TableModel(String tableName) {
        this.tableName = tableName;
    }

    public void addColumn(TableColumn column){
        this.columns.add(column);
    }

    public String getTableName() {
        return tableName;
    }

    public List<TableColumn> getColumns() {
        return columns;
    }

    public String getColumnsAsSql(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        for (int i = 0; i < this.columns.size(); i++) {
            stringBuilder.append(this.columns.get(i).getColumnName());
            if(i<this.columns.size()-1)
                stringBuilder.append(",");
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

}
