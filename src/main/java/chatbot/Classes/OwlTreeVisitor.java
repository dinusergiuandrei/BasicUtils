package chatbot.Classes;


import datatypes.operations.trees.visitors.NodeVisitor;
import datatypes.structure.trees.BasicTreeNode;
import xml.tree.XmlTreeNodeData;

import java.util.List;
import java.util.Map;

public class OwlTreeVisitor implements NodeVisitor {
    private List<String> objectProperties;
    private List<String> classes;
    private List<String> individuals;

    @Override
    public Object visitNode(BasicTreeNode node) {
        String data = node.getData().toString();
        data = data.substring(data.indexOf("}")+1);

        if(data.equals("NamedIndividual")){
            XmlTreeNodeData xmlTreeNodeData = (XmlTreeNodeData) node.getData();
            Map<String, Object> map = xmlTreeNodeData.getAttributes();
            //map.forEach((k, v) -> System.out.println(map.get(k)));
        }

        if(data.equals("ObjectProperty")){
            List<BasicTreeNode> children = node.getChildren();
            BasicTreeNode child1 = children.get(0);
            BasicTreeNode child2 = children.get(1);

            XmlTreeNodeData data1 = (XmlTreeNodeData) child1.getData();
            XmlTreeNodeData data2 = (XmlTreeNodeData) child2.getData();

            XmlTreeNodeData rootData = (XmlTreeNodeData) node.getData();
            Map<String, Object> mapr = rootData.getAttributes();
            mapr.forEach(
                    (k, v) -> {
                        String[] strings = v.toString().split("[#//]");
                        System.out.print("rule = " + strings[strings.length-1] + "; ");
                    }
            );

            Map<String, Object> map1 = data1.getAttributes();
            map1.forEach((k, v) -> {
                String[] strings = v.toString().split("[#//]");
                System.out.print("domain = " + strings[strings.length-1] + "; ");
            });

            Map<String, Object> map2 = data2.getAttributes();
            map2.forEach((k, v) -> {
                String[] strings = v.toString().split("[#//]");
                System.out.println("range = " + strings[strings.length-1] + "; ");
            });

        }
        return null;
    }
}