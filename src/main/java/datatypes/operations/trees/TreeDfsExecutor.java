package datatypes.operations.trees;

import datatypes.operations.trees.visitors.TreeNodeVisitor;
import datatypes.structure.trees.basic.BasicTreeNode;
import datatypes.structure.trees.basic.BasicTree;

public class TreeDfsExecutor {

    public void visitNodes(BasicTree tree, TreeNodeVisitor visitor) {
        this.startVisiting(tree.getRoot(), visitor);
    }

    private void startVisiting(BasicTreeNode node, TreeNodeVisitor visitor) {
        visitor.visitNode(node);
        for (Object child : node.getChildren()) {
            BasicTreeNode childNode = (BasicTreeNode) child;
            startVisiting(childNode, visitor);
        }
    }
}
