package xml.generator;

import datatypes.operations.trees.traversals.TreeDfsExecutor;
import datatypes.structure.trees.BasicTree;
import filemanager.FileManager;
import xml.tree.XmlTreeNodeData;
import xml.tree.XmlTreeNodeVisitor;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileOutputStream;
import java.io.IOException;

public class XmlGenerator {
    public void writeAsXml(BasicTree tree, String outputPath) throws XMLStreamException, IOException {

        if (!isValidXmlTree(tree)) {
            System.out.println("Given tree is not a valid XML tree.");
            return;
        }
        updateHeights(tree);

        try (FileOutputStream fos = FileManager.computeOutputStream(outputPath)) {
            XMLOutputFactory xmlOutFact = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = xmlOutFact.createXMLStreamWriter(fos);

            TreeDfsExecutor dfsExecutor = new TreeDfsExecutor();
            XmlTreeNodeVisitor visitor = new XmlTreeNodeVisitor(writer);

            writer.writeStartDocument();
            dfsExecutor.visitNodes(tree, visitor);
            visitor.closeXml();
            writer.writeEndDocument();
            writer.close();
        }
    }

    private void updateHeights(BasicTree tree) {
        TreeDfsExecutor dfsExecutor = new TreeDfsExecutor();
        dfsExecutor.visitNodes(tree, node -> {
            XmlTreeNodeData data = (XmlTreeNodeData) node.getData();
            if (node.isRoot())
                data.setHeight(0);
            else {
                XmlTreeNodeData parentData = (XmlTreeNodeData) node.getParent().getData();
                data.setHeight(parentData.getHeight() + 1);
            }
            return null;
        });
    }

    private Boolean isValidXmlTree(BasicTree tree) {
        TreeDfsExecutor dfsExecutor = new TreeDfsExecutor();
        dfsExecutor.visitNodes(tree, node -> {
                    try {
                        XmlTreeNodeData data = (XmlTreeNodeData) node.getData();
                    } catch (ClassCastException e) {
                        return false;
                    }
                    return null;
                }
        );
        return true;
    }
}
