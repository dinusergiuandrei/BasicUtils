package datatypes.structure.graphs;

import datatypes.structure.Pair;

import java.util.*;

public class Graph {
    private Set<GraphNode> nodes = new LinkedHashSet<>();

    private Set<GraphEdge> edges = new LinkedHashSet<>();

    public GraphNode getRandomGraphNode(){
        return nodes.iterator().next();
    }

    public void addNode(GraphNode node) {
        this.nodes.add(node);
    }

    public void removeNode(GraphNode node) {
        edges.forEach(edge -> {
            if(edge.containsNode(node))
                edges.remove(edge);
        });
        this.nodes.remove(node);
    }

    public void addDirectedEdge(GraphEdge edge) {
        nodes.add(edge.getStartNode());
        nodes.add(edge.getEndNode());
        this.edges.add(edge);
        edge.getStartNode().addOutEdgeNode(edge.getEndNode());
        edge.getEndNode().addInEdgeNode(edge.getStartNode());
    }

    public void addUndirectedEdge(GraphEdge edge){
        this.addDirectedEdge(edge);
        this.addDirectedEdge(edge.getComplementaryEdge());
    }

    public Set<GraphNode> getNodes() {
        return nodes;
    }

    public Set<GraphEdge> getEdges() {
        return edges;
    }
}
