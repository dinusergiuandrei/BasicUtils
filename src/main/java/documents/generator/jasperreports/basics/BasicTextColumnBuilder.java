package documents.generator.jasperreports.basics;

import net.sf.dynamicreports.report.base.column.DRValueColumn;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import org.apache.poi.ss.formula.functions.T;

public class BasicTextColumnBuilder extends TextColumnBuilder<T> {
    public BasicTextColumnBuilder(FieldBuilder field) {
        super(field);
    }

    public DRValueColumn<T> build(){
        return super.build();
    }
}
