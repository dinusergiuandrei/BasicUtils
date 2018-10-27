package datatypes.structure.graphs;

import datatypes.operations.graphs.GraphPrinter;
import org.junit.Before;
import org.junit.Test;

public class GraphTest {
    private Graph graph;

    @Before
    public void setUp(){
        graph = new Graph();
        GraphNode[] nodes = new GraphNode[5];
        for(int i=0; i<nodes.length; ++i){
            nodes[i] = new GraphNode<>(i);
        }
        graph.addUndirectedEdge(new GraphEdge(nodes[0], nodes[1]));
        graph.addUndirectedEdge(new GraphEdge(nodes[0], nodes[2]));
        graph.addUndirectedEdge(new GraphEdge(nodes[3], nodes[1]));
        graph.addDirectedEdge(new GraphEdge(nodes[2], nodes[4]));
        graph.addDirectedEdge(new GraphEdge(nodes[4], nodes[3]));
    }

    @Test
    public void GraphTest(){
        GraphPrinter.displayGraph(graph, GraphPrinter.GRAPH_FORMAT.EDGE_LIST);
    }
}
