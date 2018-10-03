package documents.apachereports;

import filemanager.FileManager;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class DocXApacheReportTest {

    String path;

    @Before
    public void setUp() {
        path = "testdata/documents/apache/docxapachereport.docx";
    }

    @Test
    public void executeDocxReportTest() throws IOException {
        String[][] matrix = {{"1", "a", "b"}, {"2", "h", "e"}, {"8", "sdaf", "fdsvsfv"}};
        DocXApacheReport report = new DocXApacheReport();
        report.executeDocXReport(matrix, path);
        FileManager.openFileWithSystem(path);
    }
}
