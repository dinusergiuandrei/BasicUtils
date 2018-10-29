package datatypes;

import datatypes.operations.trees.traversals.*;
import datatypes.operations.visitors.NodeVisitor;
import datatypes.structure.Node;
import datatypes.structure.trees.BinaryTree;
import datatypes.structure.trees.BinaryTreeNode;
import datatypes.structure.trees.TreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TreeTraversalTest {
    private BinaryTree tree;

    private TestVisitor visitor;

    private TreeNode[] nodes;

    @Before
    public void setUp() {
        tree = new BinaryTree();
        nodes = new BinaryTreeNode[5];
        for (int i = 0; i < nodes.length; ++i) {
            nodes[i] = new BinaryTreeNode<Integer>(i);
        }
        nodes[0].setParent(null);
        nodes[1].setParent(nodes[0]);
        nodes[2].setParent(nodes[0]);
        nodes[3].setParent(nodes[1]);
        nodes[4].setParent(nodes[2]);
        tree.setRoot(nodes[0]);
    }

    @Test
    public void bfsTest() {
        TreeBfsExecutor bfsExecutor = new TreeBfsExecutor();
        visitor = new TestVisitor();
        bfsExecutor.visitNodes(tree, visitor);
        Assert.assertEquals(nodes.length, (Object) visitor.getVisited());
    }

    @Test
    public void dfsTest() {
        TreeDfsExecutor dfsExecutor = new TreeDfsExecutor();
        visitor = new TestVisitor();
        dfsExecutor.visitNodes(tree, visitor);
        Assert.assertEquals(nodes.length, (Object) visitor.getVisited());
    }

    @Test
    public void inOrderTest() {
        InOrderTraversalExecutor executor = new InOrderTraversalExecutor();
        visitor = new TestVisitor();
        executor.visitNodes(tree, visitor);
        Assert.assertEquals(nodes.length, (Object) visitor.getVisited());
    }

    @Test
    public void preOrderTest() {
        PreOrderTraversalExecutor executor = new PreOrderTraversalExecutor();
        visitor = new TestVisitor();
        executor.visitNodes(tree, visitor);
        Assert.assertEquals(nodes.length, (Object) visitor.getVisited());
    }

    @Test
    public void postOrderTest() {
        PostOrderTraversalExecutor executor = new PostOrderTraversalExecutor();
        visitor = new TestVisitor();
        executor.visitNodes(tree, visitor);
        Assert.assertEquals(nodes.length, (Object) visitor.getVisited());
    }


    class TestVisitor implements NodeVisitor {
        private Integer visited = 0;

        @Override
        public Object visitNode(Node node) {
            ++visited;
            System.out.println(node.getData().toString());
            return null;
        }

        public Integer getVisited() {
            return visited;
        }
    }

}
