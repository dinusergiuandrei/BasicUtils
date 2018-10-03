package datatypes.operations.trees.visitors;

import datatypes.structure.trees.BasicTreeNode;

public class NodeSearcher implements NodeVisitor {
    private Boolean found;

    private BasicTreeNode target;

    public NodeSearcher(BasicTreeNode target) {
        this.target = target;
        found = false;
    }

    @Override
    public Object visitNode(BasicTreeNode node) {
        if(node == target){
            found = true;
        }
        return null;
    }

    public Boolean finishedSearch() {
        return found;
    }

    public Boolean getFound() {
        return found;
    }
}
