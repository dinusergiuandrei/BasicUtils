package datatypes;

import datatypes.structure.trees.Tree;
import datatypes.structure.trees.TreeNode;
import org.junit.Test;

public class TreeTest {

    @Test
    public void treeTest(){
        Tree tree = new Tree();
        TreeNode<Integer> root = new TreeNode<>(0, null);

        TreeNode<Integer> node1 = new TreeNode<>(1, root);
        TreeNode<Integer> node2 = new TreeNode<>(2, root);
        TreeNode<Integer> node3 = new TreeNode<>(3, node1);
        TreeNode<Integer> node4 = new TreeNode<>(4, root);

        tree.setRoot(root);

        System.out.println("dsad");
    }

}
