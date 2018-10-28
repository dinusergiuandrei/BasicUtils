package datatypes;

import datatypes.structure.trees.BasicTree;
import datatypes.structure.trees.BasicTreeNode;
import org.junit.Test;

public class BasicTreeTest {

    @Test
    public void treeTest(){
        BasicTree tree = new BasicTree();
        BasicTreeNode<Integer> root = new BasicTreeNode<>(0, null);

        BasicTreeNode<Integer> node1 = new BasicTreeNode<>(1, root);
        BasicTreeNode<Integer> node2 = new BasicTreeNode<>(2, root);
        BasicTreeNode<Integer> node3 = new BasicTreeNode<>(3, node1);
        BasicTreeNode<Integer> node4 = new BasicTreeNode<>(4, root);

        tree.addRoot(root);
        tree.addNode(node1);
        tree.addNode(node2);
        tree.addNode(node3);
        tree.addNode(node4);

        System.out.println("dsad");
    }

}
