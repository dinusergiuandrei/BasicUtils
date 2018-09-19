package xml.parser;

import datatypes.operations.trees.visitors.TreeNodeVisitor;
import datatypes.structure.trees.basic.BasicTreeNode;
import datatypes.structure.trees.detailed.DetailedTreeNode;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.util.List;

public class XmlTreeNodeVisitor implements TreeNodeVisitor {
    private XMLStreamWriter writer;

    private DetailedTreeNode lastNode;

    public XmlTreeNodeVisitor(XMLStreamWriter writer) {
        this.writer = writer;
        lastNode = null;
    }

    @Override
    public Object visitNode(BasicTreeNode node) {
        try {
            DetailedTreeNode xmlNode = (DetailedTreeNode) node;

            if (node.isRoot()) {
                writer.writeStartElement(xmlNode.getName());

                this.writeAttributes(xmlNode);
                //writer.writeCharacters(xmlNode.getData().toString());
                lastNode = (DetailedTreeNode) node;
                return null;
            }

            List nodePath = xmlNode.getNodePath();
            List lastNodePath = lastNode.getNodePath();

            if (nodePath.size() == lastNodePath.size()) {

                writer.writeEndElement();
                writer.writeStartElement(xmlNode.getName());
                this.writeAttributes(xmlNode);

                lastNode = xmlNode;
                return null;

            }

            if (nodePath.size() > lastNodePath.size()) {
                writer.writeStartElement(xmlNode.getName());
                this.writeAttributes(xmlNode);

                lastNode = xmlNode;
                return null;
            }

            if (nodePath.size() < lastNodePath.size()) {
                for (int i = 0; i < lastNodePath.size() - nodePath.size() + 1; ++i) {
                    writer.writeEndElement();
                }
                writer.writeStartElement(xmlNode.getName());
                this.writeAttributes(xmlNode);

                lastNode = xmlNode;
                return null;
            }

        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void writeAttributes(DetailedTreeNode node) throws XMLStreamException {
        node.getAttributes().forEach(
                (k, v) -> {
                    try {
                        writer.writeAttribute(k.toString(), v.toString());
                    } catch (XMLStreamException e) {
                        e.printStackTrace();
                    }
                }
        );
        writer.writeCharacters(node.getData().toString());
    }

    public void closeXml() {
        try {
            for (int i = 0; i < lastNode.getNodePath().size()+1; i++) {
                writer.writeEndElement();
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
