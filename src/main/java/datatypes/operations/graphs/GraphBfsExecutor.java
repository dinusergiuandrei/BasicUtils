package datatypes.operations.graphs;

import datatypes.operations.visitors.NodeVisitor;
import datatypes.structure.Node;
import datatypes.structure.graphs.Graph;
import datatypes.structure.graphs.GraphNode;

import java.util.ArrayDeque;
import java.util.LinkedHashSet;
import java.util.Queue;
import java.util.Set;

public class GraphBfsExecutor {

    private Queue<GraphNode> queue = new ArrayDeque<>();
    private Set<Node> visitedNodes = new LinkedHashSet<>();

    public void visitNodes(Graph graph, NodeVisitor visitor){
        queue.add(graph.getRandomGraphNode());
        startVisiting(visitor);
    }

    private void startVisiting(NodeVisitor visitor){
        while(!queue.isEmpty()){
            GraphNode currentNode = queue.poll();
            visitor.visitNode(currentNode);
            visitedNodes.add(currentNode);

            Set<GraphNode> possibleNextNodes = currentNode.getOutNodes();
            possibleNextNodes.forEach(
                    nextNode -> {
                        if(!visitedNodes.contains(nextNode)){
                            queue.add(nextNode);
                        }
                    }
            );
        }
    }
}
