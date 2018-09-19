package datatypes.structure.trees.basic;


import java.util.ArrayList;
import java.util.List;

public class BasicTreeNode<T> {
    private T data;
    private BasicTreeNode parent;
    private List<BasicTreeNode> children;

    public BasicTreeNode(T data, BasicTreeNode parent) {
        this.data = data;
        this.parent = parent;
        this.children = new ArrayList<>();
    }

    public void addChild(BasicTreeNode child){
        this.children.add(child);
    }

    public Boolean isRoot(){
        return parent == null;
    }

    public T getData() {
        return data;
    }

    public BasicTreeNode getParent() {
        return parent;
    }

    public List<BasicTreeNode> getChildren() {
        return children;
    }

    public Boolean isLeaf(){
        return this.children.isEmpty();
    }
}
