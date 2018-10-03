package documents.apachereports;

import filemanager.FileManager;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class XlsApacheReport {

    public void executeXlsReport(String sheetName, String[][] matrix, String path) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet(sheetName);
        XSSFRow row;
        for (int lineIndex = 0; lineIndex < matrix.length; lineIndex++) {
            row = spreadsheet.createRow(lineIndex);
            for (int columnIndex = 0; columnIndex < matrix[lineIndex].length; columnIndex++) {
                Cell cell = row.createCell(columnIndex);
                cell.setCellValue(matrix[lineIndex][columnIndex]);
            }
        }
        FileOutputStream out = FileManager.computeOutputStream(path);
        workbook.write(out);
        out.close();
    }
}
