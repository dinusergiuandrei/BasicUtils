package datatypes.structure.trees;

import datatypes.operations.trees.traversals.TreeBfsExecutor;
import datatypes.operations.visitors.NodeSearcher;

public class BasicTree {
    private TreeNode root;

    public BasicTree() {
    }

    public void addRoot(TreeNode root) {
        this.root = root;
    }

    public Boolean addNode(TreeNode newNode) {
        if (this.root == null && newNode != null && newNode.getParent() == null) {
            this.root = newNode;
            return true;
        }

        if (newNode != null && this.containsNode(newNode.getParent()) && !this.containsNode(newNode)) {
            newNode.getParent().addChild(newNode);
            return true;
        }
        return false;
    }

    public TreeNode getRoot() {
        return root;
    }

    public Boolean containsNode(TreeNode node) {
        TreeBfsExecutor searchExecutor = new TreeBfsExecutor();
        NodeSearcher visitor = new NodeSearcher(node);
        searchExecutor.visitNodes(this, visitor);
        return visitor.isFound();
    }

}
