package xml.generator;

import datatypes.structure.trees.BasicTree;
import datatypes.structure.trees.BasicTreeNode;
import org.junit.Before;
import org.junit.Test;
import xml.XmlGenerator;
import xml.tree.XmlTreeNodeData;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;


//todo: actually test xml generator
public class XmlGeneratorTest {

    private BasicTree tree;

    private String path;

    private XmlGenerator xmlGenerator;

    @Before
    public void setUp(){
        path = "testdata/xml/xmltest1.xml";
        xmlGenerator = new XmlGenerator();
        tree = new BasicTree();

        XmlTreeNodeData rootData = new XmlTreeNodeData("root");
        XmlTreeNodeData nodeData1 = new XmlTreeNodeData("node1");
        XmlTreeNodeData nodeData2 = new XmlTreeNodeData("node2");
        XmlTreeNodeData nodeData3 = new XmlTreeNodeData("node3");
        XmlTreeNodeData nodeData4 = new XmlTreeNodeData("node4");
        rootData.addAttribute("isRoot", "true");
        nodeData1.addAttribute("abc", 213);
        nodeData2.addAttribute("abc", "3424");
        nodeData3.addAttribute("sadaf", "afce3qdedad");
        nodeData3.addAttribute("noway", ".");

        BasicTreeNode<XmlTreeNodeData> root = new BasicTreeNode<>(rootData, null);
        BasicTreeNode<XmlTreeNodeData> node1 = new BasicTreeNode<>(nodeData1, root);
        BasicTreeNode<XmlTreeNodeData> node2 = new BasicTreeNode<>(nodeData2, node1);
        BasicTreeNode<XmlTreeNodeData> node3 = new BasicTreeNode<>(nodeData3, node1);
        BasicTreeNode<XmlTreeNodeData> node4 = new BasicTreeNode<>(nodeData4, root);

        tree.addRoot(root);
        tree.addNode(node1);
        tree.addNode(node2);
        tree.addNode(node3);
        tree.addNode(node4);
    }

    @Test
    public void writeAsXmlTest() throws IOException, XMLStreamException {
        xmlGenerator.writeAsXml(tree, path);
    }
}
