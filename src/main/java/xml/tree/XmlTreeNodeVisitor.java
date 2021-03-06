package xml.tree;

import datatypes.operations.visitors.NodeVisitor;
import datatypes.structure.Node;
import datatypes.structure.trees.TreeNode;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class XmlTreeNodeVisitor implements NodeVisitor {
    private XMLStreamWriter writer;

    private TreeNode lastNode;

    public XmlTreeNodeVisitor(XMLStreamWriter writer) {
        this.writer = writer;
        lastNode = null;
    }

    @Override
    public Object visitNode(Node node) {
        try {
            TreeNode treeNode = (TreeNode) node;
            XmlTreeNodeData data = (XmlTreeNodeData) treeNode.getData();

            if (treeNode.isRoot()) {
                this.writeNodeData(data);
                lastNode = treeNode;
                return null;
            }

            Integer nodeHeight = data.getHeight();
            Integer lastNodeHeight = ((XmlTreeNodeData) lastNode.getData()).getHeight();

            if (nodeHeight.equals(lastNodeHeight)) {
                writer.writeEndElement();
                this.writeNodeData(data);
                lastNode = treeNode;
                return null;
            }

            if (nodeHeight > lastNodeHeight) {
                this.writeNodeData(data);
                lastNode = treeNode;
                return null;
            }

            if (nodeHeight < lastNodeHeight) {
                for (int i = 0; i < lastNodeHeight - nodeHeight + 1; ++i) {
                    writer.writeEndElement();
                }
                this.writeNodeData(data);
                lastNode = treeNode;
                return null;
            }

        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void writeNodeData(XmlTreeNodeData data) throws XMLStreamException {
        writer.writeStartElement(data.getName());
        data.getAttributes().forEach(
                (k, v) -> {
                    try {
                        writer.writeAttribute(k, v.toString());
                    } catch (XMLStreamException e) {
                        e.printStackTrace();
                    }
                }
        );
        writer.writeCharacters(data.getText());
    }

    public void closeXml() {
        try {
            for (int i = 0; i < ( (XmlTreeNodeData) lastNode.getData()).getHeight() + 1; i++) {
                writer.writeEndElement();
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
