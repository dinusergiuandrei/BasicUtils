package datatypes.operations.trees.visitors;

import datatypes.structure.trees.BasicTreeNode;

public interface TreeNodeVisitor {
    Object visitNode(BasicTreeNode node);
}
