package datatypes.operations.trees.traversals;

import datatypes.operations.visitors.NodeVisitor;
import datatypes.structure.trees.BasicTreeNode;
import datatypes.structure.trees.BasicTree;

import java.util.*;

public class TreeBfsExecutor {

    private Queue<BasicTreeNode> queue = new ArrayDeque<>();

    public void visitNodes(BasicTree tree, NodeVisitor visitor){
        queue.add(tree.getRoot());
        this.startVisiting(visitor);
    }

    private void startVisiting(NodeVisitor visitor) {
        while(!queue.isEmpty()){
            BasicTreeNode node = queue.poll();
            visitor.visitNode(node);
            queue.addAll(node.getChildren());
        }
    }

}
