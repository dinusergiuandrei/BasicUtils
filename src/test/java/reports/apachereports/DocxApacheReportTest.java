package reports.apachereports;

import filemanager.FileManager;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class DocxApacheReportTest {

    String path;

    @Before
    public void setUp() {
        path = "testdata/reports/apache/docxapachereport.docx";
    }

    @Test
    public void executeDocxReportTest() throws IOException {
        String[][] matrix = {{"1", "a", "b"}, {"2", "h", "e"}, {"8", "sdaf", "fdsvsfv"}};
        DocxApacheReport report = new DocxApacheReport();
        report.executeDocxReport(matrix, path);
        FileManager.openFileWithSystem(path);
    }
}
