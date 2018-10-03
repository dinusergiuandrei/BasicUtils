package datatypes.operations.trees.traversals;

import datatypes.operations.trees.visitors.NodeSearcher;
import datatypes.structure.trees.BasicTreeNode;
import datatypes.structure.trees.BasicTree;

import java.util.*;

public class TreeBfsExecutor {

    private Queue<BasicTreeNode> queue = new ArrayDeque<>();

    public void visitNodes(BasicTree tree, NodeSearcher visitor){
        queue.add(tree.getRoot());
        this.startVisiting(visitor);
    }

    private void startVisiting(NodeSearcher visitor) {
        while(!queue.isEmpty() && !visitor.finishedSearch()){  //todo: remove second check
            BasicTreeNode node = queue.poll();
            visitor.visitNode(node);
            queue.addAll(node.getChildren());
        }
    }

}
