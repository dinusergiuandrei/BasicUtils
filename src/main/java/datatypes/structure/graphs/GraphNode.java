package datatypes.structure.graphs;

import datatypes.structure.Node;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class GraphNode<T> extends Node<T> {
    private Set<GraphNode> outNodes = new LinkedHashSet<>();
    private Set<GraphNode> inNodes = new LinkedHashSet<>();

    public GraphNode(T data) {
        super(data);
    }

    public void addOutEdgeNode(GraphNode node){
        this.outNodes.add(node);
    }

    public void addInEdgeNode(GraphNode node){
        this.inNodes.add(node);
    }

    public Set<GraphNode> getOutNodes() {
        return outNodes;
    }

    public Set<GraphNode> getInNodes() {
        return inNodes;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
