package datatypes.operations.trees.traversals;

import datatypes.operations.visitors.NodeVisitor;
import datatypes.structure.trees.TreeNode;
import datatypes.structure.trees.Tree;

public class TreeDfsExecutor {

    public void visitNodes(Tree tree, NodeVisitor visitor) {
        this.startVisiting(tree.getRoot(), visitor);
    }

    private void startVisiting(TreeNode node, NodeVisitor visitor) {
        visitor.visitNode(node);
        for (Object child : node.getChildren()) {
            TreeNode childNode = (TreeNode) child;
            startVisiting(childNode, visitor);
        }
    }
}
