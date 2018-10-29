package xml.generator;

import datatypes.structure.trees.BasicTree;
import datatypes.structure.trees.TreeNode;
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

        TreeNode<XmlTreeNodeData> root = new TreeNode<>(rootData, null);
        TreeNode<XmlTreeNodeData> node1 = new TreeNode<>(nodeData1, root);
        TreeNode<XmlTreeNodeData> node2 = new TreeNode<>(nodeData2, node1);
        TreeNode<XmlTreeNodeData> node3 = new TreeNode<>(nodeData3, node1);
        TreeNode<XmlTreeNodeData> node4 = new TreeNode<>(nodeData4, root);

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
