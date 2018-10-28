package datatypes;

import datatypes.operations.graphs.GraphBfsExecutor;
import datatypes.operations.graphs.GraphDfsExecutor;
import datatypes.operations.visitors.NodeVisitor;
import datatypes.structure.Node;
import datatypes.structure.graphs.Graph;
import datatypes.structure.graphs.GraphEdge;
import datatypes.structure.graphs.GraphNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GraphTraversalTest {
    private Graph graph;
    private TestVisitor visitor;

    @Before
    public void setUp(){
        graph = new Graph();
        GraphNode[] nodes = new GraphNode[5];
        for(int i=0; i<nodes.length; ++i){
            nodes[i] = new GraphNode<>(i);
        }
        graph.addUndirectedEdge(new GraphEdge(nodes[0], nodes[1]));
        graph.addUndirectedEdge(new GraphEdge(nodes[1], nodes[2]));
        graph.addUndirectedEdge(new GraphEdge(nodes[3], nodes[1]));
        graph.addDirectedEdge(new GraphEdge(nodes[2], nodes[4]));
        graph.addDirectedEdge(new GraphEdge(nodes[4], nodes[3]));
    }

    @Test
    public void bfsTest(){
        GraphBfsExecutor bfsExecutor = new GraphBfsExecutor();
        visitor = new TestVisitor();
        bfsExecutor.visitNodes(graph, visitor);
        Assert.assertEquals(graph.getNodes().size(),(Object) visitor.getVisited());
    }

    @Test
    public void dfsTest(){
        GraphDfsExecutor dfsExecutor = new GraphDfsExecutor();
        visitor = new TestVisitor();
        dfsExecutor.visitNodes(graph, visitor);
        Assert.assertEquals(graph.getNodes().size(),(Object) visitor.getVisited());
    }

    class TestVisitor implements NodeVisitor{
        private Integer visited = 0;

        @Override
        public Object visitNode(Node node) {
            ++visited;
            return null;
        }

        public Integer getVisited() {
            return visited;
        }
    }
}
