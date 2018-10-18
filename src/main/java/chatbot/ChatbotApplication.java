package chatbot;

import chatbot.Classes.Category;
import datatypes.operations.trees.TreePrinter;
import datatypes.structure.trees.BasicTree;
import datatypes.structure.trees.BasicTreeNode;
import xml.XmlGenerator;
import xml.XmlParser;
import xml.tree.XmlTreeNodeData;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;

public class ChatbotApplication {
    public static void main(String args[]) throws IOException, XMLStreamException {
        String path = "testdata/owl/AI2.owl";
        String outputPath = "testdata/owl/output.xml";

        XmlParser parser = new XmlParser();
        BasicTree tree = parser.parse(path);
        new TreePrinter().displayTree(tree);

        XmlGenerator xmlGenerator = new XmlGenerator();
        BasicTree generatedTree = new BasicTree();

        // generate tree
        BasicTreeNode<XmlTreeNodeData> root
                = new BasicTreeNode<>(new XmlTreeNodeData("aiml"), null);

        generatedTree.addNode(root);
        Category category = new Category("abc", "123");
        category.addToTree(generatedTree, root);

        xmlGenerator.writeAsXml(generatedTree, outputPath);

    }


}
