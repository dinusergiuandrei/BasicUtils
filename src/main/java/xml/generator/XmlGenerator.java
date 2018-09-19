package xml.generator;

import datatypes.operations.trees.TreeDfsExecutor;
import datatypes.structure.trees.basic.BasicTree;
import datatypes.structure.trees.detailed.DetailedTree;
import filemanager.FileManager;
import xml.parser.XmlTreeNodeVisitor;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileOutputStream;
import java.io.IOException;

public class XmlGenerator {
    public void writeAsXml(DetailedTree tree, String path) throws XMLStreamException, IOException {
        try (FileOutputStream fos = FileManager.computeOutputStream(path)) {
            XMLOutputFactory xmlOutFact = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = xmlOutFact.createXMLStreamWriter(fos);

            XmlTreeNodeVisitor visitor = new XmlTreeNodeVisitor(writer);
            TreeDfsExecutor dfsExecutor = new TreeDfsExecutor();

            writer.writeStartDocument();
            dfsExecutor.visitNodes(tree, visitor);
            visitor.closeXml();
            writer.writeEndDocument();
            writer.close();
        }
    }
}
