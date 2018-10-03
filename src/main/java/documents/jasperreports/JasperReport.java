package documents.jasperreports;

import filemanager.FileManager;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.jasper.constant.ImageType;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import documents.BasicColumn;
import documents.jasperreports.basics.BasicFieldBuilder;
import documents.jasperreports.basics.BasicTextColumnBuilder;

import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

public class JasperReport {
    private StyleBuilder boldStyle;
    private StyleBuilder boldCenteredStyle;
    private StyleBuilder columnTitleStyle;

    private <T> JasperReportBuilder build(String title, List<BasicColumn> basicColumns,
                                          Collection<T> collection) {
        if(boldStyle == null)
            boldStyle = stl.style().bold();
        if(boldCenteredStyle == null)
            boldCenteredStyle = stl.style(boldStyle);
        if(columnTitleStyle == null)
            columnTitleStyle = stl.style(boldCenteredStyle)
                .setBorder(stl.pen1Point())
                .setBackgroundColor(Color.LIGHT_GRAY);

        return report()
                .columns(buildColumnBuildersArray(basicColumns))
                .setColumnTitleStyle(columnTitleStyle)
                .highlightDetailEvenRows()
                .title(cmp.text(title).setStyle(boldCenteredStyle))
                .pageFooter(cmp.pageXslashY().setStyle(boldCenteredStyle))
                .setDataSource(new JRBeanCollectionDataSource(collection));
    }

    public <T> void execute(String title, List<BasicColumn> basicColumns,
                            Collection<T> collection, String path, REPORT_FORMAT format){
        try {
            FileOutputStream fos = FileManager.computeOutputStream(path);
            JasperReportBuilder builder = this.build(title, basicColumns, collection);
            switch (format){
                case PDF: builder.toPdf(fos); break;
                //case XLSX: builder.toXls(fos); break;
                case DOCX: builder.toDocx(fos); break;
                case HTML: builder.toHtml(fos); break;
                case PPTX: builder.toPptx(fos); break;
                case PNG: builder.toImage(fos, ImageType.PNG); break;
                case JPG: builder.toImage(fos, ImageType.JPG); break;
                case GIF: builder.toImage(fos, ImageType.GIF); break;
                case ODT: builder.toOdt(fos); break;
                case RTF: builder.toRtf(fos); break;
//                case TEXT: builder.toText(fos); break;
//                case XML: builder.toXml(fos); break;
//                case JRXML: builder.toJrXml(fos); break;
//                case ODS: builder.toOds(fos); break;
//                case CSV: builder.toCsv(fos); break;
            }
            fos.close();
        } catch (DRException | IOException e) {
            e.printStackTrace();
        }

    }

    public enum REPORT_FORMAT{
        PDF("pdf"), // ok
        DOCX("docx"), // ok
        HTML("html"), // ok
        PPTX("pptx"), //ok
        PNG("png"), //ok
        JPG("jpg"), //ok
        GIF("gif"), //ok
        ODT("odt"), //ok
        RTF("rtf"); //ok
//        TEXT("text"), // extra empty line
//        CSV("csv"),  // extra characters and extra empty column
//        XML("xml"), // too much data. unviewable
//        XLSX("xlsx"), // bad format :(
//        JRXML("jrxml"), // no viewers exist
//        ODS("ods"); // blank excel

        private String extension;

        REPORT_FORMAT(String extension) {
            this.extension = extension;
        }

        public String getExtension() {
            return extension;
        }
    }

    private TextColumnBuilder[] buildColumnBuildersArray(List<BasicColumn> basicColumns) {
        List<TextColumnBuilder> columns = new ArrayList<>();
        basicColumns.forEach(
                basicColumn -> columns.add(
                        new BasicTextColumnBuilder(
                                new BasicFieldBuilder(
                                        basicColumn.getTitle(),
                                        basicColumn.getClassType()
                                )
                        )
                )
        );
        return columns.toArray(new TextColumnBuilder[0]);
    }

    public StyleBuilder getBoldStyle() {
        return boldStyle;
    }

    public void setBoldStyle(StyleBuilder boldStyle) {
        this.boldStyle = boldStyle;
    }

    public StyleBuilder getBoldCenteredStyle() {
        return boldCenteredStyle;
    }

    public void setBoldCenteredStyle(StyleBuilder boldCenteredStyle) {
        this.boldCenteredStyle = boldCenteredStyle;
    }

    public StyleBuilder getColumnTitleStyle() {
        return columnTitleStyle;
    }

    public void setColumnTitleStyle(StyleBuilder columnTitleStyle) {
        this.columnTitleStyle = columnTitleStyle;
    }
}
