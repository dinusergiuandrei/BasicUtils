package datatypes.operations.visitors;

import datatypes.structure.Node;

public class NodeSearcher implements NodeVisitor {
    private Boolean found;

    private Node target;

    public NodeSearcher(Node target) {
        this.target = target;
        found = false;
    }

    @Override
    public Object visitNode(Node node) {
        if(node == target){
            found = true;
        }
        return null;
    }

    public Boolean finishedSearch() {
        return found;
    }

    public Boolean isFound() {
        return found;
    }
}
