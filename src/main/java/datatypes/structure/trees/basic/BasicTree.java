package datatypes.structure.trees.basic;

import datatypes.operations.trees.TreeBfsExecutor;
import datatypes.operations.trees.visitors.TreeNodeSearcher;

public class BasicTree<T> {
    private BasicTreeNode root;

    public BasicTree() {
    }

    public BasicTree(T rootData) {
        this.root = new BasicTreeNode<>(rootData, null);
    }

    public Boolean addNode(BasicTreeNode newNode) {
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

    public BasicTreeNode getRoot() {
        return root;
    }

    public Boolean containsNode(BasicTreeNode node) {
        TreeBfsExecutor searchExecutor = new TreeBfsExecutor();
        TreeNodeSearcher visitor = new TreeNodeSearcher(node);
        searchExecutor.visitNodes(this, visitor);
        return visitor.getFound();
    }

    public Boolean isAncestor(BasicTreeNode child, BasicTreeNode ancestor) {
        if (ancestor.isRoot())
            return true;
        BasicTreeNode currentNode = child;
        while (!currentNode.isRoot()) {
            if (currentNode == ancestor)
                return true;
            currentNode = currentNode.getParent();
        }
        return false;
    }
}
