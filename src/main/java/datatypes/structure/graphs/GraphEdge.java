package datatypes.structure.graphs;

public class GraphEdge {
    private GraphNode startNode;
    private GraphNode endNode;

    public GraphEdge(GraphNode startNode, GraphNode endNode) {
        this.startNode = startNode;
        this.endNode = endNode;
    }

    public GraphNode getStartNode() {
        return startNode;
    }

    public GraphNode getEndNode() {
        return endNode;
    }

    public Boolean containsNode(GraphNode node) {
        return startNode == node || endNode == node;
    }

    public GraphEdge getComplementaryEdge() {
        return new GraphEdge(endNode, startNode);
    }
}
