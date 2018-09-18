package reports.jasperreports;

import filemanager.FileManager;
import org.junit.Before;
import org.junit.Test;
import reports.BasicColumn;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JasperReportTest {
    private JasperReport report;
    private String title;
    private List<BasicColumn> basicColumns = new ArrayList<>();
    private List<TestElement> collection = new ArrayList<>();
    private String path;

    @Before
    public void setUp(){
        report = new JasperReport();
        title = "TestJasperReport";
        basicColumns.add(new BasicColumn("index", Integer.class));
        basicColumns.add(new BasicColumn("name", String.class));
        basicColumns.add(new BasicColumn("value"));

        collection = new ArrayList<>();
        collection.add(new TestElement(1, "element 1", "this one has no value"));
        collection.add(new TestElement(2, "element b", "b"));
        collection.add(new TestElement(3, "element -97", "error already"));
        collection.add(new TestElement(4, "consistency", "quality jokes everywhere"));

        path = "testdata/reports/jasper/test";

    }

    @Test
    public void executeReportTest() {

        for (JasperReport.REPORT_FORMAT report_format : JasperReport.REPORT_FORMAT.values()) {
            try {
                String newPath = path + report_format.getExtension() + "." + report_format.getExtension();
                report.execute(title, basicColumns, collection, newPath, report_format);
            }
            catch (Exception e){
                System.out.println("Format " + report_format.getExtension() + " failed.");
            }
        }

        //FileManager.openFileWithSystem(path);
    }

    public class TestElement{
        private Integer index;
        private String name;
        private String value;

        public TestElement(Integer index, String name, String value) {
            this.index = index;
            this.name = name;
            this.value = value;
        }

        public Integer getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }

        public String getValue() {
            return value;
        }
    }
}
