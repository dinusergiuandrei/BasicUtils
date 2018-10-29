package datatypes.operations.trees.traversals;

import datatypes.operations.visitors.NodeVisitor;
import datatypes.structure.trees.TreeNode;
import datatypes.structure.trees.Tree;

import java.util.*;

public class TreeBfsExecutor {

    private Queue<TreeNode> queue = new ArrayDeque<>();

    public void visitNodes(Tree tree, NodeVisitor visitor){
        queue.add(tree.getRoot());
        this.startVisiting(visitor);
    }

    private void startVisiting(NodeVisitor visitor) {
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            visitor.visitNode(node);
            queue.addAll(node.getChildren());
        }
    }

}
