package datatypes.operations.trees;

import datatypes.operations.trees.visitors.TreeNodeSearcher;
import datatypes.structure.trees.basic.BasicTreeNode;
import datatypes.structure.trees.basic.BasicTree;

import java.util.*;

public class TreeBfsExecutor {

    private Queue<BasicTreeNode> queue = new ArrayDeque<>();

    public void visitNodes(BasicTree tree, TreeNodeSearcher visitor){
        queue.add(tree.getRoot());
        this.startVisiting(visitor);
    }

    private void startVisiting(TreeNodeSearcher visitor) {
        while(!queue.isEmpty() && !visitor.finishedSearch()){  //todo: remove second check
            BasicTreeNode node = queue.poll();
            visitor.visitNode(node);
            queue.addAll(node.getChildren());
        }
    }

}
