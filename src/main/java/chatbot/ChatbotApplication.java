package chatbot;

import datatypes.operations.trees.TreePrinter;
import datatypes.structure.trees.BasicTree;
import xml.XmlGenerator;
import xml.XmlParser;

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



        xmlGenerator.writeAsXml(generatedTree, outputPath);

    }

}
