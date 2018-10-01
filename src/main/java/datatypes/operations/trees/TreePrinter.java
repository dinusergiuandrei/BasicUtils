package datatypes.operations.trees;

import datatypes.operations.trees.traversals.TreeDfsExecutor;
import datatypes.operations.trees.visitors.TreeNodeVisitor;
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

    class TreePrinterVisitor implements TreeNodeVisitor{
        private StringBuilder builder = new StringBuilder();
        private Stack<BasicTreeNode> stack = new Stack<>();

        @Override
        public Object visitNode(BasicTreeNode node) {
            if(!stack.empty()) {
                if (node.getParent() == stack.peek()) {
                    stack.push(node);
                } else {
                    while (node.getParent() != stack.peek()) {
                        stack.pop();
                    }
                    stack.push(node);
                }
            } else {
                stack.push(node);
            }

            char sep = '-';
            StringBuilder tabsBuilder = new StringBuilder();
            for (int i = 0; i < 4 * (stack.size()-1); i++) {
                tabsBuilder.append(sep);
            }
            String tabs = tabsBuilder.toString();

            System.out.println(tabs + node.getData().toString());
            return null;
        }

        StringBuilder getBuilder() {
            return builder;
        }
    }
}
