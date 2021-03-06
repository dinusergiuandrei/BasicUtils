package datatypes.operations.trees.traversals;

import datatypes.operations.visitors.NodeVisitor;
import datatypes.structure.trees.BinaryTree;
import datatypes.structure.trees.BinaryTreeNode;

public class PreOrderTraversalExecutor {
    public void visitNodes(BinaryTree tree, NodeVisitor visitor) {
        this.startVisiting(tree.getRoot(), visitor);
    }

    private void startVisiting(BinaryTreeNode node, NodeVisitor visitor) {
        BinaryTreeNode leftChild = node.getLeftChild();
        BinaryTreeNode rightChild = node.getRightChild();
        visitor.visitNode(node);
        if (leftChild != null)
            startVisiting(leftChild, visitor);
        if (rightChild != null)
            startVisiting(rightChild, visitor);
    }
}
