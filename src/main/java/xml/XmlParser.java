package xml;


import datatypes.structure.trees.Tree;
import datatypes.structure.trees.TreeNode;
import xml.tree.XmlTreeNodeData;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Stack;

//https://stackoverflow.com/questions/5059224/which-is-the-best-library-for-xml-parsing-in-java

public class XmlParser {
    public Tree parse(String path) throws XMLStreamException, IOException {
        FileInputStream fis = new FileInputStream(path);
        XMLInputFactory xmlInFact = XMLInputFactory.newInstance();
        XMLStreamReader reader = xmlInFact.createXMLStreamReader(fis);

        Tree tree = new Tree();

        Stack<TreeNode> nodeStack = new Stack<>();

        while (reader.hasNext()) {
            reader.next();
            if (reader.getEventType() == XMLStreamConstants.START_ELEMENT) {
                XmlTreeNodeData data = new XmlTreeNodeData(reader.getName().toString());
                for (int i = 0; i < reader.getAttributeCount(); ++i) {
                    data.addAttribute(reader.getAttributeName(i).toString(), reader.getAttributeValue(i));
                }
//                data.setText(reader.getText());

                TreeNode lastNode;
                if(nodeStack.empty())
                    lastNode = null;
                else lastNode = nodeStack.peek();

                TreeNode<XmlTreeNodeData> node = new TreeNode<>(data, lastNode);

                nodeStack.push(node);
            }
            if( reader.getEventType() == XMLStreamConstants.END_ELEMENT ){
                nodeStack.pop();
            }
        }
        return tree;
    }
}
