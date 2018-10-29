package datatypes.structure.trees;


import datatypes.structure.Node;

import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> extends Node<T> {
    private TreeNode parent;
    protected List<TreeNode<T>> children = new ArrayList<>();

    public TreeNode(T data) {
        super(data);
    }

    public TreeNode(T data, TreeNode<T> parent) {
        super(data);
        this.setParent(parent);
    }

    public void setParent(TreeNode<T> parent) {
        this.parent = parent;
        if (this.parent != null && !this.parent.getChildren().contains(this)) {
            this.parent.addChild(this);
        }
    }

    public void addChild(TreeNode<T> child) {
        this.children.add(child);
    }

    public Boolean isRoot() {
        return parent == null;
    }

    public TreeNode getParent() {
        return parent;
    }

    public List<TreeNode<T>> getChildren() {
        return children;
    }

    public Boolean isLeaf() {
        return this.children.isEmpty();
    }
}
