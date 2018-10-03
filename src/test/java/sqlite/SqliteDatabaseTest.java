package sqlite;

import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

public class SqliteDatabaseTest {
    private TableModel tableModel;
    private SQLiteDatabase database;

    @Before
    public void setUp(){
        database = new SQLiteDatabase("testdata/database/testdb.db");

        tableModel = new TableModel("students");
        tableModel.addColumn(new TableColumn("id", Integer.class, true));
        tableModel.addColumn(new TableColumn("name", String.class, false));
        tableModel.addColumn(new TableColumn("year", Integer.class, false));
    }

    @Test
    public void databaseTest() throws SQLException {

        database.createNewTable(tableModel);

//        database.insert(tableModel, new Entry(6, "Sergiu", "3"));
//        for(Integer i=500;i<600; ++i){
//            database.insert(tableModel, new Entry(i, i.toString(), i%4+1));
//        }
        Table table = database.selectAll(tableModel);
        System.out.println(table);
    }
}
