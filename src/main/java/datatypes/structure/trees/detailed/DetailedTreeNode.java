package datatypes.structure.trees.detailed;


import datatypes.structure.trees.basic.BasicTreeNode;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DetailedTreeNode<T> extends BasicTreeNode {
    private String name;

    private List<BasicTreeNode> nodePath;

    private Map<String, Object> attributes;

    public DetailedTreeNode(String name, T data, BasicTreeNode parent) {
        super(data, parent);
        this.name = name;
        nodePath = new ArrayList<>();
        attributes = new LinkedHashMap<>();
    }

    void computePath(){
        BasicTreeNode parent = this.getParent();
        if (parent != null) {
            try {
                DetailedTreeNode detailedParent = (DetailedTreeNode) parent;
                for (Object pathElement : detailedParent.getNodePath()) {
                    BasicTreeNode pathNode = (BasicTreeNode) pathElement;
                    nodePath.add(pathNode);
                }
                nodePath.add(detailedParent);
            } catch (ClassCastException e) {
                BasicTreeNode currentNode = parent;
                while (!currentNode.isRoot()) {
                    nodePath.add(currentNode);
                    currentNode = currentNode.getParent();
                }
                nodePath.add(currentNode);
            }
        }

    }

    public String getName() {
        return name;
    }

    public List<BasicTreeNode> getNodePath() {
        return nodePath;
    }

    public void addAttribute(String attribute, Object value){
        this.attributes.put(attribute, value);
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }
}
