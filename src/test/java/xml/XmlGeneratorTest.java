package xml;

import datatypes.structure.trees.detailed.DetailedTree;
import datatypes.structure.trees.detailed.DetailedTreeNode;
import org.junit.Before;
import org.junit.Test;
import xml.generator.XmlGenerator;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;

public class XmlGeneratorTest {

    private DetailedTree tree;

    private String path;

    private XmlGenerator xmlGenerator;

    @Before
    public void setUp(){
        path = "testdata/xml/xmltest1.xml";
        xmlGenerator = new XmlGenerator();
        tree = new DetailedTree();
        DetailedTreeNode root = new DetailedTreeNode<>("Myroot", "aroot", null);
        DetailedTreeNode node1 = new DetailedTreeNode<>("node1", "data1", root);
        DetailedTreeNode node2 = new DetailedTreeNode<>("node2", "data2", node1);
        DetailedTreeNode node3 = new DetailedTreeNode<>("node3", "data3", node1);
        DetailedTreeNode node4 = new DetailedTreeNode<>("node4", "data4", root);

        root.addAttribute("isRoot", "true");
        node1.addAttribute("abc", 213);
        node1.addAttribute("abc", "3424");
        node3.addAttribute("sadaf", "afce3qdedad");

        tree.addNode(root);
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
