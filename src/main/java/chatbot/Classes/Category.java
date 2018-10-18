package chatbot.Classes;

import datatypes.structure.trees.BasicTree;
import datatypes.structure.trees.BasicTreeNode;
import xml.tree.XmlTreeNodeData;

public class Category {
    private String pattern;
    private String template;

    public Category(String pattern, String template) {
        this.pattern = pattern;
        this.template = template;
    }

    public String getPattern() {
        return pattern;
    }

    public String getTemplate() {
        return template;
    }

    public void addToTree(BasicTree tree, BasicTreeNode parent){
        XmlTreeNodeData categoryData = new XmlTreeNodeData("category");

        XmlTreeNodeData patternData = new XmlTreeNodeData("pattern");
        patternData.setText(this.pattern);
        XmlTreeNodeData templateData = new XmlTreeNodeData("template");
        templateData.setText(this.getTemplate());

        BasicTreeNode<XmlTreeNodeData> categoryNode = new BasicTreeNode<>(categoryData, parent);
        BasicTreeNode<XmlTreeNodeData> patternNode = new BasicTreeNode<>(patternData, categoryNode);
        BasicTreeNode<XmlTreeNodeData> templateNode = new BasicTreeNode<>(templateData, categoryNode);

        tree.addNode(categoryNode);
        tree.addNode(patternNode);
        tree.addNode(templateNode);

    }
}
