package xml.parser;

import datatypes.operations.trees.TreePrinter;
import datatypes.structure.trees.BasicTree;
import org.junit.Test;
import xml.XmlParser;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;

//todo: actually test xml parser
public class XmlParserTest {
    @Test
    public void parse() throws IOException, XMLStreamException {
        String path = "testdata/xml/xmltest1.xml";
        XmlParser parser = new XmlParser();
        BasicTree tree = parser.parse(path);
        new TreePrinter().displayTree(tree);
    }
}
