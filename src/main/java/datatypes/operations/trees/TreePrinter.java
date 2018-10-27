package datatypes.operations.trees;

import datatypes.operations.trees.traversals.TreeDfsExecutor;
import datatypes.operations.visitors.NodeVisitor;
import datatypes.structure.Node;
import datatypes.structure.trees.BasicTree;
import datatypes.structure.trees.BasicTreeNode;

import java.util.Stack;

public class TreePrinter {

    public void displayTree(BasicTree tree){
        TreeDfsExecutor executor = new TreeDfsExecutor();
        TreePrinterVisitor visitor = new TreePrinterVisitor();
        executor.visitNodes(tree, visitor);

        System.out.println(visitor.getBuilder().toString());
    }

    class TreePrinterVisitor implements NodeVisitor {
        private StringBuilder builder = new StringBuilder();
        private Stack<BasicTreeNode> stack = new Stack<>();

        @Override
        public Object visitNode(Node node) {
            BasicTreeNode treeNode = (BasicTreeNode) node;
            if(!stack.empty()) {
                if (treeNode.getParent() == stack.peek()) {
                    stack.push(treeNode);
                } else {
                    while (treeNode.getParent() != stack.peek()) {
                        stack.pop();
                    }
                    stack.push(treeNode);
                }
            } else {
                stack.push(treeNode);
            }

            char sep = '-';
            StringBuilder tabsBuilder = new StringBuilder();
            for (int i = 0; i < 4 * (stack.size()-1); i++) {
                tabsBuilder.append(sep);
            }
            String tabs = tabsBuilder.toString();

            System.out.println(tabs + treeNode.getData().toString());
            return null;
        }

        StringBuilder getBuilder() {
            return builder;
        }
    }
}
