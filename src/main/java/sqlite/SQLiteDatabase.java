package sqlite;

import java.sql.*;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SQLiteDatabase implements AutoCloseable {
    private String databaseUrl;

    private Connection connection = null;

    public SQLiteDatabase(String databasePath) {
        this.databaseUrl = "jdbc:sqlite:" + databasePath;
        createConnection();
    }

    public void createNewTable(TableModel tableModel) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ").append(tableModel.getTableName()).append("(");
        for (int i = 0; i < tableModel.getColumns().size(); i++) {
            TableColumn column = tableModel.getColumns().get(i);
            sb.append(column.getColumnName()).append(" ").append(this.getSqlTypeName(column.getColumnType()));
            if (column.getPrimaryKey())
                sb.append(" PRIMARY KEY");
            if (i < tableModel.getColumns().size() - 1)
                sb.append(",");
        }
        sb.append(");");
        String sql = sb.toString();
        executeUpdate(sql);
    }

    public void insert(TableModel tableModel, Entry entry) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ").append(tableModel.getTableName()).append(tableModel.getColumnsAsSql()).append(" VALUES(");
        for (int i = 0; i < entry.getObjects().size(); i++) {
            sb.append("?");
            if (i < entry.getObjects().size() - 1) {
                sb.append(",");
            }
        }
        sb.append(");");
        String sql = sb.toString();
        executeUpdate(sql, entry.getObjects().toArray());
    }


    public Table selectAll(TableModel tableModel) throws SQLException {
        String sql = "SELECT * FROM " + tableModel.getTableName();
        ResultSet rs = executeQuery(sql);
        Table table = new Table(tableModel);
        if (rs != null) {
            while (rs.next()) {
                System.out.println(rs.getString("id") + "\t" +
                        rs.getString("name") + "\t" +
                        rs.getString("year"));
                for (int index = 0; index < tableModel.getColumns().size(); index++) {
                    List<Object> columnNames = tableModel.getColumns().stream().map((Function<TableColumn, Object>) TableColumn::getColumnName).collect(Collectors.toList());
                    List<Object> results = columnNames.stream().map((Function<Object, Object>) o -> {
                        try {
                            return rs.getString(o.toString());
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }).collect(Collectors.toList());
                    table.addEntry(new Entry(results));
                }
            }
        }
        return table;
    }

    public void deleteEntry(Integer id) {
        String sql = "DELETE FROM warehouses WHERE id = ?";
        executeUpdate(sql, id.toString());
    }

    private void executeUpdate(String statement, Object... args) {
        try {
            Connection conn = this.getConnection();
            PreparedStatement ps = conn.prepareStatement(statement);
            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    ps.setString(i + 1, args[i].toString());
                }
            }
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private ResultSet executeQuery(String statement, Object... args) {
        try {
            Connection conn = this.getConnection();
            PreparedStatement ps = conn.prepareStatement(statement);
            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    ps.setString(i + 1, args[i].toString());
                }
            }
            return ps.executeQuery();
        } catch (SQLException e) {
            //System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }


    private Connection getConnection() {
        if (this.connection != null) {
            return this.connection;
        } else {
            this.connection = this.createConnection();
            return this.connection;
        }
    }

    private Connection createConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(this.databaseUrl);
            System.out.println("Connection created.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }


    @Override
    public void close() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getSqlTypeName(Class clazz) {
        if (clazz == Integer.class) {
            return "INT";
        }

        if (clazz == Double.class) {
            return "REAL";
        }

        if (clazz == String.class) {
            return "TEXT";
        }
        return null;
    }

}