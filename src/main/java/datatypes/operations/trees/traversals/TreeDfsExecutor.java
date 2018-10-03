package datatypes.operations.trees.traversals;

import datatypes.operations.trees.visitors.NodeVisitor;
import datatypes.structure.trees.BasicTreeNode;
import datatypes.structure.trees.BasicTree;

public class TreeDfsExecutor {

    public void visitNodes(BasicTree tree, NodeVisitor visitor) {
        this.startVisiting(tree.getRoot(), visitor);
    }

    private void startVisiting(BasicTreeNode node, NodeVisitor visitor) {
        visitor.visitNode(node);
        for (Object child : node.getChildren()) {
            BasicTreeNode childNode = (BasicTreeNode) child;
            startVisiting(childNode, visitor);
        }
    }
}
