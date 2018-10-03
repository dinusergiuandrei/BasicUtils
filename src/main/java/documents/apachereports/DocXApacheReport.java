package documents.apachereports;

import filemanager.FileManager;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import java.io.FileOutputStream;
import java.io.IOException;

public class DocXApacheReport {
    public void executeDocXReport(String[][] matrix, String path) throws IOException {
        XWPFDocument document = new XWPFDocument();
        FileOutputStream out = FileManager.computeOutputStream(path);
        XWPFTable table = document.createTable();

        String[] firstLine = matrix[0];

        XWPFTableRow tableRowOne = table.getRow(0);
        tableRowOne.getCell(0).setText(firstLine[0]);
        for (int i = 1; i < matrix[0].length; i++) {
            tableRowOne.addNewTableCell().setText(firstLine[i]);
        }

        for (int lineIndex = 1; lineIndex < matrix.length; lineIndex++) {
            String[] line = matrix[lineIndex];
            XWPFTableRow newTableRow = table.createRow();
            for (int columnIndex = 0; columnIndex < line.length; columnIndex++) {
                newTableRow.getCell(columnIndex).setText(line[columnIndex]);
            }
        }

        document.write(out);
        out.close();
    }

}
