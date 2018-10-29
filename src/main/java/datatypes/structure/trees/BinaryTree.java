package datatypes.structure.trees;

public class BinaryTree extends Tree {
    private BinaryTreeNode root;

    public BinaryTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }

    @Override
    public void setRoot(TreeNode root) {
        try {
            this.setRoot((BinaryTreeNode) root);
        }
        catch (ClassCastException e) {
            System.out.println("The root of a BinaryTree has to a BinaryTreeNode");
        }
        super.setRoot(root);
    }


}
