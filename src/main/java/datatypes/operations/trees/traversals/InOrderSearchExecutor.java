package datatypes.operations.trees.traversals;

import datatypes.operations.visitors.NodeVisitor;
import datatypes.structure.trees.BinaryTree;
import datatypes.structure.trees.BinaryTreeNode;

public class InOrderSearchExecutor {

    public void visitNodes(BinaryTree tree, NodeVisitor visitor) {
        this.startVisiting(tree.getRoot(), visitor);
    }

    private void startVisiting(BinaryTreeNode node, NodeVisitor visitor) {
        BinaryTreeNode leftChild = node.getLeftChild();
        BinaryTreeNode rightChild = node.getRightChild();
        if (leftChild != null)
            startVisiting(leftChild, visitor);
        visitor.visitNode(node);
        if (rightChild != null)
            startVisiting(rightChild, visitor);
    }
}
