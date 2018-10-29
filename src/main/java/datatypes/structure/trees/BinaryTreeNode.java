package datatypes.structure.trees;


import java.util.ArrayList;
import java.util.List;

public class BinaryTreeNode<T> extends TreeNode<T> {
    private BinaryTreeNode<T> leftChild;
    private BinaryTreeNode<T> rightChild;

    public BinaryTreeNode(T data) {
        super(data);
    }

    public BinaryTreeNode(T data, BinaryTreeNode parent) {
        super(data, parent);
    }

    public BinaryTreeNode(T data, BinaryTreeNode parent, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild) {
        super(data, parent);
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public void setLeftChild(BinaryTreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(BinaryTreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    public BinaryTreeNode<T> getLeftChild() {
        return this.leftChild;
    }

    public BinaryTreeNode<T> getRightChild() {
        return this.rightChild;
    }

    @Override
    public void addChild(TreeNode<T> child) {
        try {
            this.addChild((BinaryTreeNode<T>) child);
        } catch (ClassCastException e) {
            System.err.println("Only BinaryTreeNode elements can be added in a BinaryTree.");
        }
    }

    private void addChild(BinaryTreeNode<T> child) {
        if (this.leftChild == null) {
            this.leftChild = child;
            return;
        }
        if (this.rightChild == null) {
            this.rightChild = child;
            return;
        }
        System.err.println("Cannot add more than two children to a BinaryTreeNode.");
    }

    @Override
    public List<TreeNode<T>> getChildren() {
        this.children = new ArrayList<>();
        if (leftChild != null)
            this.children.add(leftChild);
        if (rightChild != null)
            this.children.add(rightChild);
        return this.children;
    }
}
