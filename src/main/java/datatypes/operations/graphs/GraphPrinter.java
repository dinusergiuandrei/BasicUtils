package datatypes.operations.graphs;

import datatypes.operations.Sets;
import datatypes.structure.graphs.Graph;

public class GraphPrinter {
    public static void displayGraph(Graph graph, GRAPH_FORMAT format) {
        switch (format) {
            case ADJACENCY_LISTS:
                displayAsAdjacencyLists(graph);
                break;
            case EDGE_LIST:
                displayAsEdgeList(graph);
                break;
            case MATRIX:
                displayAsMatrix(graph);
                break;
            default:
                displayAsAdjacencyLists(graph);
        }
    }

    private static void displayAsAdjacencyLists(Graph graph) {
        graph.getNodes().forEach(
                graphNode ->
                        System.out.println(graphNode + " : " +
                                Sets.toString(graphNode.getOutNodes(), "; ", "{", "}"))
        );
    }

    private static void displayAsEdgeList(Graph graph) {
        graph.getEdges().forEach(
                edge -> System.out.println("( " + edge.getStartNode() + " -> " + edge.getEndNode() + " )")
        );
    }

    private static void displayAsMatrix(Graph graph) {
        System.out.println("Printing graph as matrix not yet implemented.");
    }

    public enum GRAPH_FORMAT {
        ADJACENCY_LISTS,
        EDGE_LIST,
        MATRIX
    }
}
