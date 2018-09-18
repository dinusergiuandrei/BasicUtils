package reports.apachereports;

import filemanager.FileManager;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class XlsxApacheReportTest {

    String path;

    @Before
    public void setUp() {
        path = "testdata/reports/apache/xlsapachereport.xlsx";
    }

    @Test
    public void executeXlsReportTest() throws IOException {
        String[][] matrix = {{"1", "a", "b"}, {"2", "h", "e"}, {"8", "sdaf", "fdsvsfv"}};
        XlsApacheReport report = new XlsApacheReport();
        report.executeXlsReport("sheet1", matrix, path);
        FileManager.openFileWithSystem(path);
    }
}
