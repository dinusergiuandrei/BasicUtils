package datatypes.structure.trees;


import datatypes.structure.Node;

import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> extends Node<T> {
    private TreeNode parent;
    private List<TreeNode> children;

    public TreeNode(T data, TreeNode parent) {
        super(data);
        this.parent = parent;
        this.children = new ArrayList<>();
    }

    public void addChild(TreeNode child){
        this.children.add(child);
    }

    public Boolean isRoot(){
        return parent == null;
    }

    public TreeNode getParent() {
        return parent;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public Boolean isLeaf(){
        return this.children.isEmpty();
    }

    public Boolean isAncestor(TreeNode ancestor) {
        if (ancestor.isRoot())
            return true;
        TreeNode currentNode = this;
        while (!currentNode.isRoot()) {
            if (currentNode == ancestor)
                return true;
            currentNode = currentNode.getParent();
        }
        return false;
    }
}
