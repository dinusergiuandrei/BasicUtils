package datatypes;

import datatypes.structure.trees.BasicTree;
import datatypes.structure.trees.TreeNode;
import org.junit.Test;

public class BasicTreeTest {

    @Test
    public void treeTest(){
        BasicTree tree = new BasicTree();
        TreeNode<Integer> root = new TreeNode<>(0, null);

        TreeNode<Integer> node1 = new TreeNode<>(1, root);
        TreeNode<Integer> node2 = new TreeNode<>(2, root);
        TreeNode<Integer> node3 = new TreeNode<>(3, node1);
        TreeNode<Integer> node4 = new TreeNode<>(4, root);

        tree.addRoot(root);
        tree.addNode(node1);
        tree.addNode(node2);
        tree.addNode(node3);
        tree.addNode(node4);

        System.out.println("dsad");
    }

}