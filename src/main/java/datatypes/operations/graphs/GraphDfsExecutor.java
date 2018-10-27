package datatypes.operations.graphs;

import datatypes.operations.visitors.NodeVisitor;
import datatypes.structure.Node;
import datatypes.structure.graphs.Graph;
import datatypes.structure.graphs.GraphNode;

import java.util.LinkedHashSet;
import java.util.Set;

public class GraphDfsExecutor {
    private Set<Node> visitedNodes = new LinkedHashSet<>();

    public void visitNodes(Graph graph, NodeVisitor visitor){
        this.startVisiting(graph.getRandomGraphNode(), visitor);
    }

    private void startVisiting(GraphNode node, NodeVisitor visitor){
        visitor.visitNode(node);
        visitedNodes.add(node);
        for (Object object : node.getOutNodes()){
            GraphNode nextNode = (GraphNode) object;
            if(!visitedNodes.contains(nextNode))
                startVisiting(nextNode, visitor);
        }
    }
}
