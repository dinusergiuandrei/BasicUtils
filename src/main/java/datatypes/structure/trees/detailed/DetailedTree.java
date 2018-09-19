package datatypes.structure.trees.detailed;

import datatypes.structure.trees.basic.BasicTree;

public class DetailedTree extends BasicTree {
    public Boolean addNode(DetailedTreeNode newNode) {
        Boolean added = super.addNode(newNode);
        if(added)
            newNode.computePath();
        return added;
    }
}
