package datatypes.operations.trees.visitors;

import datatypes.structure.trees.basic.BasicTreeNode;

public interface TreeNodeVisitor {
    Object visitNode(BasicTreeNode node);
}
