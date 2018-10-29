package datatypes.structure.trees;

import java.util.ArrayList;

public class BinaryTreeNode<T> extends TreeNode<T> {

    public BinaryTreeNode(T data, BinaryTreeNode parent) {
        super(data, parent);
        this.children = new ArrayList<>(2);
    }

    public BinaryTreeNode(T data, BinaryTreeNode parent, BinaryTreeNode leftChild, BinaryTreeNode rightChild) {
        super(data, parent);
        this.children.set(0, leftChild);
        this.children.set(1, rightChild);
    }

    public void setLeftChild(BinaryTreeNode leftChild) {
        this.children.add(0, leftChild);
    }

    public void setRightChild(BinaryTreeNode rightChild) {
        this.children.add(1, rightChild);
    }

    public BinaryTreeNode getLeftChild() {
        return (BinaryTreeNode) this.children.get(0);
    }

    public BinaryTreeNode getRightChild() {
        return (BinaryTreeNode) this.children.get(1);
    }
}
